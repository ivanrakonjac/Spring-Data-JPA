DROP TABLE IF EXISTS review;

CREATE TABLE `review` (
                          `id` BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          `text` VARCHAR(100),
                          `book_id` BIGINT NOT NULL,
                          FOREIGN KEY (book_id) REFERENCES book (id)
);