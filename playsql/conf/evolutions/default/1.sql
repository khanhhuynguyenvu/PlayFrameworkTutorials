# --- !Ups
CREATE TABLE users (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    created_at DATETIME NOT NULL,
    modified_at DATETIME NOT NULL,
    PRIMARY KEY (id));

CREATE TABLE babies (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id));
 
# --- !Downs
DROP TABLE users;
DROP TABLE babies;