CREATE TABLE IF NOT EXISTS authors
(
	author_id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
	surname varchar(100) NOT NULL,
	patronymic varchar(100) NOT NULL,
	date_of_birth DATE
);

CREATE TABLE IF NOT EXISTS editions
(
	edition_id serial PRIMARY KEY,
    name varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS genres
(
	genre_id serial PRIMARY KEY,
    name varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS USERS
(
	user_id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
	surname varchar(100) NOT NULL,
	patronymic varchar(100), 
	email varchar(100) NOT NULL,
	date_of_birth Date NOT NULL,
	code_from_email int,
	date_of_registration Date NOT NULL
);

CREATE TABLE IF NOT EXISTS books
(
	book_id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
	date_of_taken Date,
	date_of_return Date,
	edition_id int REFERENCES editions(edition_id),
	user_id int REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS book_author
(
	book_author_id serial PRIMARY KEY,
	book_id int NOT NULL REFERENCES books(book_id),
	author_id int NOT NULL REFERENCES authors(author_id)
);

CREATE TABLE IF NOT EXISTS book_genre
(
	book_genre_id serial PRIMARY KEY,
	book_id int NOT NULL REFERENCES books(book_id),
	genre_id int NOT NULL REFERENCES genres(genre_id)
);

