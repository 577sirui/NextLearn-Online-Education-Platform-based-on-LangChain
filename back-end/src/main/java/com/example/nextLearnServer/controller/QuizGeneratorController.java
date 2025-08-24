package com.example.nextLearnServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@RestController
public class QuizGeneratorController {

    private static final Path filePath = Paths.get("src/main/java/com/example/nextLearnServer/doc/QuizReq.txt");

    // POST request: Receives JSON data and writes it to a local file
    @PostMapping("/save-quiz")
    public void saveQuestionToFile(@RequestBody Map<String, String> requestData, HttpServletResponse response) {
        try (FileWriter writer = new FileWriter(filePath.toFile())) {
            // Write JSON data to a file, with each key-value pair occupying a line
            writer.write("questionType: " + requestData.get("questionType") + "\n");
            writer.write("difficulty: " + requestData.get("difficulty") + "\n");
            writer.write("numberOfQuestions: " + requestData.get("numberOfQuestions") + "\n");
            writer.write("course: " + requestData.get("course") + "\n");
            writer.flush();

            // Return successful response
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": true, \"message\": \"File written successfully.\"}");
        } catch (IOException e) {
            e.printStackTrace();
            try {
                response.setContentType("application/json");
                response.getWriter().write("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // GET请求：读取文件内容并将其作为multipart/form-data上传至Flask端
    @GetMapping("/get-quiz")
    public Object uploadFileToFlask() {
        try {
            // 创建HttpClient实例
            HttpClient client = HttpClient.newHttpClient();

            // Boundary 用于multipart/form-data
            String boundary = "Boundary-" + UUID.randomUUID();

            // 读取文件内容并构造multipart/form-data请求体
            String fileContent = Files.readString(filePath, StandardCharsets.UTF_8);
            String body = "--" + boundary + "\r\n" +
                    "Content-Disposition: form-data; name=\"file\"; filename=\"" + filePath.getFileName().toString() + "\"\r\n" +
                    "Content-Type: text/plain\r\n\r\n" +
                    fileContent + "\r\n" +
                    "--" + boundary + "--";

            // 创建HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:5003/process"))
                    .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            // 发送请求并获取字节数组响应
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            // 将字节数组转换为UTF-8编码的字符串
            String utf8Response = new String(response.body(), StandardCharsets.UTF_8);

            // 返回Flask响应内容
            return utf8Response;

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"success\": false, \"error\": \"" + e.getMessage() + "\"}";
        }
    }
}
