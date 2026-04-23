package com.flandre.controller;

import com.flandre.config.ToolService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;


@Controller
//2026-03-04
public class GeminiChatController {
    private final ChatMemory chatMemory;
    private final ChatClient chatClient;
    private final ToolService toolService;

    public GeminiChatController(ChatMemory chatMemory, ChatClient.Builder builder, ToolService toolService) {
        this.chatMemory = chatMemory;
        this.chatClient = builder.build();
        this.toolService = toolService;
    }

    // 初始进入页面用 Get
    @GetMapping("/chat")
    public String chatIndex() {
        return "chat";
    }

    @GetMapping("/")
    public String index() {
        return "chat";
    }

    /**
     * 流式响应接口：生产流媒体类型文本
     */
    @PostMapping(value = "/api/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<ChatResponse> streamChat(
            @RequestParam String message,
            @RequestParam String default_user) {

        return this.chatClient.prompt()
                .tools(toolService)
                .system(s -> s.text("""
                        你是贴心的生活管家。
                        当用户询问建议时，你必须执行以下流程：
                        1. 调用 getWeather 查询天气。
                        2. 根据天气结果调用 getClothesAdvice 获取建议。
                        3. 最后统一回复用户。
                        
                        【强制规则】：每句话结尾必须加小括号并注明内心活动。
                        """))
                .advisors(MessageChatMemoryAdvisor.builder(chatMemory)
                        .conversationId(default_user)
                        .build())
                .user(u -> u.text("{msg}").param("msg", message))
                .stream()
                .chatResponse(); // 这里返回完整的响应对象，包含元数据
    }

}