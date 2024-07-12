package com.example.demo.chatgpt;

import com.example.demo.location.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.azure.openai.AzureOpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatGptService {
    private final Logger logger = LoggerFactory.getLogger(LocationService.class.getName());
    private final AzureOpenAiChatModel chatModel;

    public ChatGptService(final AzureOpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String AskGpt(String question) {
        logger.info("Asked chatgpt a question: " + question);
        return chatModel.call(question).toLowerCase();
    }

}
