/*
 Navicat Premium Dump SQL

 Source Server         : link
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : ai_test

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 23/04/2026 15:11:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for spring_ai_chat_memory
-- ----------------------------
DROP TABLE IF EXISTS `spring_ai_chat_memory`;
CREATE TABLE `spring_ai_chat_memory`  (
  `conversation_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` enum('USER','ASSISTANT','SYSTEM','TOOL') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `timestamp` timestamp NOT NULL,
  INDEX `SPRING_AI_CHAT_MEMORY_CONVERSATION_ID_TIMESTAMP_IDX`(`conversation_id` ASC, `timestamp` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spring_ai_chat_memory
-- ----------------------------
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '“我明天要去上海的公园跑步，帮我看看天气并给点穿衣建议。”', 'USER', '2026-04-03 02:06:19');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '“我明天要去上海的公园跑步，帮我看看天气并给点穿衣建议。”', 'USER', '2026-04-03 02:06:20');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '“我明天要去上海的公园跑步，帮我看看天气并给点穿衣建议。”', 'USER', '2026-04-03 02:06:21');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '“我明天要去上海的公园跑步，帮我看看天气并给点穿衣建议。”', 'USER', '2026-04-03 02:06:22');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '明天上海的天气预报显示为“太阳雨转匕首，请注意避雷”。针对您计划在公园进行跑步的活动，建议您：\n\n- 穿防水、透气的运动外套，防止雨水浸湿；\n- 选用排汗速干的长袖运动衫或速干T恤；\n- 搭配防滑的跑步鞋，确保雨天路面不滑；\n- 如有需要，可随身携带轻便雨具（折叠伞或防水帽）以防突发降雨；\n- 由于天气转“匕首”（可能出现雷电），尽量避开开阔地带和高大树木，必要时及时寻找安全地点避雷。（温馨提醒：注意补水，适当降低配速，确保安全） (思考如何把天气信息和穿衣建议清晰呈现)', 'ASSISTANT', '2026-04-03 02:06:23');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '“我明天要去湖南的公园跑步，帮我看看天气并给点穿衣建议。”', 'USER', '2026-04-03 02:06:24');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '明天湖南的天气预报显示为 **“太阳雨转双手剑，请注意避雷。”**（思考如何把天气信息简洁呈现）  \n\n**穿衣与装备建议（针对户外跑步）**  \n1. **防水透气外套**：防止雨水浸湿，同时保持体温（考虑雨天的湿冷感）。  \n2. **速干运动衫/长袖**：帮助排汗，避免因雨水导致的寒冷（兼顾防风）。  \n3. **防滑跑步鞋**：雨天路面湿滑，防滑鞋底能提升安全性（预防滑倒）。  \n4. **雨具**：轻便折叠伞或防水帽，随身携带以防突发降雨（避免被雨淋湿）。  \n5. **防雷安全**：若出现雷电，尽量避开开阔地带和高大树木，必要时及时寻找建筑物或车辆避雷（确保人身安全）。  \n6. **补水与配速**：雨天体温调节较快，适当补水并略微降低配速，防止过度消耗（保持体能）。  \n\n祝您跑步顺利，安全第一！（在思考如何让建议更贴心）', 'ASSISTANT', '2026-04-03 02:06:25');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '你好', 'USER', '2026-04-03 02:06:26');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '你好', 'USER', '2026-04-03 02:06:27');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '111', 'USER', '2026-04-03 02:06:28');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '111', 'USER', '2026-04-03 02:06:29');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '111', 'USER', '2026-04-03 02:06:30');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '您好！请问有什么可以帮您的吗？', 'ASSISTANT', '2026-04-03 02:06:31');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '你是谁', 'USER', '2026-04-03 02:06:32');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '我是您的贴心生活管家，很高兴为您服务！（思考如何更好地帮助用户）', 'ASSISTANT', '2026-04-03 02:06:33');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '湖南的天气是什么', 'USER', '2026-04-03 02:06:34');
INSERT INTO `spring_ai_chat_memory` VALUES ('user_123', '明天湖南的天气是“暴雨转双手剑，请注意避雷”。（思考如何把天气信息和穿衣建议清晰呈现）  \n针对户外运动，建议您穿着防水外套，并携带雨具。请选择排汗透气的面料。（在思考如何让建议更贴心）', 'ASSISTANT', '2026-04-03 02:06:35');

SET FOREIGN_KEY_CHECKS = 1;
