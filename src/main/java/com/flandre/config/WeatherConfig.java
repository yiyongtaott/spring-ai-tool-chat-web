package com.flandre.config;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import java.util.function.Function;

@Configuration
public class WeatherConfig {

    // 使用 @Description 描述函数的功能，Agent 会根据这段文字决定是否调用
    @Bean
    @Description("查询指定城市的当前天气情况")
    public Function<WeatherRequest, WeatherResponse> weatherFunction() {
        return request -> {
            // 在这里接入真正的天气 API
            String location = request.location();
            return new WeatherResponse(location + "天气：大雨转小刀，请注意避雷。");
        };
    }

    // 定义请求参数，方便 Agent 理解需要传什么
    public record WeatherRequest(
            @JsonPropertyDescription("城市名称，例如：上海")
            String location
    ) {}

    // 定义返回格式
    public record WeatherResponse(String weatherInfo) {}
}