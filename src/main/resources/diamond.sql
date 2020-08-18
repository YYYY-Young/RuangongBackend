/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : diamond

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 18/08/2020 14:26:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `path` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name_zh` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `icon_cls` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `component` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES (1, '/admin', 'AdminIndex', '首页', 'el-icon-s-home', 'AdminIndex', 0);
INSERT INTO `admin_menu` VALUES (2, '/admin/dashboard', 'DashboardAdmin', '运行情况', NULL, 'dashboard/admin/index', 1);
INSERT INTO `admin_menu` VALUES (3, '/admin', 'User', '用户管理', 'el-icon-user', 'AdminIndex', 0);
INSERT INTO `admin_menu` VALUES (4, '/admin', 'Content', '内容管理', 'el-icon-tickets', 'AdminIndex', 0);
INSERT INTO `admin_menu` VALUES (5, '/admin', 'System', '系统配置', 'el-icon-s-tools', 'AdminIndex', 0);
INSERT INTO `admin_menu` VALUES (6, '/admin/user/profile', 'Profile', '用户信息', NULL, 'user/UserProfile', 3);
INSERT INTO `admin_menu` VALUES (7, '/admin/user/role', 'Role', '角色配置', NULL, 'user/Role', 3);
INSERT INTO `admin_menu` VALUES (8, '/admin/content/book', 'BookManagement', '图书管理', NULL, 'content/BookManagement', 4);
INSERT INTO `admin_menu` VALUES (9, '/admin/content/banner', 'BannerManagement', '广告管理', NULL, 'content/BannerManagement', 4);
INSERT INTO `admin_menu` VALUES (10, '/admin/content/article', 'ArticleManagement', '文章管理', NULL, 'content/ArticleManagement', 4);

-- ----------------------------
-- Table structure for admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_permission`;
CREATE TABLE `admin_permission`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc_` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_permission
-- ----------------------------
INSERT INTO `admin_permission` VALUES (1, 'users_management', '用户管理', '/api/admin/user');
INSERT INTO `admin_permission` VALUES (2, 'roles_management', '角色管理', '/api/admin/role');
INSERT INTO `admin_permission` VALUES (3, 'content_management', '内容管理', '/api/admin/content');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_zh` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, 'sysAdmin', '系统管理员', 1);
INSERT INTO `admin_role` VALUES (2, 'contentManager', '内容管理员', 1);
INSERT INTO `admin_role` VALUES (3, 'visitor', '访客', 1);
INSERT INTO `admin_role` VALUES (9, 'test', '测试角色', 1);

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rid` int NULL DEFAULT NULL,
  `mid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 204 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------
INSERT INTO `admin_role_menu` VALUES (194, 1, 1);
INSERT INTO `admin_role_menu` VALUES (195, 1, 2);
INSERT INTO `admin_role_menu` VALUES (196, 1, 3);
INSERT INTO `admin_role_menu` VALUES (197, 1, 6);
INSERT INTO `admin_role_menu` VALUES (198, 1, 7);
INSERT INTO `admin_role_menu` VALUES (199, 1, 4);
INSERT INTO `admin_role_menu` VALUES (200, 1, 8);
INSERT INTO `admin_role_menu` VALUES (201, 1, 9);
INSERT INTO `admin_role_menu` VALUES (202, 1, 10);
INSERT INTO `admin_role_menu` VALUES (203, 1, 5);

-- ----------------------------
-- Table structure for admin_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_permission`;
CREATE TABLE `admin_role_permission`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rid` int NULL DEFAULT NULL,
  `pid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_role_permission_role_1`(`rid`) USING BTREE,
  INDEX `fk_role_permission_permission_1`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_permission
-- ----------------------------
INSERT INTO `admin_role_permission` VALUES (140, 1, 1);
INSERT INTO `admin_role_permission` VALUES (141, 1, 2);
INSERT INTO `admin_role_permission` VALUES (142, 1, 3);

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NULL DEFAULT NULL,
  `rid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_operator_role_operator_1`(`uid`) USING BTREE,
  INDEX `fk_operator_role_role_1`(`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES (64, 1, 1);
INSERT INTO `admin_user_role` VALUES (69, 110, 3);
INSERT INTO `admin_user_role` VALUES (72, 111, 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `docid` int NOT NULL,
  `uid` int NOT NULL,
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (11, 10, 1, '1212121212', '2020-08-17 10:37:36');
INSERT INTO `comment` VALUES (12, 9, 110, 'wowwwwwwwwwwwww', '2020-08-18 11:44:30');

-- ----------------------------
-- Table structure for doc
-- ----------------------------
DROP TABLE IF EXISTS `doc`;
CREATE TABLE `doc`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `doc_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `doc_content_html` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `doc_content_md` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `doc_abstract` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `doc_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '',
  `doc_found_date` datetime(0) NULL DEFAULT NULL,
  `doc_founder` int NULL DEFAULT NULL,
  `doc_team` int NULL DEFAULT 0,
  `doc_only_team` tinyint NULL DEFAULT 0,
  `doc_read` tinyint NULL DEFAULT 0,
  `doc_edit` tinyint NULL DEFAULT 0,
  `doc_comment` tinyint NULL DEFAULT 0,
  `doc_delete` tinyint NULL DEFAULT 0,
  `doc_share` tinyint NULL DEFAULT 0,
  `doc_recycle` tinyint NULL DEFAULT 0,
  `doc_isedit` tinyint NULL DEFAULT 0,
  `doc_last_edit_uid` int NULL DEFAULT NULL,
  `doc_last_edit_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doc
-- ----------------------------
INSERT INTO `doc` VALUES (6, 'test6', 'test1test1', 'test1test1test1', 'test123', 'test132', '2020-08-12 00:00:00', 1, 1, 1, 1, 1, 1, 1, 0, 0, NULL, 1, '2020-08-12 13:38:10');
INSERT INTO `doc` VALUES (7, 'test6', 'test1test1', 'test1test1test1', 'test123', 'test132', '2020-08-12 00:00:00', 1, 1, 1, 1, 1, 1, 1, 0, 0, NULL, 110, '2020-08-12 13:38:10');
INSERT INTO `doc` VALUES (8, '88888888', '<p>asasasasasa</p>\n', 'asasasasasa', 'default abstract', '', '2020-08-14 00:00:00', 1, 0, 0, 1, 1, 1, 0, 1, 0, NULL, 1, '2020-08-14 01:53:53');
INSERT INTO `doc` VALUES (9, 'hehehahei', '<p>jiushizheyang</p>\n', 'jiushizheyang', 'default abstract', '', '2020-08-14 00:00:00', 1, 0, 0, 1, 1, 1, 0, 1, 0, NULL, 1, '2020-08-14 02:27:11');
INSERT INTO `doc` VALUES (10, '为了66666', '<p>就是为了666666666666888</p>\n<h2><a id=\"hhah_1\"></a>hhah</h2>\n<p>haaaaaaaaaaaaaaaaaaaa</p>\n', '就是为了666666666666888\n## hhah\nhaaaaaaaaaaaaaaaaaaaa', '还是为了666', '', '2020-08-14 00:00:00', 1, 0, 0, 1, 1, 1, 0, 1, 0, NULL, 112, '2020-08-14 09:53:01');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `teamname` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `leaderid` int NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (1, 'happy', 'hahaha', 1, '2020-08-16 16:26:01');
INSERT INTO `team` VALUES (2, 'sad', 'wuwuwu', 1, '2020-08-15 16:26:09');
INSERT INTO `team` VALUES (100, 'wudi', 'kuuuuuuuuuuuuuuu', 1, '2020-08-17 16:27:10');
INSERT INTO `team` VALUES (101, 'wudiaaa', 'kuuuuuuuuuuuuuuu', 1, '2020-08-17 16:52:16');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '823a1c89091410b9401cbd0af49e0a14', 'YKUZfeV/DKVdD5DDUopMPg==', '1111111', 'app@app.com', 1, '100000');
INSERT INTO `user` VALUES (110, 'zhangyang', '8bc7251dbacf9cebd610ad7b9d884af8', 'srJMpKunt3/rwfXYaHIc8A==', '1212121', '2323232@qq.com', 1, '100000');
INSERT INTO `user` VALUES (111, 'xiaoming', '6bc5c580ff51ad78a04fb0b99c7b7347', 'ZU4QNGQFaIwX7Z6ACU0New==', '1212121', '2323232@qq.com', 1, '100000');
INSERT INTO `user` VALUES (112, 'hahaha', 'af78efad4c6f6da0258ce1891f870590', '+2jvsC133Qs1ggpCiMws+w==', '19988726262', '2010169473@qq.com', 1, '100000');

-- ----------------------------
-- Table structure for user_doc
-- ----------------------------
DROP TABLE IF EXISTS `user_doc`;
CREATE TABLE `user_doc`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NULL DEFAULT 0,
  `docid` int NULL DEFAULT 0,
  `doc_read` tinyint NULL DEFAULT 0,
  `doc_edit` tinyint NULL DEFAULT 0,
  `doc_delete` tinyint NULL DEFAULT 0,
  `doc_comment` tinyint NULL DEFAULT 0,
  `commentid` int NULL DEFAULT 0,
  `doc_share` tinyint NULL DEFAULT 0,
  `doc_share_uid` int NULL DEFAULT 0,
  `doc_like` tinyint NULL DEFAULT 0,
  `doc_open_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `doc_open_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 468 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_doc
-- ----------------------------
INSERT INTO `user_doc` VALUES (196, 1, 3, 0, 1, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 14:16:40');
INSERT INTO `user_doc` VALUES (197, 1, 3, 0, 1, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 14:23:48');
INSERT INTO `user_doc` VALUES (199, 110, 3, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 14:34:19');
INSERT INTO `user_doc` VALUES (200, 110, 3, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 14:36:31');
INSERT INTO `user_doc` VALUES (201, 1, 3, 0, 1, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 14:40:26');
INSERT INTO `user_doc` VALUES (202, 1, 3, 0, 1, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 14:43:43');
INSERT INTO `user_doc` VALUES (205, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 15:03:54');
INSERT INTO `user_doc` VALUES (206, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 15:07:31');
INSERT INTO `user_doc` VALUES (207, 110, 0, 0, 1, 0, 0, 0, 0, 0, 0, NULL, '2020-08-12 15:08:26');
INSERT INTO `user_doc` VALUES (308, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 01:53:53');
INSERT INTO `user_doc` VALUES (311, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:27:11');
INSERT INTO `user_doc` VALUES (316, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:51:49');
INSERT INTO `user_doc` VALUES (319, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:51:53');
INSERT INTO `user_doc` VALUES (320, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:51:53');
INSERT INTO `user_doc` VALUES (326, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:52:06');
INSERT INTO `user_doc` VALUES (332, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:52:23');
INSERT INTO `user_doc` VALUES (337, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:55:39');
INSERT INTO `user_doc` VALUES (338, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:55:39');
INSERT INTO `user_doc` VALUES (339, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:55:41');
INSERT INTO `user_doc` VALUES (340, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:55:41');
INSERT INTO `user_doc` VALUES (349, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:57:34');
INSERT INTO `user_doc` VALUES (351, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:57:37');
INSERT INTO `user_doc` VALUES (352, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:57:37');
INSERT INTO `user_doc` VALUES (353, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:57:57');
INSERT INTO `user_doc` VALUES (354, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:57:57');
INSERT INTO `user_doc` VALUES (355, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:58:00');
INSERT INTO `user_doc` VALUES (356, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 02:58:00');
INSERT INTO `user_doc` VALUES (357, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:17:03');
INSERT INTO `user_doc` VALUES (358, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:17:03');
INSERT INTO `user_doc` VALUES (359, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:17:09');
INSERT INTO `user_doc` VALUES (360, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:17:09');
INSERT INTO `user_doc` VALUES (361, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:17:35');
INSERT INTO `user_doc` VALUES (362, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:17:35');
INSERT INTO `user_doc` VALUES (400, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:21:57');
INSERT INTO `user_doc` VALUES (401, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:23:40');
INSERT INTO `user_doc` VALUES (402, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:23:40');
INSERT INTO `user_doc` VALUES (403, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:23:53');
INSERT INTO `user_doc` VALUES (404, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:23:53');
INSERT INTO `user_doc` VALUES (405, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:24:05');
INSERT INTO `user_doc` VALUES (406, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:24:05');
INSERT INTO `user_doc` VALUES (407, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:24:11');
INSERT INTO `user_doc` VALUES (408, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:24:15');
INSERT INTO `user_doc` VALUES (409, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:24:15');
INSERT INTO `user_doc` VALUES (410, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:50:46');
INSERT INTO `user_doc` VALUES (411, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:50:46');
INSERT INTO `user_doc` VALUES (412, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:50:56');
INSERT INTO `user_doc` VALUES (413, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:50:56');
INSERT INTO `user_doc` VALUES (414, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:51:09');
INSERT INTO `user_doc` VALUES (415, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:51:11');
INSERT INTO `user_doc` VALUES (416, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:51:11');
INSERT INTO `user_doc` VALUES (417, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:51:16');
INSERT INTO `user_doc` VALUES (418, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:51:16');
INSERT INTO `user_doc` VALUES (419, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:51:51');
INSERT INTO `user_doc` VALUES (420, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:51:51');
INSERT INTO `user_doc` VALUES (421, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:52:05');
INSERT INTO `user_doc` VALUES (422, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:52:05');
INSERT INTO `user_doc` VALUES (423, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:52:52');
INSERT INTO `user_doc` VALUES (424, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:52:52');
INSERT INTO `user_doc` VALUES (425, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:53:01');
INSERT INTO `user_doc` VALUES (426, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:53:10');
INSERT INTO `user_doc` VALUES (427, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:53:10');
INSERT INTO `user_doc` VALUES (428, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:53:13');
INSERT INTO `user_doc` VALUES (429, 112, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 09:53:13');
INSERT INTO `user_doc` VALUES (430, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 15:17:29');
INSERT INTO `user_doc` VALUES (431, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 15:17:29');
INSERT INTO `user_doc` VALUES (432, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 15:17:50');
INSERT INTO `user_doc` VALUES (433, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-14 15:17:50');
INSERT INTO `user_doc` VALUES (434, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:50:55');
INSERT INTO `user_doc` VALUES (435, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:50:55');
INSERT INTO `user_doc` VALUES (436, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:50:58');
INSERT INTO `user_doc` VALUES (437, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:50:58');
INSERT INTO `user_doc` VALUES (438, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:51:01');
INSERT INTO `user_doc` VALUES (439, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:51:01');
INSERT INTO `user_doc` VALUES (440, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:51:26');
INSERT INTO `user_doc` VALUES (441, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:51:26');
INSERT INTO `user_doc` VALUES (442, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:51:29');
INSERT INTO `user_doc` VALUES (443, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:51:29');
INSERT INTO `user_doc` VALUES (444, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:51:32');
INSERT INTO `user_doc` VALUES (445, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-16 00:51:32');
INSERT INTO `user_doc` VALUES (446, 1, 10, 1, 0, 0, 1, 0, 1, 0, 1, NULL, '2020-08-16 01:41:40');
INSERT INTO `user_doc` VALUES (466, 1, 10, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-17 11:09:14');
INSERT INTO `user_doc` VALUES (467, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, NULL, '2020-08-17 20:40:09');
INSERT INTO `user_doc` VALUES (468, 1, 10, 0, 0, 0, 0, 0, 1, 110, 0, '推荐你看', '2020-08-18 11:15:06');

-- ----------------------------
-- Table structure for user_team
-- ----------------------------
DROP TABLE IF EXISTS `user_team`;
CREATE TABLE `user_team`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NULL DEFAULT NULL,
  `tid` int NULL DEFAULT NULL,
  `issys` tinyint NULL DEFAULT NULL,
  `isaccept` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_team
-- ----------------------------
INSERT INTO `user_team` VALUES (1, 1, 1, 1, 1);
INSERT INTO `user_team` VALUES (3, 111, 2, 0, 1);
INSERT INTO `user_team` VALUES (5, 1, 101, 1, 1);
INSERT INTO `user_team` VALUES (9, 110, 1, 0, 1);
INSERT INTO `user_team` VALUES (10, 112, 1, 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
