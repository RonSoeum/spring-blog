USE adlister_db;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  #   first_name CHAR(150) NOT NULL,
  #   last_name CHAR(150) NOT NULL,
  #   phone_number VARCHAR(14) NOT NULL,
  #   image VARCHAR(255),
  #   join_date DATE DEFAULT CURRENT_DATE(),
  #   posts INT UNSIGNED NOT NULL,
  #   website VARCHAR(255),
  #   user_bio VARCHAR(350), # maybe make this varchar(x)?
  #   user_fb varchar(250),
  #   user_twitter varchar(250),
  #   user_linkedin varchar(250),
  PRIMARY KEY (id),
  UNIQUE (username),
  UNIQUE (email)
);

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS posts;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS posts (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  body VARCHAR(2000) NOT NULL,
  user_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  PRIMARY KEY (id)
);