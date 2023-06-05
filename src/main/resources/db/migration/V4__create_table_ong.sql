CREATE TABLE IF NOT EXISTS ong (
  id INT NOT NULL AUTO_INCREMENT,
  ong_name VARCHAR(255) NULL,
  users_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_ong_users1
      FOREIGN KEY (users_id)
      REFERENCES users (id),
  CONSTRAINT uc_ong_users_id UNIQUE (users_id)
);