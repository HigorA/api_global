CREATE TABLE IF NOT EXISTS contato (
  id INT NOT NULL AUTO_INCREMENT,
  telephone VARCHAR(45) NULL,
  unidade_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_contato_unidade1
    FOREIGN KEY (unidade_id)
    REFERENCES unidade (id)
)