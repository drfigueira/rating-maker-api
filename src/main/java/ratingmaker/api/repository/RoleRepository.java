package ratingmaker.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratingmaker.api.domain.RoleName;
import ratingmaker.api.domain.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
