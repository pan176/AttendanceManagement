/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 8.0.13 : Database - management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`management` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `management`;

/*Table structure for table `tb_attendance` */

DROP TABLE IF EXISTS `tb_attendance`;

CREATE TABLE `tb_attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `absent_date` datetime DEFAULT NULL,
  `absent_class` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `absent_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `student_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `tb_attendance` */

insert  into `tb_attendance`(`id`,`class_name`,`absent_date`,`absent_class`,`absent_type`,`student_name`,`student_id`) values 
(1,'Java课程设计','2021-06-24 00:00:00','1-2','迟到','潘宏伟',1),
(2,'Java课程设计','2021-06-24 00:00:00','1-2','迟到','潘宏伟',1),
(3,'Java课程设计','2021-06-24 00:00:00','1-2','迟到','潘宏伟',1),
(5,'Java课程设计','2021-06-24 00:00:00','1-2','迟到','潘宏伟',1),
(6,'网络安全','2021-06-25 00:00:00','1-2','请假','潘宏伟',1),
(7,'软件测试','2021-06-25 00:00:00','3-4节','早退','李俊峰',10),
(8,'软件测试','2021-06-25 00:00:00','3-4节','迟到','李俊峰',10),
(9,'操作系统','2021-06-23 00:00:00','7-8','旷课','潘宏伟',17),
(10,'网络安全','2021-06-25 00:00:00','7-8','迟到','李俊峰',20);

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(100) DEFAULT NULL,
  `class_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student` */

insert  into `tb_student`(`id`,`name`,`sex`,`age`,`class_name`) values 
(1,'潘宏伟','男',1,'1802075'),
(10,'李俊峰','1',21,'1802075'),
(11,'欧阳澍','1',22,'1802075'),
(14,'ff','男',12,'1802075'),
(15,'潘宏伟','男',1,'1802075'),
(16,'潘宏伟','男',1,'1802075'),
(17,'潘宏伟','男',1,'1802075'),
(18,'f','男',1,'1802075'),
(19,'潘宏伟','男',2,'1802075'),
(20,'潘宏伟','男',1,'1802075'),
(21,'李俊峰','男',22,'1802075');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
