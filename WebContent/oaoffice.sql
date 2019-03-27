/*
 Navicat Premium Data Transfer

 Source Server         : localhost_23306
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:23306
 Source Schema         : oaoffice

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 27/03/2019 14:58:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bulletin
-- ----------------------------
DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE `bulletin`  (
  `bulletin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `bulletin_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告主题',
  `bulletin_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告内容',
  `bulletin_buildtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '公告创建时间',
  `user_realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发起人名字',
  `user_id` int(11) NOT NULL COMMENT '发起人id',
  `role_id` int(11) NOT NULL COMMENT '主管',
  PRIMARY KEY (`bulletin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bulletin
-- ----------------------------
INSERT INTO `bulletin` VALUES (1, '通知', '经公司领导班子研究决定，新进公司的员工，一年转正定级后，公司给统一办理缴纳社保。', '2019-03-22 16:35:54', '王五', 3, 3);
INSERT INTO `bulletin` VALUES (2, '开会通知', '年度利润商讨', '2019-03-22 16:35:57', '李四', 2, 3);

-- ----------------------------
-- Table structure for calendar
-- ----------------------------
DROP TABLE IF EXISTS `calendar`;
CREATE TABLE `calendar`  (
  `calendar_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日程id',
  `calendar_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日程标题',
  `calendar_starttime` date NULL DEFAULT NULL COMMENT '开始时间',
  `calendar_endtime` date NULL DEFAULT NULL COMMENT '结束时间',
  `calendar_remind` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提醒',
  `calendar_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`calendar_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of calendar
-- ----------------------------
INSERT INTO `calendar` VALUES (1, '人员招聘', '2019-03-16', '2019-03-25', '由于公司某些项目缺人需招聘人员', '招聘人员计划：1、销售人员3名，2、技术人员1名', 2);
INSERT INTO `calendar` VALUES (2, '员工培训', '2019-03-21', '2019-04-14', '培育新人', '培养学员学习java', 6);
INSERT INTO `calendar` VALUES (3, '生产检查', '2019-03-21', '2019-04-14', ' aaa', '51111111111111112222222222222222', 3);
INSERT INTO `calendar` VALUES (4, '员工培训', '2019-03-21', '2019-04-14', ' aaa', '培训嵌入式', 3);
INSERT INTO `calendar` VALUES (6, '员工培训', '2019-03-21', '2019-04-14', '培育新人', '学习h5', 5);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `dept_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '部门信息描述',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '总经理办公室', NULL);
INSERT INTO `dept` VALUES (2, '行政部', NULL);
INSERT INTO `dept` VALUES (3, '人事部', NULL);

-- ----------------------------
-- Table structure for dothing
-- ----------------------------
DROP TABLE IF EXISTS `dothing`;
CREATE TABLE `dothing`  (
  `dothing_id` int(11) NOT NULL AUTO_INCREMENT,
  `dothing_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代办事宜描述',
  `dothing_enddate` date NULL DEFAULT NULL COMMENT '事件到期日',
  `dothing_priority` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事情优先级',
  `dothing_result` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事情是否完成',
  `user_id` int(11) NOT NULL COMMENT '事情分配对象',
  PRIMARY KEY (`dothing_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dothing
-- ----------------------------
INSERT INTO `dothing` VALUES (1, '联系客户，对公司商品的评价', '2019-04-19', '高', '未完成', 5);
INSERT INTO `dothing` VALUES (2, '工作交谈', '2019-04-14', '中', '未完成', 5);
INSERT INTO `dothing` VALUES (3, '工作总结', '2019-04-14', '低', '未完成', 5);
INSERT INTO `dothing` VALUES (4, '开会', '2019-04-14', '中', '未完成', 2);

-- ----------------------------
-- Table structure for floder
-- ----------------------------
DROP TABLE IF EXISTS `floder`;
CREATE TABLE `floder`  (
  `floder_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `floder_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `floder_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件内容',
  `floder_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件保存路径',
  `floder_isshare` int(1) NOT NULL COMMENT '1表示共享0表示不共享',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`floder_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of floder
-- ----------------------------
INSERT INTO `floder` VALUES (1, '工作表', '表的数据', 'D:\\job', 1, 3);
INSERT INTO `floder` VALUES (2, '课程表', '课程表的数据', 'D:\\job', 0, 2);
INSERT INTO `floder` VALUES (8, '员工培训', '培养学员学习java', 'D:\\job', 0, 3);
INSERT INTO `floder` VALUES (10, '员工培训', '培养学员学习java', 'D:\\job', 0, 2);

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meeting_date` date NOT NULL,
  `meeting_start` time(0) NOT NULL,
  `meeting_end` time(0) NOT NULL,
  `meeting_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meetingroom_id` int(11) NOT NULL,
  PRIMARY KEY (`meeting_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES (1, '年度利润分红会议', '2019-03-19', '15:51:06', '15:51:08', '未开始', 1);

-- ----------------------------
-- Table structure for meetingapply
-- ----------------------------
DROP TABLE IF EXISTS `meetingapply`;
CREATE TABLE `meetingapply`  (
  `meetingapply_id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingapply_time` date NOT NULL COMMENT '会议开始时间',
  `user_id` int(11) NOT NULL COMMENT '会议申请人id',
  `meetingapply_reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会议申请理由',
  `approver` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会议申请审批人',
  `meetingapply_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议申请状态',
  `twoapprovalma_id` int(11) NOT NULL,
  PRIMARY KEY (`meetingapply_id`) USING BTREE,
  INDEX `twoapprovalma_id`(`twoapprovalma_id`) USING BTREE,
  CONSTRAINT `zz` FOREIGN KEY (`twoapprovalma_id`) REFERENCES `meetingapply` (`meetingapply_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meetingapply
-- ----------------------------
INSERT INTO `meetingapply` VALUES (1, '2019-03-19', 2, '月总结', '王五', '未通过', 1);

-- ----------------------------
-- Table structure for meetingroom
-- ----------------------------
DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom`  (
  `meetingroom_id` int(11) NOT NULL AUTO_INCREMENT,
  `meetingroom_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usercount` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`meetingroom_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------
INSERT INTO `meetingroom` VALUES (1, '大会议室', '30');

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power`  (
  `power_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `power_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `power_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接页面地址',
  `power_ismenu` int(2) NULL DEFAULT NULL,
  `power_pid` int(11) NOT NULL COMMENT '父级权限',
  `key` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`power_id`, `power_pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES (1, '个人信息', NULL, 1, 0, NULL);
INSERT INTO `power` VALUES (2, '日程安排', NULL, 1, 0, NULL);
INSERT INTO `power` VALUES (3, '代办事宜', NULL, 1, 0, NULL);
INSERT INTO `power` VALUES (4, '消息提醒', NULL, 1, 0, NULL);
INSERT INTO `power` VALUES (5, '名片夹', NULL, 1, 0, NULL);
INSERT INTO `power` VALUES (6, '个人文件夹', NULL, 1, 0, NULL);
INSERT INTO `power` VALUES (7, '请假申请', NULL, 2, 0, NULL);
INSERT INTO `power` VALUES (8, '会议申请', NULL, 2, 0, NULL);
INSERT INTO `power` VALUES (9, '会议审批', NULL, 2, 8, NULL);
INSERT INTO `power` VALUES (10, '会议管理', NULL, 3, 0, NULL);
INSERT INTO `power` VALUES (11, '会议室管理', NULL, 3, 0, NULL);
INSERT INTO `power` VALUES (12, '用户管理', NULL, 3, 0, NULL);
INSERT INTO `power` VALUES (13, '部门管理', NULL, 4, 0, NULL);
INSERT INTO `power` VALUES (14, '角色及权限管理', NULL, 4, 0, NULL);
INSERT INTO `power` VALUES (15, '发布消息', NULL, 5, 4, NULL);
INSERT INTO `power` VALUES (16, '请假审批', NULL, 5, 7, NULL);

-- ----------------------------
-- Table structure for power_role
-- ----------------------------
DROP TABLE IF EXISTS `power_role`;
CREATE TABLE `power_role`  (
  `role_id` int(11) NOT NULL,
  `powerrole_id` int(11) NOT NULL,
  PRIMARY KEY (`powerrole_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of power_role
-- ----------------------------
INSERT INTO `power_role` VALUES (2, 1);
INSERT INTO `power_role` VALUES (3, 1);
INSERT INTO `power_role` VALUES (1, 2);
INSERT INTO `power_role` VALUES (2, 2);
INSERT INTO `power_role` VALUES (3, 2);
INSERT INTO `power_role` VALUES (1, 3);
INSERT INTO `power_role` VALUES (2, 3);
INSERT INTO `power_role` VALUES (3, 3);
INSERT INTO `power_role` VALUES (2, 4);
INSERT INTO `power_role` VALUES (3, 4);
INSERT INTO `power_role` VALUES (1, 5);
INSERT INTO `power_role` VALUES (2, 5);
INSERT INTO `power_role` VALUES (3, 5);
INSERT INTO `power_role` VALUES (2, 6);
INSERT INTO `power_role` VALUES (3, 6);
INSERT INTO `power_role` VALUES (2, 7);
INSERT INTO `power_role` VALUES (3, 7);
INSERT INTO `power_role` VALUES (3, 8);
INSERT INTO `power_role` VALUES (3, 9);
INSERT INTO `power_role` VALUES (1, 10);
INSERT INTO `power_role` VALUES (1, 11);
INSERT INTO `power_role` VALUES (1, 13);
INSERT INTO `power_role` VALUES (1, 14);
INSERT INTO `power_role` VALUES (3, 15);
INSERT INTO `power_role` VALUES (3, 16);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员');
INSERT INTO `role` VALUES (2, '普通员工');
INSERT INTO `role` VALUES (3, '主管');
INSERT INTO `role` VALUES (4, 'Boss');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键、自动增长员工id号 ',
  `user_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一 \n也就是用户登的用户名',
  `user_realname` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名字',
  `user_pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户性别',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话号码',
  `user_born` date NULL DEFAULT NULL COMMENT '用户出生日期',
  `user_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `user_
hobby` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户爱好',
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电子邮件',
  `selfassessment` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自我评价',
  `headpic` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `dept_id` int(11) NOT NULL COMMENT '部门id',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `xx`(`dept_id`) USING BTREE,
  CONSTRAINT `xx` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '张三', '123', '男', '13213512541', '1990-07-02', '', NULL, '15153131@163.com', NULL, NULL, 1);
INSERT INTO `user` VALUES (2, 'admin1', '李四', '123', '男', '18457257255', '1994-08-11', '', NULL, '12312165@163.com', NULL, NULL, 2);
INSERT INTO `user` VALUES (3, 'oasys', '王五', '123', '男', '13727882722', '1993-11-26', '', NULL, '18415153@163.com', NULL, NULL, 3);
INSERT INTO `user` VALUES (4, 'admin3', '刘丽丽', '123', '女', '13784565456', '1985-03-14', '', NULL, '84656811@163.com', NULL, NULL, 1);
INSERT INTO `user` VALUES (5, 'guest', '小红', '123', '女', '17382782727', '1995-12-02', '', NULL, '15351352@163.com', NULL, NULL, 2);
INSERT INTO `user` VALUES (6, 'zhaoliu', '赵六', '123456', '男', '18725335153', '1992-04-15', '120100_13_0', NULL, '18483413@163.com', NULL, '', 3);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 3);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (3, 2);
INSERT INTO `user_role` VALUES (4, 4);
INSERT INTO `user_role` VALUES (5, 3);
INSERT INTO `user_role` VALUES (6, 3);

-- ----------------------------
-- Table structure for vacate
-- ----------------------------
DROP TABLE IF EXISTS `vacate`;
CREATE TABLE `vacate`  (
  `vacate_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请假id',
  `vacate_sharttime` date NOT NULL COMMENT '什么时候请假',
  `vacate_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请假多久',
  `vacate_reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请假原因',
  `user_id` int(11) NOT NULL COMMENT '请假人id',
  `approver` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审批人',
  `vacate_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审批请假结果',
  `role_id` int(11) NOT NULL COMMENT '主管',
  PRIMARY KEY (`vacate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vacate
-- ----------------------------
INSERT INTO `vacate` VALUES (1, '2019-03-19', '2天', '身体不舒服', 2, '王五', '未同意', 3);

-- ----------------------------
-- Table structure for vacateprocess
-- ----------------------------
DROP TABLE IF EXISTS `vacateprocess`;
CREATE TABLE `vacateprocess`  (
  `twoapprovalvc_id` int(11) NOT NULL AUTO_INCREMENT,
  `twoapprovalvc_opinion` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`twoapprovalvc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
