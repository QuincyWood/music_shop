CREATE DATABASE bookstore;


use  bookstore;

CREATE TABLE tb_user 
(
  
  username VARCHAR(50) primary key,
  email VARCHAR(50) NOT NULL,
  password INT NOT NULL,
  UNIQUE KEY `name_UNIQUE` (`username`)
  UNIQUE KEY `email_UNIQUE` (`email`)
);

CREATE DATABASE music_shop;

use  music_shop;

CREATE TABLE `Customers` 
(
  
  customer_name VARCHAR(50) NOT NULL,
  email_address VARCHAR(50) NOT NULL,
  id INT(50) NOT NULL  primary key AUTO_INCREMENT,
  UNIQUE KEY `name_UNIQUE` (`customer_name`),
  UNIQUE KEY `email_UNIQUE` (`email_address`)
  ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1

);

INSERT  into Customers  VALUES ('Quincy Woodall', 'quincy@user.com', 133133);
INSERT  into Customers  VALUES ('Joe Name', 'Joe1@user.com', 123445);
INSERT  into Customers  VALUES ('Kill Bill', 'great_movie@user.com', 246789);

--Select *
--From Customers


CREATE TABLE `artist`
(
  
  artist_name VARCHAR(50) NOT NULL,
  song VARCHAR(50) NOT NULL,
  price INT(15)  NOT NULL
  year INT(15)  NOT NULL
  UNIQUE KEY `name_UNIQUE` (`artist_name`),
  UNIQUE KEY `email_UNIQUE` (`song`)
  ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1
  
);
INSERT  into artist  VALUES ('Kendrick Lamar', 'DNA', 15, 2017);
INSERT  into artist  VALUES ('Jay z', 'pimpin', 15, 2004);
INSERT  into artist  VALUES ('NAS', 'If I Ruled The World', 15,1996);

CREATE TABLE `event` 
(
  
  location VARCHAR(50) NOT NULL,
  date_event VARCHAR(50) NOT NULL,
  ticket_id INT(50)  primary key
  
);

INSERT  into event  VALUES ('Chicago', 'Feb, 15',12345678);
INSERT  into event  VALUES ('New York', 'Mar, 12', 98756092);
INSERT  into event  VALUES ('Carolina', 'Dec 1', 27951304);