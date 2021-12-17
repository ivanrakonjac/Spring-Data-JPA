DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
                          `username` VARCHAR(15) NOT NULL,
                          `first_name` VARCHAR(100),
                          `last_name` VARCHAR(100),
                          PRIMARY KEY (`username`)
);

ALTER TABLE review
    ADD username VARCHAR(15),
    ADD FOREIGN KEY (username) REFERENCES user (username);