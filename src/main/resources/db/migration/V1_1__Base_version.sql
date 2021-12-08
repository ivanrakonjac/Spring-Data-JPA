DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS hibernate_sequence;

CREATE TABLE `book` (
                        `id` BIGINT NOT NULL AUTO_INCREMENT,
                        `isbn` VARCHAR(10),
                        `publisher` VARCHAR(100),
                        `title` VARCHAR(100),
                        PRIMARY KEY (`id`)
);

CREATE TABLE `hibernate_sequence` (
                        `next_val` BIGINT
) engine=InnoDB;

INSERT INTO hibernate_sequence values(1);