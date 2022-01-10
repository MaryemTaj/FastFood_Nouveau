package org.project.FastFood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.project.FastFood.Entity.CommentsEntity;
@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity,Long>{

}
