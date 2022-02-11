package org.project.FastFood.Repository;

import java.util.Optional;

import org.project.FastFood.Entity.RoleEntity;
import org.project.FastFood.Util.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
  Optional<RoleEntity> findByName(ERole name);
}
