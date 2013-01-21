/*
MySQL Data Transfer
Source Host: localhost
Source Database: yqjk
Target Host: localhost
Target Database: yqjk
Date: 2012-12-25 9:57:29
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
  `taskId` int(6) NOT NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
