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
public class LearningPlanController {

    private static final Path filePath = Paths.get("src/main/java/com/example/nextLearnServer/doc/LearningPlanReq.txt");

    // POST request: Receives JSON data and writes it to a local file
    @PostMapping("/save-learningPlan")
    public void saveQuestionToFile(@RequestBody Map<String, String> requestData, HttpServletResponse response) {
        try (FileWriter writer = new FileWriter(filePath.toFile())) {
            // Write JSON data to a file, with each key-value pair occupying a line
            writer.write("subject: " + requestData.get("subject") + "\n");
            writer.write("goals: " + requestData.get("goals") + "\n");
            writer.write("duration: " + requestData.get("duration") + "\n");
            writer.write("learningStyle: " + requestData.get("learningStyle") + "\n");
            writer.write("dateRange: " + requestData.get("dateRange") + "\n");
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

    // GET request: Read the contents of the file and upload it to Flask as multipart/form-data
    @GetMapping("/get-learningPlan")
    public Object uploadFileToFlask() {
        try {
            // create HttpClient instant
            HttpClient client = HttpClient.newHttpClient();

            // Boundary for multipart/form-data
            String boundary = "Boundary-" + UUID.randomUUID();

            // Read the file contents and construct the multipart/form-data request body
            String fileContent = Files.readString(filePath, StandardCharsets.UTF_8);
            String body = "--" + boundary + "\r\n" +
                    "Content-Disposition: form-data; name=\"file\"; filename=\"" + filePath.getFileName().toString() + "\"\r\n" +
                    "Content-Type: text/plain\r\n\r\n" +
                    fileContent + "\r\n" +
                    "--" + boundary + "--";

            // create HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:5002/process"))
                    .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            // Send the request and get the byte array response
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            // Converts a byte array to a UTF-8 encoded string
            String utf8Response = new String(response.body(), StandardCharsets.UTF_8);

            // Return Flask response content
            return utf8Response;

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"success\": false, \"error\": \"" + e.getMessage() + "\"}";
        }
    }
}
