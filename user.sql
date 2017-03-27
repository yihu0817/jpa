/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-03-27 22:25:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(10)  NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Age` int(3)  DEFAULT NULL,
  `Sex` char(1) DEFAULT 'M' COMMENT 'M for male and F for female',
  `Address` text,
  `Birth` date DEFAULT NULL,
  `Income` decimal(10,2)  DEFAULT '0.00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=196609 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('131072', '王二', '25', '1', '成都市', '2017-03-27', '1.20');
INSERT INTO `user` VALUES ('163840', '麻子', '27', '1', '成都市', '2017-03-27', '1.20');
INSERT INTO `user` VALUES ('196608', '张三', '27', '1', '成都市', '2017-03-27', '1.20');
