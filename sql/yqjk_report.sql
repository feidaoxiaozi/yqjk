/*
MySQL Data Transfer
Source Host: localhost
Source Database: yqjk
Target Host: localhost
Target Database: yqjk
Date: 2013-1-7 14:22:23
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
  `resource` varchar(500) NOT NULL,
  PRIMARY KEY  (`reportId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `yqjk_report` VALUES ('1', '看360度无死角男星:韩栋入围 冯绍峰秒杀黄晓明(四)', ' http:\\/\\/ent.163.com\\/13\\/0107\\/09\\/8KJU0DMN00032DGD_4.html', ' 网易娱乐 2013-01-07 08:54:00');
