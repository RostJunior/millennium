package ua.com.millennium.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.millennium.dao.RoleDoa;
import ua.com.millennium.domain.Role;
import ua.com.millennium.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDoa dao;
	
	public void createRole(String name) {
		
		Role role = new Role(name);
		
		dao.create(role);
		
	}

	public List<Role> getAllRole() {
		
		return dao.getAll();
	}

	public void deleteRole(int idRole) {
		
		dao.delete(dao.findById(idRole));
		
	}

	public void updateRole(int idRole, String name) {
		
		Role role = dao.findById(idRole);
		
		role.setName(name);
		
		dao.edit(role);
		
	}

	public Role findById(int idRole) {
		
		return dao.findById(idRole);
	}
	
	

}
