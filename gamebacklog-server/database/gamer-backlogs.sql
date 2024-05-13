BEGIN TRANSACTION;

DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS collection CASCADE;
DROP TABLE IF EXISTS backlog CASCADE;
DROP TABLE IF EXISTS backlog_game;
DROP TABLE IF EXISTS collection_game;


CREATE TABLE "user" (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(50) NOT NULL
);

CREATE TABLE collection (
	collection_id SERIAL PRIMARY KEY,
	user_id INTEGER UNIQUE,
	FOREIGN KEY (user_id) REFERENCES "user" (user_id)
);

CREATE TABLE backlog (
	backlog_id SERIAL PRIMARY KEY,
	user_id INTEGER UNIQUE,
	progress VARCHAR(255),
	priority INTEGER CHECK (priority BETWEEN 1 AND 5),
	FOREIGN KEY (user_id) REFERENCES "user" (user_id)
);

CREATE TABLE backlog_game (
    backlog_id INTEGER,
    game_id INTEGER,
    PRIMARY KEY (backlog_id, game_id),
    FOREIGN KEY (backlog_id) REFERENCES backlog (backlog_id)
);

CREATE TABLE collection_game (
    collection_id INTEGER,
    game_id INTEGER,
    PRIMARY KEY (collection_id, game_id),
    FOREIGN KEY (collection_id) REFERENCES collection (collection_id)
);

INSERT INTO "user" (username, password)
VALUES
	('dannyRand', 'ironFist'),
	('lukeCage', 'powerMan'),
	('wilsonFisk', 'kingPin');

COMMIT;


