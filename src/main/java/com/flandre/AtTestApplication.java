package com.flandre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtTestApplication {

    public static void main(String[] args) {
        // HTTP 代理配置
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "7890");

// HTTPS 代理配置
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyPort", "7890");

// 设置不需要走代理的白名单
        System.setProperty("http.nonProxyHosts", "localhost|127.*|[::1]");
        SpringApplication.run(AtTestApplication.class, args);
    }

}
