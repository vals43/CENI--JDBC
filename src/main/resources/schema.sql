CREATE TABLE Player (
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR NOT NULL ,
    age int NOT NULL ,
    position ENUM('GK','DEF','MIDF','STR') NOT NULL,
    id_team INT,
    CONSTRAINT fk_player_team FOREIGN KEY (id_team) REFERENCES Team(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
)

CREATE TABLE Team (
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR NOT NULL ,
    continent ENUM('[AFRICA','EUROPA','ASIA','AMERICA')
)