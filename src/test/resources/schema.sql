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

DROP TABLE IF EXISTS match;
CREATE TABLE match (
  id int NOT NULL AUTO_INCREMENT,
  team1_id int NOT NULL,
  team1_score int NOT NULL,
  team2_id int NOT NULL,
  team2_score int NOT NULL
);

DROP TABLE IF EXISTS player_statistics;
CREATE TABLE player_statistics (
  id int NOT NULL AUTO_INCREMENT,
  player_id int NOT NULL,
  match_id int NOT NULL,
  score_from_match int NOT NULL
);

