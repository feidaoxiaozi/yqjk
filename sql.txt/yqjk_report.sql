/*
MySQL Data Transfer
Source Host: localhost
Source Database: yqjk
Target Host: localhost
Target Database: yqjk
Date: 2013-1-30 18:09:24
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for yqjk_report
-- ----------------------------
DROP TABLE IF EXISTS `yqjk_report`;
CREATE TABLE `yqjk_report` (
  `reportId` int(11) NOT NULL auto_increment,
  `title` varchar(1000) NOT NULL,
  `url` varchar(500) NOT NULL,
  `resource` varchar(500) default NULL,
  `published_time` varchar(255) default NULL,
  PRIMARY KEY  (`reportId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
