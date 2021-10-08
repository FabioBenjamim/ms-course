package com.mscourse.hroauth.role;

import java.util.Objects;

public class Role {
	
	public Role() {

	}
	
	public Role(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	private Long id;
	private String roleName;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(roleName, other.roleName);
	}

}
