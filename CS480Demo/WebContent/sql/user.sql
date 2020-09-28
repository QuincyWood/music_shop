CREATE DATABASE bookstore;


use  bookstore;

CREATE TABLE tb_user 
(
  
  username VARCHAR(50) primary key,
  email VARCHAR(50) NOT NULL,
  password INT NOT NULL
);

CREATE DATABASE music_shop;

use  music_shop;

CREATE TABLE Customers 
(
  
  customer_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  id INT  primary key
);

INSERT  into Customers  VALUES ('Quincy Woodall', 'quincy@user.com', 1234);
INSERT  into Customers  VALUES ('Joe Name', 'Joe1@user.com', 1678);
INSERT  into Customers  VALUES ('Kill Bill', 'great_movie@user.com', 2468);

--Select *
--From Customers


CREATE TABLE artist 
(
  
  artist_name VARCHAR(50) NOT NULL,
  song VARCHAR(50) NOT NULL,
  price INT  NOT NULL
  year INT  NOT NULL
  
);
INSERT  into artist  VALUES ('Kendrick Lamar', 'DNA', 15, 2017);
INSERT  into artist  VALUES ('Jay z', 'pimpin', 15, 2004);
INSERT  into artist  VALUES ('NAS', 'If I Ruled The World', 15,1996);

CREATE TABLE event 
(
  
  location VARCHAR(50) NOT NULL,
  date_event VARCHAR(50) NOT NULL,
  ticket_id INT  primary key
  
);

INSERT  into artist  VALUES ('Chicagor', 'Feb, 15',12345678);
INSERT  into artist  VALUES ('New York', 'Mar, 12', 98756092);
INSERT  into artist  VALUES ('Carolina', 'Dec 1', 27951304);