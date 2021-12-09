DROP TABLE IF EXISTS authoruuid;

CREATE TABLE `authoruuid` (
                          `id` varchar(36) NOT NULL,
                          `first_name` VARCHAR(100),
                          `last_name` VARCHAR(100),
                          PRIMARY KEY (`id`)
);