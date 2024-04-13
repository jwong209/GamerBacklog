DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS backlog;
DROP TABLE IF EXISTS game_backlog;

CREATE TABLE "user" (
	user_id SERIAL PRIMARY KEY, 
	username VARCHAR(50) UNIQUE,
	password VARCHAR(50)
);

CREATE TABLE backlog (
	backlog_id SERIAL PRIMARY KEY, 
	user_id INTEGER UNIQUE,
	progress VARCHAR(255),
	priority INTEGER CHECK (priority BETWEEN 1 AND 5),
	FOREIGN KEY (user_id) REFERENCES "user" (user_id),
	FOREIGN KEY (game_id) REFERENCES game (game_id)
);

CREATE TABLE game_backlog (
    game_backlog_id SERIAL PRIMARY KEY,
    backlog_id INTEGER,
    game_id INTEGER,
    FOREIGN KEY (backlog_id) REFERENCES backlog (backlog_id),
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
	(1, '50% through campaign', 3),
	(2, 'Unplayed', 2),
	(3, 'Played for 1 hour', 1),
	(3, 'Tried the demo only', 4);