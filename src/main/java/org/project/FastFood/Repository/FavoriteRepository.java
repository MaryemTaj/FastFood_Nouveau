package org.project.FastFood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.project.FastFood.Entity.FavoriteEntity;
@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity,Long>{

}
