package ua.com.millennium.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.millennium.dao.RoleDoa;
import ua.com.millennium.domain.Role;

/**
 * The practical implementation of operations RoleDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class RoleDaoImpl extends GeneralDaoImpl<Role, Integer> implements RoleDoa{

	public RoleDaoImpl() {
		super(Role.class);
		
	}

	@Transactional
	public Role findById(int id) {
		
		return (Role) em.createNamedQuery("Role.getId").setParameter("idRole", id).getSingleResult();
	}
	
	

}
