CREATE TABLE IF NOT EXISTS users (
  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(700) NOT NULL,
  account_non_expired TINYINT NULL,
  account_non_locked TINYINT NULL,
  credentials_non_expired TINYINT NULL,
  enabled TINYINT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX login_UNIQUE (login ASC) VISIBLE
);