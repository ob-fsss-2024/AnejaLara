package com.example.demo.chatgpt;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("gpt")
public class ChatGptController {
    private final ChatGptService gpt;

    public ChatGptController(ChatGptService gpt) {
        this.gpt = gpt;
    }


    @GetMapping("/askchatgpt/{question}")
    public String helloWorldPost(@PathVariable String question) {
        return gpt.AskGpt(question);
    }
}
