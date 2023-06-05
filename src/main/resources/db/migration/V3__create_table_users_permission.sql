CREATE TABLE IF NOT EXISTS users_permission (
  users_id INT NOT NULL,
  permission_id INT NOT NULL,
  PRIMARY KEY (users_id, permission_id),
  INDEX fk_users_permission_permission1_idx (permission_id ASC) VISIBLE,
  CONSTRAINT fk_users_permission_users
    FOREIGN KEY (users_id)
    REFERENCES users (id),
  CONSTRAINT fk_users_permission_permission1
    FOREIGN KEY (permission_id)
    REFERENCES permission (id)
)