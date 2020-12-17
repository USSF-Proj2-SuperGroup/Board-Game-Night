CREATE DATABASE IF NOT EXISTS `games`;
CREATE DATABASE IF NOT EXISTS `games_test`;

CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY 'local';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';

DROP TABLE IF EXISTS Game_Group;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Games;
DROP TABLE IF EXISTS Game_Pool;
DROP TABLE IF EXISTS User_Games;
DROP TABLE IF EXISTS User;

CREATE TABLE Game_Group(
	Game_Group_ID INTEGER AUTO_INCREMENT,
	Group_Name TEXT NOT NULL,
	Game_Description TEXT,
	PRIMARY KEY (Game_Group_ID)
);

CREATE TABLE User(
	User_ID INTEGER AUTO_INCREMENT,
	Game_Group_ID INTEGER NOT NULL,
	Username VARCHAR(50) UNIQUE NOT NULL,
	Email VARCHAR(50) UNIQUE NOT NULL,
	Pass_Word VARCHAR(50) NOT NULL,
	First_Name TEXT NOT NULL,
	Last_Name TEXT NOT NULL,
	User_Role TEXT NOT NULL,
	PRIMARY KEY (User_ID),
	CONSTRAINT User_Game_Group_FK
		FOREIGN KEY(Game_Group_ID)
		REFERENCES Game_Group(Game_Group_ID)
);

CREATE TABLE Games(
	Game_ID INTEGER AUTO_INCREMENT,
    User_ID INTEGER NOT NULL,
	game_api_ID TEXT NOT NULL,
	Game_Name TEXT NOT NULL,
	In_Game_Pool BOOLEAN NOT NULL,
	In_Wishlist BOOLEAN NOT NULL,
	PRIMARY KEY (Game_ID),
	CONSTRAINT User_Game_FK
		FOREIGN KEY(User_ID)
		REFERENCES User(User_ID)

);

CREATE TABLE Game_Pool(
	Pool_ID INTEGER AUTO_INCREMENT,
	Game_Group_ID INTEGER NOT NULL,
	Game_ID INTEGER NOT NULL,
	Game_votes INTEGER,
	PRIMARY KEY (Pool_ID),
	CONSTRAINT Group_Pool_FK
		FOREIGN KEY(Game_Group_ID)
		REFERENCES Game_Group(Game_Group_ID),
	CONSTRAINT Game_Pool_FK
		FOREIGN KEY (Game_ID)
		REFERENCES Games(Game_ID)
);




INSERT INTO Game_Group (Group_Name, Game_Description) VALUES ('Friday Night Fun', 'The Best Friday Group');
INSERT INTO Game_Group (Group_Name, Game_Description) VALUES ('Sunday Funday', 'Board games and Sports? Whats better!');
INSERT INTO Game_Group (Group_Name, Game_Description) VALUES ('Saturday Showdown', 'Where its western games only!');



INSERT INTO User (Game_Group_ID, Username, Email, Pass_Word, First_Name, Last_Name, User_Role)
VALUES (1, 'Rob', 'rob@us.af.mil', 'MyPassword', 'Rob', 'Cameron', 'user');
INSERT INTO User (Game_Group_ID, Username, Email, Pass_Word, First_Name, Last_Name, User_Role)
VALUES (1, 'Peter', 'peter@us.af.mil', 'MyPassword2', 'Peter', 'Vayda', 'user');
INSERT INTO User (Game_Group_ID, Username, Email, Pass_Word, First_Name, Last_Name, User_Role)
VALUES (2, 'Ben', 'ben@us.af.mil', 'MyPassword3', 'Ben', 'Kehe', 'user');
INSERT INTO User (Game_Group_ID, Username, Email, Pass_Word, First_Name, Last_Name, User_Role)
VALUES (2, 'Donna', 'donna@us.af.mil', 'MyPassword4', 'Donna', 'Farris', 'user');
INSERT INTO User (Game_Group_ID, Username, Email, Pass_Word, First_Name, Last_Name, User_Role)
VALUES (3, 'Dameon', 'dameon@us.af.mil', 'MyPassword5', 'Dameon', 'Adolphin', 'user');


INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (1, 'OIXt3DmJU0', 'Catan', true, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (1, 'T5lx9elSDt', 'Love Letter', false, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (1, 'jYcMsxI5zP', 'Horrified', false, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (2, 'fG5Ax8PA7n', 'Monopoly', true, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (2, 'WVgc4bUL8N', 'Clue', false, true);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (3, '6FmFeux5xH', 'Pandemic', true, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (4, '3Qx47A4K8M', 'Rummikub', false, true);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (4, '5e5qeOvkp3', 'Elder Sign', false, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (4, 'OCv0s54FtD', 'the Game of Life', false, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (5, 'hQLfeykeLS', 'Phase 10', true, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (5, 'FVKaz7JhBO', 'Cosmic Encounter', false, false);
INSERT INTO Games (User_ID, game_api_ID, Game_Name, In_Game_Pool, In_Wishlist)
VALUES (5, '5tnoVda0AY', 'Twilight Imperium: Fourth Edition', false, false);


INSERT INTO Game_Pool (Game_Group_ID, Game_ID, Game_votes)
VALUES (1, 12, 0);
INSERT INTO Game_Pool (Game_Group_ID, Game_ID, Game_votes)
VALUES (1, 7, 2);
INSERT INTO Game_Pool (Game_Group_ID, Game_ID, Game_votes)
VALUES (2, 4, 3);
INSERT INTO Game_Pool (Game_Group_ID, Game_ID, Game_votes)
VALUES (2, 1, 3);
INSERT INTO Game_Pool (Game_Group_ID, Game_ID,  Game_votes)
VALUES (3, 8, 2);
INSERT INTO Game_Pool (Game_Group_ID, Game_ID, Game_votes)
VALUES (3, 3, 1);