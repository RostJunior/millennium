package ua.com.millennium.service;

import java.util.List;

import ua.com.millennium.domain.Role;

public interface RoleService {

	void createRole(String name);
	
	List<Role> getAllRole();
	
	void deleteRole(int idRole);
	
	void updateRole(int idRole, String name);
	
	Role findById(int idRole);
}
