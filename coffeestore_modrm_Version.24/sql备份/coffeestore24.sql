/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : coffeestore

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-03-18 05:37:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `catalogid` int(11) NOT NULL,
  `catalogname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`catalogid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', '黑咖啡');
INSERT INTO `catalog` VALUES ('2', '玩味冰调');
INSERT INTO `catalog` VALUES ('3', '星冰乐');
INSERT INTO `catalog` VALUES ('4', '白咖啡');

-- ----------------------------
-- Table structure for coffee
-- ----------------------------
DROP TABLE IF EXISTS `coffee`;
CREATE TABLE `coffee` (
  `coffeeid` int(11) NOT NULL AUTO_INCREMENT,
  `catalogid` int(11) DEFAULT NULL,
  `coffeename` varchar(30) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`coffeeid`),
  KEY `Modrm_1` (`catalogid`),
  CONSTRAINT `Modrm_1` FOREIGN KEY (`catalogid`) REFERENCES `catalog` (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coffee
-- ----------------------------
INSERT INTO `coffee` VALUES ('1', '1', '卡布奇诺', '15', '1_1.jpg');
INSERT INTO `coffee` VALUES ('2', '1', '美式', '25', '1_2.jpg');
INSERT INTO `coffee` VALUES ('3', '1', '绵云冷萃', '17', '1_3.jpg');
INSERT INTO `coffee` VALUES ('4', '1', '冷萃冰咖啡', '30', '1_4.jpg');
INSERT INTO `coffee` VALUES ('5', '1', '拿铁', '28', '1_5.jpg');
INSERT INTO `coffee` VALUES ('6', '1', '轻甜奶油冷萃', '49', '1_6.jpg');
INSERT INTO `coffee` VALUES ('12', '2', '橙油派对', '22', '2_1.jpg');
INSERT INTO `coffee` VALUES ('13', '2', '醋意桃桃', '32', '2_2.jpg');
INSERT INTO `coffee` VALUES ('14', '2', '橘香莫吉托', '18', '2_3.jpg');
INSERT INTO `coffee` VALUES ('15', '2', '蓝莓星空', '19', '2_4.jpg');
INSERT INTO `coffee` VALUES ('16', '2', '璃光石榴冷萃', '54', '2_5.jpg');
INSERT INTO `coffee` VALUES ('17', '2', '气炫冰山美式', '54', '2_6.jpg');
INSERT INTO `coffee` VALUES ('18', '2', '石榴仲夏梦', '56', '2_7.jpg');
INSERT INTO `coffee` VALUES ('19', '2', '酸柠浮冷萃', '43', '2_8.jpg');
INSERT INTO `coffee` VALUES ('20', '3', '草莓星冰乐', '42', '3_1.jpg');
INSERT INTO `coffee` VALUES ('21', '3', '覆盆子星冰乐', '32', '3_2.jpg');
INSERT INTO `coffee` VALUES ('22', '3', '芒果西番莲', '23', '3_3.jpg');
INSERT INTO `coffee` VALUES ('23', '3', '摩卡星冰乐', '32', '3_4.jpg');
INSERT INTO `coffee` VALUES ('24', '3', '抹茶星冰乐', '53', '3_5.jpg');
INSERT INTO `coffee` VALUES ('25', '3', '鲜橙果肉星冰乐', '23', '3_6.jpg');
INSERT INTO `coffee` VALUES ('26', '4', '冰摇柠檬茶', '23', '4_1.jpg');
INSERT INTO `coffee` VALUES ('27', '4', '焦糖玛奇朵', '24', '4_2.jpg');
INSERT INTO `coffee` VALUES ('28', '4', '摩卡', '43', '4_3.jpg');
INSERT INTO `coffee` VALUES ('29', '4', '香草拿铁', '53', '4_4.jpg');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `orderitemid` int(11) NOT NULL AUTO_INCREMENT,
  `coffeeid` int(11) NOT NULL,
  `orderid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`orderitemid`),
  KEY `Modrm_3` (`orderid`),
  KEY `Modrm_4` (`coffeeid`),
  CONSTRAINT `Modrm_3` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `Modrm_4` FOREIGN KEY (`coffeeid`) REFERENCES `coffee` (`coffeeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `orderdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`orderid`),
  KEY `Modrm_2` (`userid`),
  CONSTRAINT `Modrm_2` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `headImg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '男22', '1811', '1290491776@qq.com', '20190624145245765.png');
INSERT INTO `user` VALUES ('2', 'root', 'root', '女23', '16', '1667069015@qq.com', null);
INSERT INTO `user` VALUES ('18', '123', '123', '23', '23', '123', '20190624013656991.jpg');
INSERT INTO `user` VALUES ('19', '1234', '1234', '1231', '23', '123', '20190624014539457.png');
INSERT INTO `user` VALUES ('20', null, 'admin', '男1', '18', '1290491776@qq.com', null);
INSERT INTO `user` VALUES ('21', null, 'admin', '男2', '18', '1290491776@qq.com', null);
INSERT INTO `user` VALUES ('22', null, 'admin', '男', '18', '1290491776@qq.com', null);
INSERT INTO `user` VALUES ('23', null, 'admin', '男', '183', '1290491776@qq.com', null);
INSERT INTO `user` VALUES ('24', null, 'admin', '男', '183', '1290491776@qq.com', null);
INSERT INTO `user` VALUES ('25', null, 'admin2', '男2', '182', '1290491776@qq.com', null);
INSERT INTO `user` VALUES ('26', null, 'admin', '男2', '182', '1290491776@qq.com', null);
