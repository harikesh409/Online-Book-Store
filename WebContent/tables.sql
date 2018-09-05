create database books;
use books;

CREATE TABLE `users` (
 `uid` int(11) NOT NULL AUTO_INCREMENT,
 `email` varchar(255) DEFAULT NULL,
 `password` varchar(255) DEFAULT NULL,
 `dob` date DEFAULT NULL,
 `name` varchar(255) DEFAULT NULL,
 `address` varchar(255) DEFAULT NULL,
 `city` varchar(255) DEFAULT NULL,
 `country` varchar(255) DEFAULT NULL,
 `gender` varchar(255) DEFAULT NULL,
 `role` varchar(255) NOT NULL DEFAULT 'user',
 PRIMARY KEY (`uid`),
 UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1

CREATE TABLE `books` (
 `ISBN` int(12) NOT NULL,
 `title` varchar(255) DEFAULT NULL,
 `author` varchar(255) DEFAULT NULL,
 `publisher` varchar(255) DEFAULT NULL,
 `description` varchar(255) NOT NULL,
 `category` varchar(255) DEFAULT NULL,
 `price` float NOT NULL,
 `cover` longblob,
 `qtyAvailable` int(12) NOT NULL,
 PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `orders` (
 `orderID` int(11) NOT NULL AUTO_INCREMENT,
 `isbn` varchar(255) NOT NULL,
 `price` float NOT NULL,
 `quantity` int(12) NOT NULL,
 `total` float NOT NULL,
 `status` varchar(255) NOT NULL,
 `email` varchar(255) NOT NULL,
 PRIMARY KEY (`orderID`),
 KEY `email` (`email`),
 CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `users` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

commit;