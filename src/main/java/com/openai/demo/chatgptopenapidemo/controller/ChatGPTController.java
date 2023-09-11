package com.openai.demo.chatgptopenapidemo.controller;

import com.openai.demo.chatgptopenapidemo.service.ChatGPTClientService;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "openai", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChatGPTController {

    @Value("${openai.api.chat.default.role}")
    private String defaultRole;

    @Autowired
    private ChatGPTClientService chatGPTClientService;

    @GetMapping("chat/")
    public String chatGptRequest(@RequestParam String prompt) {
        return chatGPTClientService.getChatCompletionRequest(List.of(new ChatMessage(defaultRole, prompt)));
    }

}
