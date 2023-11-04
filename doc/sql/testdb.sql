/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 04/11/2023 18:39:26
*/
CREATE DATABASE `testdb`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_match
-- ----------------------------
DROP TABLE IF EXISTS `t_match`;
CREATE TABLE `t_match`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wx_id1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `wx_id2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_del` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_match
-- ----------------------------
INSERT INTO `t_match` VALUES (1, '111', '2222', 0);
INSERT INTO `t_match` VALUES (2, '333', '444', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wx_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `star` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `height` int(11) NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `school` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hobby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `specialty` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birth_place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(11) NULL DEFAULT 0,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'string', 'string', 'male', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2023-11-02 02:17:33', NULL, '110', 'string', 'string', 'string');
INSERT INTO `user` VALUES (2, '1111', '2222', 'female', NULL, 111, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2222', NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, '110', '李雷', 'male', '白羊座', 25, 188, '本科', '大清学院', '财务', '唱;跳;rap', 'emo', '大清', '热河', '2023-11-04 01:55:24', 0, NULL, '110@gmail.com', 'string', NULL);
INSERT INTO `user` VALUES (7, '111', '韩梅1', 'female', '白羊座', 25, 188, '本科', '大清学院', '财务', '唱;跳;rap', 'emo', '大清', '热河', '2023-11-04 01:55:24', 0, NULL, '110@gmail.com', 'string', NULL);
INSERT INTO `user` VALUES (8, '122', '韩23', 'female', '白羊座', 25, 188, '本科', '大清学院', '财务', '唱;跳;rap', 'emo', '大清', '热河', '2023-11-04 01:55:24', 0, NULL, '110@gmail.com', 'string', NULL);
INSERT INTO `user` VALUES (9, '123', '韩24', 'female', '白羊座', 25, 188, '本科', '大清学院', '财务', '唱;跳;rap', 'emo', '大清', '热河', '2023-11-04 01:55:24', 0, NULL, '110@gmail.com', 'string', NULL);
INSERT INTO `user` VALUES (10, '1125', '李1125', 'male', '白羊座', 25, 188, '本科', '大清学院', '财务', '唱;跳;rap', 'emo', '大清', '热河', '2023-11-04 01:55:24', 0, NULL, '110@gmail.com', 'string', NULL);
INSERT INTO `user` VALUES (11, '127', '李127', 'male', '白羊座', 25, 188, '本科', '大清学院', '财务', '唱;跳;rap', 'emo', '大清', '热河', '2023-11-04 01:55:24', 0, NULL, '110@gmail.com', 'string', NULL);
INSERT INTO `user` VALUES (12, '119', '韩梅梅', 'female', '白羊座', 25, 188, '本科', '大清学院', '财务', '唱;跳;rap', 'emo', '大清', '热河', '2023-11-04 01:59:16', 0, NULL, '110@gmail.com', 'string', NULL);

SET FOREIGN_KEY_CHECKS = 1;
