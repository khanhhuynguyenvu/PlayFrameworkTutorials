--# --- !Ups
CREATE TABLE IF NOT EXISTS users(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    created_at DATETIME NOT NULL,
    modified_at DATETIME NOT NULL,
    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS Friend(
    id BIGINT(20) NOT NULL,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    PRIMARY KEY (id));

--# --- !Downs