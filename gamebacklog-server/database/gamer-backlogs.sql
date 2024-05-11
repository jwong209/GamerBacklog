BEGIN TRANSACTION;

DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS collection CASCADE;
DROP TABLE IF EXISTS backlog CASCADE;
DROP TABLE IF EXISTS game_backlog;
DROP TABLE IF EXISTS user_game;


CREATE TABLE "user" (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(50) NOT NULL
);

CREATE TABLE collection (
	collection_id SERIAL PRIMARY KEY,
	user_id INTEGER,
	FOREIGN KEY (user_id) REFERENCES "user" (user_id)
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
    FOREIGN KEY (backlog_id) REFERENCES backlog (backlog_id)
);

CREATE TABLE user_game (
    user_id INTEGER,
    game_id INTEGER,
    PRIMARY KEY (user_id, game_id),
    FOREIGN KEY (user_id) REFERENCES "user" (user_id)
);

INSERT INTO "user" (username, password)
VALUES
	('dannyRand', 'ironFist'),
	('lukeCage', 'powerMan'),
	('wilsonFisk', 'kingPin');

COMMIT;


