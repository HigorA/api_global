CREATE TABLE IF NOT EXISTS unidade (
  id INT NOT NULL AUTO_INCREMENT,
  business_hours VARCHAR(45) NULL,
  status VARCHAR(255) NULL,
  ong_id INT NOT NULL,
  PRIMARY KEY (id, ong_id),
  INDEX fk_unidade_ong1_idx (ong_id ASC) VISIBLE,
  CONSTRAINT fk_unidade_ong1
    FOREIGN KEY (ong_id)
    REFERENCES ong (id)
)