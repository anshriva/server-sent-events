package com.anubhav.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/simple")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class SimpleController {
    @GetMapping("/users")
    public void getUsers(HttpServletResponse response) throws IOException, InterruptedException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Connection", "keep-alive");
        PrintWriter out = response.getWriter();

        // Sending a comment line to establish the SSE connection
        out.write(":\n");

        for(int i =0 ;i< 100;i++){
            out.write("data: event data" + i + "\n\n");
            out.flush();
            Thread.sleep(2000);
        }
        out.close();
    }
}
