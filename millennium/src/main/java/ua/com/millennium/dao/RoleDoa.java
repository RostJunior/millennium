package ua.com.millennium.dao;

import ua.com.millennium.domain.Role;

/**
 * Dao interface for find object Role in the database by ID
 * 
 */

public interface RoleDoa extends GeneralDao<Role, Integer>{

	Role findById(int id);
}
