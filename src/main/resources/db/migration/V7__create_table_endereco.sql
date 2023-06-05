CREATE TABLE IF NOT EXISTS endereco (
  id INT NOT NULL AUTO_INCREMENT,
  cep VARCHAR(255) NULL,
  uf VARCHAR(255) NULL,
  bairro VARCHAR(255) NULL,
  logradouro VARCHAR(255) NULL,
  numero VARCHAR(255) NULL,
  complemento VARCHAR(255) NULL,
  unidade_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_endereco_unidade1_idx (unidade_id ASC) VISIBLE,
  CONSTRAINT fk_endereco_unidade1
    FOREIGN KEY (unidade_id)
    REFERENCES unidade (id)
)