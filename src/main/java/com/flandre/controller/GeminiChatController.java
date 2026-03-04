package com.flandre.controller;

import com.flandre.config.ToolService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.web.bind.annotation.PostMapping; // 改为 Post
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
                .advisors(MessageChatMemoryAdvisor.builder(chatMemory)
                        .conversationId(default_user)
                        .build())
                .user(u -> u.text("【规则】：每句话结尾加小括号并注明内心活动。\n---\n问题：{msg}")
                        .param("msg", message))
                .stream()
                .chatResponse(); // 这里返回完整的响应对象，包含元数据
    }

/*    // 提交聊天用 Post
    @PostMapping("/chat")
    public String chat(
            @RequestParam String message,
            @RequestParam String default_user,
            Model model) {
        System.out.println("message: " + message);
        System.out.println("default_user: " + default_user);
        if (message != null && !message.isBlank()) {
            var chatResponse = this.chatClient.prompt()
                    .tools(toolService)
                    .advisors(MessageChatMemoryAdvisor.builder(chatMemory).conversationId(default_user).build())
                    .user(u -> u.text("【规则】：每句话结尾加小括号并注明内心活动。\n---\n问题：{msg}")
                            .param("msg", message))
                    .call()
                    .chatResponse();

            // 2. 提取内容和元数据
            String responseContent = chatResponse.getResult().getOutput().getText();
            var metadata = chatResponse.getMetadata();
            var usage = metadata.getUsage();

            // 3. 将信息存入 model
            model.addAttribute("userMessage", message);
            model.addAttribute("aiResponse", responseContent);

            // 消耗统计
            model.addAttribute("promptTokens", usage.getPromptTokens());
            model.addAttribute("generationTokens", usage.getCompletionTokens());
            model.addAttribute("totalTokens", usage.getTotalTokens());

            // 其他有用信息
            model.addAttribute("modelName", metadata.getModel());
            model.addAttribute("finishReason", chatResponse.getResult().getMetadata().getFinishReason());

            System.out.println("aiResponse: " + responseContent);
        }
        return "chat";
    }*/

}