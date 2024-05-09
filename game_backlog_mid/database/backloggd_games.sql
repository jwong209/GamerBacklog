DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS game CASCADE;
DROP TABLE IF EXISTS backlog CASCADE;
DROP TABLE IF EXISTS game_backlog;
DROP TABLE IF EXISTS user_game;

CREATE TABLE "user" (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE,
	password VARCHAR(50)
);

CREATE TABLE game (
	game_id SERIAL PRIMARY KEY,
	title VARCHAR(255),
	release_date VARCHAR(255),
	developers VARCHAR(255),
	summary TEXT,
	platforms TEXT,
	genres VARCHAR(255),
	rating VARCHAR(5),
	plays VARCHAR(255),
	playing VARCHAR(255),
	backlogs VARCHAR(255),
	wishlist VARCHAR(255),
	lists VARCHAR(255),
	reviews VARCHAR(255)
);

CREATE TABLE backlog (
	backlog_id SERIAL PRIMARY KEY,
	user_id INTEGER,
	progress VARCHAR(255),
	priority INTEGER CHECK (priority BETWEEN 1 AND 5),
	FOREIGN KEY (user_id) REFERENCES "user" (user_id)
);

CREATE TABLE game_backlog (
    backlog_id INTEGER,
    game_id INTEGER,
    PRIMARY KEY (backlog_id, game_id),
    FOREIGN KEY (backlog_id) REFERENCES backlog (backlog_id),
    FOREIGN KEY (game_id) REFERENCES game (game_id)
);

CREATE TABLE user_game (
    user_id INTEGER,
    game_id INTEGER,
    PRIMARY KEY (user_id, game_id),
    FOREIGN KEY (user_id) REFERENCES "user" (user_id),
    FOREIGN KEY (game_id) REFERENCES game (game_id)

);

INSERT INTO "user" (username, password)
VALUES
	('dannyRand', 'ironFist@gmail.com'),
	('lukeCage', 'powerMan@gmail.com'),
	('wilsonFisk', 'kingPin@gmail.com');

INSERT INTO backlog (user_id, progress, priority)
VALUES
	(1, 'Finished prologue only', 5),
	(2, 'Unplayed', 2),
	(3, 'Tried the demo only', 4);




