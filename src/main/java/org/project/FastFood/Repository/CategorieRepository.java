package org.project.FastFood.Repository;

import org.project.FastFood.Entity.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity,Long>{
	CategorieEntity findById(long id );

	CategorieEntity findByName(String name);
	CategorieEntity findByCatId(String catId);
}
