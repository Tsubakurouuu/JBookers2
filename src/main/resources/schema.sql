CREATE TABLE IF NOT EXISTS m_user(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(20),
	email VARCHAR(100) PRIMARY KEY,
	password VARCHAR(100),
	introduction VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS book(
	id INT NOT NULL AUTO_INCREMENT,
	user_id INT,
	title VARCHAR(20),
	body VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS book_comment(
	id INT NOT NULL AUTO_INCREMENT,
	user_id INT,
	book_id INT,
	comment VARCHAR(50)
)