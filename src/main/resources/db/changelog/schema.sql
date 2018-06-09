
CREATE TABLE category
(
    id serial PRIMARY KEY NOT NULL,
    name varchar(128) NOT NULL UNIQUE
);

CREATE TABLE joke
(
    id serial PRIMARY KEY NOT NULL,
    category_id int NOT NULL,
    content varchar(5000) NOT NULL,
    likes int DEFAULT 0 NOT NULL,
    dislikes int DEFAULT 0 NOT NULL,
    CONSTRAINT joke_category_id_fk FOREIGN KEY (category_id) REFERENCES category (id)
);

ALTER TABLE joke ADD difference int DEFAULT 0 NOT NULL;