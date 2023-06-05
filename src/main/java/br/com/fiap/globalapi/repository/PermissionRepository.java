package br.com.fiap.globalapi.repository;

import br.com.fiap.globalapi.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
