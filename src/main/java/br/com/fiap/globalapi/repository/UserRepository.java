package br.com.fiap.globalapi.repository;

import br.com.fiap.globalapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login =:login and enabled = true")
    Optional<User> findByLogin(@Param("login") String login);


}
