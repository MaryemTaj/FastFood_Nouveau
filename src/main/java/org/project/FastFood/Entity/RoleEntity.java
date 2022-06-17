package org.project.FastFood.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.project.FastFood.Util.ERole;

@Entity
@Table(name = "T_role")
public class RoleEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	  @Enumerated(EnumType.STRING)
	  @Column(length = 20)
	  private ERole name;
 
	public ERole getName() {
		return name;
	}
	public void setName(ERole name) {
		this.name = name;
	}
	
    
   
  
}