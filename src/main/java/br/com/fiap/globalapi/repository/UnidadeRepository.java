package br.com.fiap.globalapi.repository;

import br.com.fiap.globalapi.entities.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    @Query("SELECT u FROM Unidade u WHERE u.ong.id =:ongId")
    Unidade findAllByOng(@Param("ongId") Long ongId);
}
