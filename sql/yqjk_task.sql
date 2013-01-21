/*
MySQL Data Transfer
Source Host: localhost
Source Database: yqjk
Target Host: localhost
Target Database: yqjk
Date: 2012-12-25 9:53:30
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
