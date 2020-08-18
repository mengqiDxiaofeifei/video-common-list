/*
 Navicat Premium Data Transfer

 Source Server         : tengxun
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 111.229.237.223:3306
 Source Schema         : video-db

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 18/08/2020 14:22:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for send_code
-- ----------------------------
DROP TABLE IF EXISTS `send_code`;
CREATE TABLE `send_code`  (
  `id` int(11) NOT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `send_time` datetime(0) DEFAULT NULL,
  `type` int(255) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `permission_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限code',
  `permission_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 'create_user', '创建用户');
INSERT INTO `sys_permission` VALUES (2, 'query_user', '查看用户');
INSERT INTO `sys_permission` VALUES (3, 'delete_user', '删除用户');
INSERT INTO `sys_permission` VALUES (4, 'modify_user', '修改用户');

-- ----------------------------
-- Table structure for sys_request_path
-- ----------------------------
DROP TABLE IF EXISTS `sys_request_path`;
CREATE TABLE `sys_request_path`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求路径',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路径描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '请求路径' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_request_path
-- ----------------------------
INSERT INTO `sys_request_path` VALUES (1, '/getUser', '查询用户');

-- ----------------------------
-- Table structure for sys_request_path_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_request_path_permission_relation`;
CREATE TABLE `sys_request_path_permission_relation`  (
  `id` int(11) DEFAULT NULL COMMENT '主键id',
  `url_id` int(11) DEFAULT NULL COMMENT '请求路径id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '路径权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_request_path_permission_relation
-- ----------------------------
INSERT INTO `sys_request_path_permission_relation` VALUES (NULL, 1, 2);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色码',
  `role_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', '管理员，拥有所有权限');
INSERT INTO `sys_role` VALUES (2, 'user', '普通用户', '普通用户，拥有部分权限');

-- ----------------------------
-- Table structure for sys_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission_relation`;
CREATE TABLE `sys_role_permission_relation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-权限关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission_relation
-- ----------------------------
INSERT INTO `sys_role_permission_relation` VALUES (1, 1, 1);
INSERT INTO `sys_role_permission_relation` VALUES (2, 1, 2);
INSERT INTO `sys_role_permission_relation` VALUES (3, 1, 3);
INSERT INTO `sys_role_permission_relation` VALUES (4, 1, 4);
INSERT INTO `sys_role_permission_relation` VALUES (5, 2, 1);
INSERT INTO `sys_role_permission_relation` VALUES (6, 2, 2);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `last_login_time` datetime(0) DEFAULT NULL COMMENT '上一次登陆时间',
  `enabled` tinyint(1) DEFAULT 1 COMMENT '账号是否可用。默认1（可用）',
  `account_non_expired` tinyint(1) DEFAULT 1 COMMENT '是否过期。默认1（没有过期）',
  `account_non_locked` tinyint(1) DEFAULT 1 COMMENT '账号是否锁定。默认1（没有锁定）',
  `credentials_non_expired` tinyint(1) DEFAULT 1 COMMENT '证书（密码）是否过期。默认1（没有过期）',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'user1', '用户1', '$2a$10$47lsFAUlWixWG17Ca3M/r.EPJVIb7Tv26ZaxhzqN65nXVcAhHQM4i', '2020-08-17 09:46:53', 1, 1, 1, 1, '2019-08-29 06:28:36', '2020-08-17 09:46:53', 1, 1, NULL);
INSERT INTO `sys_user` VALUES (2, 'user2', '用户2', '$2a$10$uSLAeON6HWrPbPCtyqPRj.hvZfeM.tiVDZm24/gRqm4opVze1cVvC', '2019-09-05 00:07:12', 1, 1, 1, 1, '2019-08-29 06:29:24', '2019-09-05 00:07:12', 1, 2, NULL);
INSERT INTO `sys_user` VALUES (3, 'guoyuehe', 'guoyuehe', '$2a$10$3TSATEV0kj2vr7uJnaglveF1vsCbvlTpGUn.HhufXk124Gi8dHNRS', '2020-08-17 14:04:58', 1, 1, 1, 1, '2020-08-17 10:53:24', '2020-08-17 14:04:58', 1, 3, NULL);
INSERT INTO `sys_user` VALUES (4, 'guoyuehe123', 'guoyuehe123', '$2a$10$zab6ZsLR81VuNS67L2l1Q.edsQr0zvOJUXN1pIDLC2/TTsvY6Bi6O', '2020-08-17 17:09:44', 1, 1, 1, 1, '2020-08-17 14:23:48', '2020-08-17 17:09:44', NULL, 4, '17320406595');
INSERT INTO `sys_user` VALUES (5, 'zhouhoujun', 'zhouhoujun', '$2a$10$1ru9RySvseXF9HO9UibB.uE6MgdRoTI8JnXOoi8dPfhyGFrg.fC1e', '2020-08-17 14:33:20', 1, 1, 1, 1, '2020-08-17 14:33:20', '2020-08-17 14:33:20', NULL, NULL, '17320406593');

-- ----------------------------
-- Table structure for sys_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_relation`;
CREATE TABLE `sys_user_role_relation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role_relation
-- ----------------------------
INSERT INTO `sys_user_role_relation` VALUES (1, 1, 1);
INSERT INTO `sys_user_role_relation` VALUES (2, 2, 2);
INSERT INTO `sys_user_role_relation` VALUES (3, 3, 2);
INSERT INTO `sys_user_role_relation` VALUES (4, 4, 2);
INSERT INTO `sys_user_role_relation` VALUES (5, 5, 2);

-- ----------------------------
-- Table structure for sys_user_role_relation_copy1
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_relation_copy1`;
CREATE TABLE `sys_user_role_relation_copy1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role_relation_copy1
-- ----------------------------
INSERT INTO `sys_user_role_relation_copy1` VALUES (1, 1, 1);
INSERT INTO `sys_user_role_relation_copy1` VALUES (2, 2, 2);
INSERT INTO `sys_user_role_relation_copy1` VALUES (3, 3, 2);

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_sms_code
-- ----------------------------
DROP TABLE IF EXISTS `tb_sms_code`;
CREATE TABLE `tb_sms_code`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `send_time` datetime(0) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_sms_code
-- ----------------------------
INSERT INTO `tb_sms_code` VALUES (1, '17320406595', '0000', '2020-07-29 16:01:24', 1, -1);
INSERT INTO `tb_sms_code` VALUES (2, '17320406595', '0000', '2020-07-29 16:03:41', 1, -1);
INSERT INTO `tb_sms_code` VALUES (3, '17320406595', '0000', '2020-08-14 17:32:44', 1, -1);
INSERT INTO `tb_sms_code` VALUES (4, '17320406595', '0000', '2020-08-14 17:35:35', 1, -1);
INSERT INTO `tb_sms_code` VALUES (5, '17320406595', '0000', '2020-08-14 17:36:57', 1, -1);
INSERT INTO `tb_sms_code` VALUES (6, '17320406595', '0000', '2020-08-14 17:47:33', 1, -1);
INSERT INTO `tb_sms_code` VALUES (7, '17320406595', '0000', '2020-08-17 09:51:33', 1, -1);
INSERT INTO `tb_sms_code` VALUES (8, '17320406595', '0000', '2020-08-17 09:56:24', 1, -1);
INSERT INTO `tb_sms_code` VALUES (9, '17320406595', '0000', '2020-08-17 10:06:08', 1, -1);
INSERT INTO `tb_sms_code` VALUES (10, '17320406595', '0000', '2020-08-17 10:09:47', 1, -1);
INSERT INTO `tb_sms_code` VALUES (11, '17320406595', '0000', '2020-08-17 10:12:57', 1, -1);
INSERT INTO `tb_sms_code` VALUES (12, '17320406595', '0000', '2020-08-17 10:14:47', 1, -1);
INSERT INTO `tb_sms_code` VALUES (13, '17320406595', '0000', '2020-08-17 10:16:23', 1, -1);
INSERT INTO `tb_sms_code` VALUES (14, '17320406595', '0000', '2020-08-17 10:18:29', 1, -1);
INSERT INTO `tb_sms_code` VALUES (15, '17320406595', '0000', '2020-08-17 10:19:49', 1, -1);
INSERT INTO `tb_sms_code` VALUES (16, '17320406595', '0000', '2020-08-17 10:25:32', 1, -1);
INSERT INTO `tb_sms_code` VALUES (17, '17320406595', '0000', '2020-08-17 10:26:40', 1, -1);
INSERT INTO `tb_sms_code` VALUES (18, '17320406595', '0000', '2020-08-17 10:27:08', 1, -1);
INSERT INTO `tb_sms_code` VALUES (19, '17320406595', '0000', '2020-08-17 10:29:13', 1, -1);
INSERT INTO `tb_sms_code` VALUES (20, '17320406595', '0000', '2020-08-17 10:31:00', 1, -1);
INSERT INTO `tb_sms_code` VALUES (21, '17320406595', '0000', '2020-08-17 10:32:05', 1, -1);
INSERT INTO `tb_sms_code` VALUES (22, '17320406595', '0000', '2020-08-17 10:32:51', 1, -1);
INSERT INTO `tb_sms_code` VALUES (23, '17320406595', '0000', '2020-08-17 10:34:23', 1, -1);
INSERT INTO `tb_sms_code` VALUES (24, '17320406595', '0000', '2020-08-17 10:38:03', 1, -1);
INSERT INTO `tb_sms_code` VALUES (25, '17320406595', '0000', '2020-08-17 10:40:45', 1, -1);
INSERT INTO `tb_sms_code` VALUES (26, '17320406595', '0000', '2020-08-17 10:45:40', 1, -1);
INSERT INTO `tb_sms_code` VALUES (27, '17320406595', '0000', '2020-08-17 10:47:59', 1, -1);
INSERT INTO `tb_sms_code` VALUES (28, '17320406595', '0000', '2020-08-17 14:07:07', 1, -1);
INSERT INTO `tb_sms_code` VALUES (29, '17320406595', '0000', '2020-08-17 14:23:04', 1, -1);
INSERT INTO `tb_sms_code` VALUES (30, '17320406595', '0000', '2020-08-17 14:26:56', 1, -1);
INSERT INTO `tb_sms_code` VALUES (31, '17320406591', '0000', '2020-08-17 14:27:27', 1, -1);
INSERT INTO `tb_sms_code` VALUES (32, '17320406593', '0000', '2020-08-17 14:33:15', 1, -1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `telephone` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `last_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `last_time` datetime(0) DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'i5A2WRnKeHdusfEIWb1', NULL, '610e861204591a3d6b3c570b30b160e8544910341d8b724a217543ad99b257945ad6273f870b75d9', NULL, '17320406595', NULL, 1, NULL, '0:0:0:0:0:0:0:1', '2020-07-29 16:14:41', '2020-07-29 16:03:50', '2020-07-29 16:03:50');

-- ----------------------------
-- Table structure for tb_video
-- ----------------------------
DROP TABLE IF EXISTS `tb_video`;
CREATE TABLE `tb_video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remake` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `upload_time` datetime(0) DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `down_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_video_count
-- ----------------------------
DROP TABLE IF EXISTS `tb_video_count`;
CREATE TABLE `tb_video_count`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `browse` bigint(255) DEFAULT NULL,
  `comment` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
