/*
MySQL Data Transfer
Source Host: localhost
Source Database: yqjk
Target Host: localhost
Target Database: yqjk
Date: 2013-1-21 15:06:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for yqjk_task
-- ----------------------------
DROP TABLE IF EXISTS `yqjk_task`;
CREATE TABLE `yqjk_task` (
  `roleId` int(10) NOT NULL auto_increment,
  `roleName` varchar(40) NOT NULL,
  `newsResource` varchar(30) NOT NULL,
  `findStyle` varchar(30) NOT NULL,
  `collectDate` varchar(20) NOT NULL,
  `collectCondition` varchar(200) NOT NULL,
  `contentMate` varchar(50) default NULL,
  `Site_collection` varchar(20) default NULL,
  `roleState` varchar(10) NOT NULL,
  PRIMARY KEY  (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 4096 kB';

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `yqjk_task` VALUES ('1', '2013春晚', '新闻', '标题&时间搜索', '当天', '赵本山', '小品', '启用', '启用');
INSERT INTO `yqjk_task` VALUES ('2', '中日关系', '新闻', '正文&相关度搜索', '当天', '丰富', '中方', '启用', '启用');
