--# --- !Ups
CREATE TABLE IF NOT EXISTS Friend(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    PRIMARY KEY (id));

--# --- !Downs