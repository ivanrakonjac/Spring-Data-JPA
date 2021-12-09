DROP TABLE IF EXISTS author;

CREATE TABLE `author` (
                        `id` BIGINT NOT NULL AUTO_INCREMENT,
                        `first_name` VARCHAR(100),
                        `last_name` VARCHAR(100),
                        PRIMARY KEY (`id`)
);