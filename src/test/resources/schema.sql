DROP TABLE IF EXISTS player;
CREATE TABLE player (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  teamid int NOT NULL,
  score int DEFAULT NULL
);

DROP TABLE IF EXISTS couch;
CREATE TABLE couch (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  teamid int NOT NULL
);

DROP TABLE IF EXISTS team;
CREATE TABLE team (
  id int NOT NULL AUTO_INCREMENT,
  `teamname` varchar(45) NOT NULL,
  score int DEFAULT NULL
);