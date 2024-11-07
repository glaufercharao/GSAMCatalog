package com.gsam.tecnologia.main.dto;

import com.gsam.tecnologia.main.entities.Role;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private static final long serialVersionUID=1L;
	
	private long id;
	private String authority;
	
	public RoleDTO() {
		
	}
	
	public RoleDTO(Role entity) {
		super();
		this.id = entity.getId();
		this.authority = entity.getAuthority();
	}

	public RoleDTO(long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
