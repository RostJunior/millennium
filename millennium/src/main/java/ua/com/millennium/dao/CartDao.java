package ua.com.millennium.dao;

import ua.com.millennium.domain.Cart;

/**
 * Dao interface for find object Cart in the database by ID
 * 
 */

public interface CartDao extends GeneralDao<Cart, Integer> {

	Cart findById(int id);
	

}
