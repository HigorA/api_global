package br.com.fiap.globalapi.repository;

import br.com.fiap.globalapi.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
