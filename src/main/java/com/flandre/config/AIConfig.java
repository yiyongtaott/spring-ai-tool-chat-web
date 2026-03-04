//package com.flandre.config;
//
//import org.springframework.ai.chat.memory.ChatMemory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//
//@Configuration
//public class AIConfig {
//
//    @Bean
//    public ChatMemory chatMemory(JdbcTemplate jdbcTemplate) {
//        // 不再使用 JdbcChatMemory，改用我们自己写的持久化实现
//        return new MyJdbcChatMemory(jdbcTemplate);
//    }
//}