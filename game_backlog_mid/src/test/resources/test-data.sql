BEGIN TRANSACTION;

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

INSERT INTO game (title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews)
VALUES
    ('Title_1', '2023-04-18', 'Developer1', 'Summary1', 'Platform1', 'Genre1', '4.0', 'Plays1', 'Playing1', 'Backlogs1', 'Wishlist1', 'Lists1', 'Reviews1'),
    ('Title_2', '2021-02-19', 'Developer2', 'Summary2', 'Platform2', 'Genre2', '4.1', 'Plays2', 'Playing2', 'Backlogs2', 'Wishlist2', 'Lists2', 'Reviews2'),
    ('Title_3', '1999-03-20', 'Developer3', 'Summary3', 'Platform3', 'Genre3', '3.6', 'Plays3', 'Playing3', 'Backlogs3', 'Wishlist3', 'Lists3', 'Reviews3'),
    ('Title_4', '2000-01-21', 'Developer1', 'Summary1', 'Platform1', 'Genre1', '1.0', 'Plays1', 'Playing1', 'Backlogs1', 'Wishlist1', 'Lists1', 'Reviews1'),
    ('Title_5', '2020-02-02', 'Developer2', 'Summary2', 'Platform2', 'Genre2', '2.1', 'Plays2', 'Playing2', 'Backlogs2', 'Wishlist2', 'Lists2', 'Reviews2'),
    ('Title_6', '1997-03-13', 'Developer3', 'Summary3', 'Platform3', 'Genre3', '1.6', 'Plays3', 'Playing3', 'Backlogs3', 'Wishlist3', 'Lists3', 'Reviews3');

INSERT INTO backlog (user_id, progress, priority)
VALUES
	(1, 'Finished prologue only', 5),
	(2, 'Unplayed', 2),
	(3, 'Tried the demo only', 4);

INSERT INTO game_backlog (game_id, backlog_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (2, 3),
    (2, 1),
    (3, 3);

INSERT INTO user_game (user_id, game_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6);

COMMIT;
