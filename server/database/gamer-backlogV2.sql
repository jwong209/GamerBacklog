BEGIN TRANSACTION;

DROP TABLE IF EXISTS app_user CASCADE;
DROP TABLE IF EXISTS collection CASCADE;
DROP TABLE IF EXISTS backlog CASCADE;
DROP TABLE IF EXISTS backlog_game;
DROP TABLE IF EXISTS collection_game;
DROP TABLE IF EXISTS completed_game;


CREATE TABLE app_user (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL
);

CREATE TABLE collection (
	collection_id SERIAL PRIMARY KEY,
	user_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (user_id) REFERENCES app_user (user_id)
);

CREATE TABLE backlog (
	backlog_id SERIAL PRIMARY KEY,
	user_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (user_id) REFERENCES app_user (user_id)
);

CREATE TABLE backlog_game (
    backlog_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    progress VARCHAR(255),
    priority INTEGER CHECK (priority BETWEEN 1 and 5),
    PRIMARY KEY (backlog_id, game_id),
    FOREIGN KEY (backlog_id) REFERENCES backlog (backlog_id)
);

CREATE TABLE collection_game (
    collection_id INTEGER,
    game_id INTEGER NOT NULL,
    status VARCHAR(50),
    format VARCHAR(50),
    platform VARCHAR(50),
    rating INTEGER,
    notes VARCHAR(50),
    PRIMARY KEY (collection_id, game_id),
    FOREIGN KEY (collection_id) REFERENCES collection (collection_id)
);

CREATE TABLE completed_game (
    user_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    completion_date DATE,
    total_playtime INTERVAL,
    PRIMARY KEY (user_id, game_id),
    FOREIGN KEY (user_id) REFERENCES app_user (user_id)
);

INSERT INTO app_user (username, password_hash, role) VALUES
	('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'),
	('steveRogers','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'),
	('peterParker','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'),
	('bruceBanner','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO collection (user_id) VALUES
	(1),
	(2),
	(3),
	(4);

INSERT INTO backlog (user_id) VALUES
	(1),
	(2),
	(3),
	(4);

COMMIT;


