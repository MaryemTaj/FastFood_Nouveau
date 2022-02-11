package org.project.FastFood.dto;



import org.project.FastFood.Util.ERole;

public class RoleDto {

	
    private Long id;
	 
	  private ERole name;
    private String roleId;
	public ERole getName() {
		return name;
	}
	public void setName(ERole name) {
		this.name = name;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}