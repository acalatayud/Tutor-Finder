CREATE TABLE IF NOT EXISTS areas (
area_id IDENTITY PRIMARY KEY,
name VARCHAR(128) UNIQUE NOT NULL,
description VARCHAR(512) NOT NULL
);

CREATE TABLE IF NOT EXISTS subjects (
subject_id IDENTITY PRIMARY KEY,
name VARCHAR(128) UNIQUE NOT NULL,
description VARCHAR(512) NOT NULL,
area_id INT NOT NULL,
FOREIGN KEY(area_id) REFERENCES areas(area_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS users (
user_id IDENTITY PRIMARY KEY,
username VARCHAR(128) UNIQUE NOT NULL,
password VARCHAR(64) NOT NULL,
email VARCHAR(512) UNIQUE NOT NULL,
name VARCHAR(128) NOT NULL,
lastname VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS professors (
user_id BIGINT NOT NULL,
description VARCHAR(512) NOT NULL,
FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE,
PRIMARY KEY(user_id)
);

CREATE TABLE IF NOT EXISTS courses (
user_id BIGINT NOT NULL,
subject_id BIGINT NOT NULL,
description VARCHAR(512) NOT NULL,
price REAL NOT NULL,
FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE,
FOREIGN KEY(user_id) REFERENCES professors(user_id) ON DELETE CASCADE,
PRIMARY KEY(user_id, subject_id)
);

CREATE TABLE IF NOT EXISTS conversations (
conversation_id IDENTITY PRIMARY KEY,
user_id BIGINT NOT NULL,
professor_id BIGINT NOT NULL,
subject_id BIGINT NOT NULL,
FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE,
FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE,
FOREIGN KEY(professor_id) REFERENCES professors(user_id) ON DELETE CASCADE,
UNIQUE(user_id, subject_id, professor_id)
);

CREATE TABLE IF NOT EXISTS messages (
message_id IDENTITY PRIMARY KEY,
conversation_id BIGINT NOT NULL,
sender_id BIGINT NOT NULL,
message VARCHAR(1024) NOT NULL,
created TIMESTAMP NOT NULL,
FOREIGN KEY(conversation_id) REFERENCES conversations(conversation_id) ON DELETE CASCADE,
FOREIGN KEY(sender_id) REFERENCES users(user_id) ON DELETE CASCADE
);

Insert into areas (area_id, name, description) values (1, 'matematica', 'este area es dificil');
INSERT into users (user_id, username, password, email, name, lastname) values (2, 'juanchopanza', '12345', 'juan@hotmail.com', 'juan', 'lopez' );
INSERT into users (user_id, username, password, email, name, lastname) values (3, 'mesme', '12345', 'mesme@hotmail.com', 'Martin', 'Mesme' );
INSERT into users (user_id, username, password, email, name, lastname) values (4, 'juan', '12345', 'test@hotmail.com', 'Wanch', 'Ope' );
INSERT into users (user_id, username, password, email, name, lastname) values (5, 'mugi', '12345', 'straw@hotmail.com', 'Mugi', 'Wara' );
INSERT into professors (user_id, description) values (2, 'Juan es un profesor dedicado');
INSERT into professors (user_id, description) values (5, 'Kaizoku Mugiwara no Luffy');
INSERT into subjects (subject_id, name, description, area_id) values (1, 'Algebra', 'Complicado', 1);
INSERT into conversations (conversation_id, user_id, professor_id, subject_id) values (1,3,2,1);
INSERT into conversations (conversation_id, user_id, professor_id, subject_id) values (2,4,2,1);
INSERT into conversations (conversation_id, user_id, professor_id, subject_id) values (3,4,5,1);
INSERT into messages (conversation_id, sender_id, message, created) values (1,2,'Hola', '2018-09-21 05:08:26.793');
INSERT into messages (conversation_id, sender_id, message, created) values (1,3,'Hola2', '2017-09-21 05:08:26.793');