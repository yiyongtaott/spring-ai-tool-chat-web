package com.flandre.config;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

/**
 * 建议将工具定义在一个专门的组件类中。
 * 在 Spring AI 1.1.2+ 中，.tools("weatherService") 会扫描该类下所有带 @Tool 的方法。
 */
@Component()
public class ToolService {

    @Tool(description = "查询指定城市的当前天气情况")
    public String getWeather(String request) {
        System.out.println("request = " + request);
        String[] infos = {
                "大雨",
                "小雨",
                "暴雨",
                "梅雨",
                "太阳雨",
        };
        String[] infos2 = {
                "大刀",
                "小刀",
                "匕首",
                "长剑",
                "双手剑",
        };
        String out="天气：" + infos[(int) (Math.random() * 5)] + "转" + infos2[(int) (Math.random() * 5)] + "，请注意避雷。";
        System.out.println("out = " + out);
        return out;
    }


    @Tool(description = "根据天气状况和计划进行的活动，提供详细的穿衣建议")
    public String getClothesAdvice(
            @ToolParam(description = "当前的天气描述，如大雨、太阳雨等") String weather,
            @ToolParam(description = "用户计划进行的活动，如上班、约会、户外运动") String activity) {
        System.out.println("weather = " + weather);
        System.out.println("activity = " + activity);
        String advice = "针对" + weather + "天气下的" + activity + "活动：";
        if (weather.contains("雨")) {
            advice += "建议穿着防水外套，并携带雨具。";
        } else {
            advice += "建议轻便出行。";
        }

        if (activity.contains("运动")) {
            advice += "请选择排汗透气的面料。";
        }
        System.out.println("advice = " + advice);
        return advice;
    }
}