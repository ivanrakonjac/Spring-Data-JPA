DROP TABLE IF EXISTS books_authors;

CREATE TABLE `books_authors` (
                          `book_id` BIGINT NOT NULL REFERENCES book (id),
                          `author_id` BIGINT NOT NULL REFERENCES author (id),
                          PRIMARY KEY (book_id, author_id)
);

ALTER TABLE book DROP COLUMN author_id;