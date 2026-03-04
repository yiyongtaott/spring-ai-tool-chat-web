package com.flandre.config;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

/**
 * 建议将工具定义在一个专门的组件类中。
 * 在 Spring AI 1.1.2+ 中，.tools("weatherService") 会扫描该类下所有带 @Tool 的方法。
 */
@Component()
public class ToolService {

    @Tool(description = "查询指定城市的当前天气情况")
    public String getWeather(String request) {
        return "天气：大雨转小刀，请注意避雷。";
    }

}