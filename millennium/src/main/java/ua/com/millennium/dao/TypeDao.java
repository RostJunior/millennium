package ua.com.millennium.dao;

import ua.com.millennium.domain.Type;

/**
 *Dao interface for find object Type in the database by ID
 * 
 */

public interface TypeDao extends GeneralDao<Type, Integer>{

	Type findById(int id);
}
