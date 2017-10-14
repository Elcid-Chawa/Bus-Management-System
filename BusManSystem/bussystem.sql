CREATE DATABASE bussystem;

CREATE TABLE bustable (
    busID VARCHAR(9) NOT NULL,
    bustype VARCHAR(20) NOT NULL,
    seatcap INT(2) NOT NULL,
    PRIMARY KEY (busID)
);

CREATE TABLE city
	(cityID varchar(9) NOT NULL,
	name varchar(25) NOT NULL,
	PRIMARY KEY (cityID));

CREATE TABLE client 
	(clientID varchar(15) NOT NULL,
	fname varchar(30) NULL,
	lname varchar(30) NOT NULL,
	phone int (10),
	PRIMARY KEY (clientID));

CREATE TABLE boards 
	(clientID varchar(15),
		busID varchar(9) NOT NULL,
		FOREIGN KEY (busID) REFERENCES bustable (busID));

CREATE TABLE travels
	(fromCity varchar(9) NOT NULL,
	toCity varchar(9) NOT NULL,
	seatNo int(2) NOT NULL,
	travelDate date NOT NULL,
	FOREIGN KEY (fromCity) REFERENCES city (cityID),
	FOREIGN KEY (toCity) REFERENCES city (cityID));