-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.18-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema imooc
--

CREATE DATABASE IF NOT EXISTS imooc;
USE imooc;

--
-- Definition of table `t_student`
--

DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `stu_name` varchar(16) NOT NULL,
  `gender` int(11) unsigned default NULL,
  `age` int(11) unsigned default NULL,
  `address` varchar(128) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_student`
--

/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
/*INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES 
 (1,'王小雷',1,17,'北京市东城区');*/
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (1,'王小雷',1,17,'北京市东城区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (2,'李雷雷',1,16,'北京市东城区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (3,'张静',2,20,'北京市昌平区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (4,'王晓萌',2,14,'北京市西城区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (5,'韩梅梅',2,24,'北京市海淀区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (6,'李小军',1,22,'北京市朝阳区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (7,'成龙',1,56,'北京市东城区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (8,'王珞丹',2,44,'北京市海淀区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (9,'李佳',2,35,'北京市顺义区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (10,'孙海杰',1,20,'北京市石景山区');
INSERT INTO `t_student` (`id`,`stu_name`,`gender`,`age`,`address`) VALUES (11,'王海龙',1,20,'北京市东城区');

/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
