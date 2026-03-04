//package com.flandre.config;
//
//import org.springframework.ai.chat.memory.ChatMemory;
//import org.springframework.ai.chat.messages.AssistantMessage;
//import org.springframework.ai.chat.messages.Message;
//import org.springframework.ai.chat.messages.UserMessage;
//import org.springframework.ai.chat.messages.MessageType;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MyJdbcChatMemory implements ChatMemory {
//
//    private final JdbcTemplate jdbcTemplate;
//    // 定义一个默认读取最近消息的数量
//    private final int DEFAULT_LAST_N = 20;
//
//    public MyJdbcChatMemory(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public void add(String conversationId, List<Message> messages) {
//        for (Message message : messages) {
//            // 注意：最新版 Message 获取文本可能用 getText() 或 getContent()
//            jdbcTemplate.update(
//                    "INSERT INTO chat_history (conversation_id, content, message_type) VALUES (?, ?, ?)",
//                    conversationId, message.getText(), message.getMessageType().name()
//            );
//        }
//    }
//
//    @Override
//    public List<Message> get(String conversationId) {
//        List<Message> messages = jdbcTemplate.query(
//                "SELECT content, message_type FROM chat_history WHERE conversation_id = ? ORDER BY created_at DESC LIMIT ?",
//                (rs, rowNum) -> {
//                    String content = rs.getString("content");
//                    String type = rs.getString("message_type");
//                    if (MessageType.USER.name().equals(type)) return new UserMessage(content);
//                    if (MessageType.ASSISTANT.name().equals(type)) return new AssistantMessage(content);
//                    return null;
//                },
//                conversationId, DEFAULT_LAST_N
//        );
//
//        // 关键点：数据库取出的是倒序（最新的在前面），AI 需要顺序（旧的在前面）
//        Collections.reverse(messages);
//        return messages;
//    }
//
//    @Override
//    public void clear(String conversationId) {
//        jdbcTemplate.update("DELETE FROM chat_history WHERE conversation_id = ?", conversationId);
//    }
//}