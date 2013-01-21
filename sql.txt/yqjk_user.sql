/*
MySQL Data Transfer
Source Host: localhost
Source Database: yqjk
Target Host: localhost
Target Database: yqjk
Date: 2013-1-21 15:07:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for yqjk_user
-- ----------------------------
DROP TABLE IF EXISTS `yqjk_user`;
CREATE TABLE `yqjk_user` (
  `userId` int(8) NOT NULL auto_increment,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `age` int(8) NOT NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `yqjk_user` VALUES ('1', 'tom', '111', '4234', '23');
INSERT INTO `yqjk_user` VALUES ('3', 'wangyi', '111', 'tert', '23');
INSERT INTO `yqjk_user` VALUES ('4', 'shenqi', '123456', 'rwer', '12');
INSERT INTO `yqjk_user` VALUES ('5', 'wuqilong', '111', 'rtert', '123123');
INSERT INTO `yqjk_user` VALUES ('6', 'liudehua', '123456', 'ww56575@163.com', '34');
INSERT INTO `yqjk_user` VALUES ('7', 'james', '123456', 'fdsfs', '34');
INSERT INTO `yqjk_user` VALUES ('8', 'dfgdf', '111', 'tyryy', '32');
INSERT INTO `yqjk_user` VALUES ('9', 'ewq', '123', 'wwfdsf@1434.com', '34');
