package br.com.fiap.globalapi.repository;

import br.com.fiap.globalapi.entities.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OngRepository extends JpaRepository<Ong, Long> {

    @Query("SELECT o FROM Ong o JOIN FETCH o.user WHERE o.user.id = :userId")
    Ong findByUserId(@Param("userId") Long userId);
}
