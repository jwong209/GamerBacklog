DROP TABLE IF EXISTS game;

CREATE TABLE game (
	game_id SERIAL PRIMARY KEY,
	title VARCHAR(255),
	release_date VARCHAR(255),
	developers VARCHAR(255),
	summary TEXT,
	platforms TEXT,
	genres VARCHAR(255),
	rating VARCHAR(255),
	plays VARCHAR(255),
	playing VARCHAR(255),
	backlogs VARCHAR(255),
	wishlist VARCHAR(255),
	lists VARCHAR(255),
	reviews VARCHAR(255)
);

COPY backloggd_games
FROM 'C:\Users\Student\Desktop\backloggd_games.csv'
WITH (FORMAT CSV, HEADER, DELIMITER ',');