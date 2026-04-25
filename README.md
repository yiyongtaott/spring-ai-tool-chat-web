# spring-ai-tool-chat-web

基于 **Spring AI** 的全功能单体演示项目：集成工具调用 (Function Calling)、聊天记忆 (Memory) 与流式传输 (Streaming)。采用 Thymeleaf 极简前端，支持 OpenRouter 免费模型。

## 🌟 核心特性

- **工具调用 (Function Calling)**：演示 AI 如何根据需求自动调用本地 Java 方法（如获取天气、查询数据库），实现逻辑层的参数同步。
- **流式传输 (Streaming)**：实现类似 ChatGPT 的逐字输出效果，优化系统响应感官。
- **对话记忆 (Chat Memory)**：支持上下文关联，确保 AI 在会话周期内维持状态一致性。
- **Thymeleaf 极简集成**：无需复杂的前后端分离，单一镜像环境即可直接启动。
- **多模型支持**：预配置 OpenRouter 接口，支持在不同底层模型间无缝切换。

## 🚀 快速开始

### 1. 环境准备

- **JDK**: 17+ (推荐 21)
- **Maven**: 3.9+
- **API Key**: 一个 OpenRouter 或 OpenAI 的有效凭证

### 2. 配置数据库

将 `ai_test.sql` 脚本导入至您的本地数据库环境（如 MySQL），以初始化必要的存储参数。

### 3. 修改配置

在 `src/main/resources/application.yml` 中配置您的核心密钥：

```yaml
api-key: ${THE_ONLY_ONE_KEY}
```

---

## 🔗 友情链接

| 社区平台 | 链接 |
| :--- | :--- |
| **LINUX DO** | [![LINUX DO](https://img.shields.io/badge/Community-LINUX%20DO-blue?style=flat-square)](https://linux.do/) |
