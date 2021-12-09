DROP TABLE IF EXISTS author_composite;

CREATE TABLE `author_composite` (
                          `first_name` VARCHAR(100),
                          `last_name` VARCHAR(100),
                          PRIMARY KEY (`first_name`, `last_name`)
);