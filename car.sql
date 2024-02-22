USE `arapp_db`;

-- Table structure for table `car`
DROP TABLE IF EXISTS `car`;

CREATE TABLE `car`(`id` int NOT NULL AUTO_INCREMENT,`brand` varchar(50) NOT NULL,
                   `model`varchar(50) DEFAULT NULL,`engine` varchar(20) NOT NULL,`fuel` varchar(20) NOT NULL,
                   `year` int NOT NULL, PRIMARY KEY(`id`)
)
    ENGINE=InnoDB AUTO_INCREMENT=1
    DEFAULT CHARSET=latin1;


-- Change the index of MySQL Auto Increment to start from 20.
ALTER TABLE car AUTO_INCREMENT = 20;