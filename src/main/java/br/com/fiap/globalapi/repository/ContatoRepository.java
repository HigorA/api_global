package br.com.fiap.globalapi.repository;

import br.com.fiap.globalapi.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
