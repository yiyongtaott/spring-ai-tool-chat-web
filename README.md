# spring-ai-tool-chat-web
基于 Spring AI 的全功能单体演示项目：集成工具调用 (Function Calling)、聊天记忆 (Memory) 与流式传输 (Streaming)。采用 Thymeleaf 极简前端，支持 OpenRouter 免费模型。


# Spring AI Omni Starter



这是一个基于 **Spring Boot 3.x** 和 **Spring AI** 构建的单体 Web 项目演示。它展示了如何通过极简的代码实现复杂的 AI 交互逻辑。



## 🌟 核心特性

- **工具调用 (Function Calling)**：演示 AI 如何根据需求自动调用本地 Java 方法（如获取天气、查询数据库）。

- **流式传输 (Streaming)**：实现类似 ChatGPT 的逐字输出效果，提升用户体验。

- **对话记忆 (Chat Memory)**：支持上下文关联，让 AI 能够记住之前的聊天内容。

- **Thymeleaf 极简集成**：无需复杂的前后端分离，一个项目直接启动预览。

- **多模型支持**：预配置了 OpenRouter 接口，可无缝切换 Claude, GPT, Gemini。



## 🚀 快速开始



### 1. 环境准备

- JDK 17+ (推荐 21)

- Maven 3.9+

- 一个 OpenRouter 或 OpenAI 的 API Key



### 2. 配置数据库

导入 `ai_test.sql` 到你的本地数据库（MySQL）。



### 3. 修改配置

在 `src/main/resources/application.yml` 中配置你的 Key：

```yaml

${THE_ONLY_ONE_KEY}


[![LINUX DO](https://img.shields.io/badge/Community-LINUX%20DO-blue?style=flat-square)](https://linux.do/)
