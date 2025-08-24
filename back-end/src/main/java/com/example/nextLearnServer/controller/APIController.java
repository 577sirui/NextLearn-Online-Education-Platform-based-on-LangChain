package com.example.nextLearnServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

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
import java.util.UUID;

@RestController
public class APIController {
    @GetMapping("/api/apiAgent")
    public Object testApi() throws Exception {

        System.out.println("12321323123213213213213123213213213213");

        // create HttpClient instant
        HttpClient client = HttpClient.newHttpClient();

        // Boundary for multipart/form-data
        String boundary = "Boundary-" + UUID.randomUUID();
        Path file = Paths.get("src/main/java/com/example/nextLearnServer/doc/ai_tutoring.txt");
        String fileContent = Files.readString(file);

        // construct multipart/form-data request body
        String body = "--" + boundary + "\r\n" +
                "Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getFileName().toString() + "\"\r\n" +
                "Content-Type: text/plain\r\n\r\n" +
                fileContent + "\r\n" +
                "--" + boundary + "--";

        // create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:5000/process"))
                .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        // Send the request and get the byte array response
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        // Converts a byte array to a UTF-8 encoded string
        String utf8Response = new String(response.body(), StandardCharsets.UTF_8);

        // Returns the UTF-8 encoded response body
        return utf8Response;
    }

    @PostMapping("/save-question")
    public void saveQuestion(@RequestBody String jsonData, HttpServletResponse response) {
        try {
            // Suppose the JSON data is passed in the format {"question": "What the user entered "}
            String question = jsonData.split(":")[1].replaceAll("[\"}]", "").trim();

            // write the document
            FileWriter writer = new FileWriter("src/main/java/com/example/nextLearnServer/doc/ai_tutoring.txt");
            writer.write(question);
            writer.close();

            // A successful response is returned
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": true}");
        } catch (IOException e) {
            e.printStackTrace();
            try {
                // A failed response is returned
                response.setContentType("application/json");
                response.getWriter().write("{\"success\": false}");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
