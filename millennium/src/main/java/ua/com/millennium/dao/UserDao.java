package ua.com.millennium.dao;

import ua.com.millennium.domain.User;

/**
 * Dao interface for find object User in the database by ID
 * 
 */

public interface UserDao extends GeneralDao<User, Integer> {

	User findById(int id);
	User findByName(String name);
}
