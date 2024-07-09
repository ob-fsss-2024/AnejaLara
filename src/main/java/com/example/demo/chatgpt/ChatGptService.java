package com.example.demo.chatgpt;

import org.springframework.ai.azure.openai.AzureOpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatGptService {
    private final AzureOpenAiChatModel chatModel;

    public ChatGptService(final AzureOpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String AskGpt(String question) {
        return chatModel.call(question).toLowerCase();
    }

}
