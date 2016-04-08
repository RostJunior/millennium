package ua.com.millennium.dao;

import ua.com.millennium.domain.Product;

/**
 * Dao interface for find object Product in the database by ID
 * 
 */

public interface ProductDao extends GeneralDao<Product, Integer> {

	Product findById(int id);
}
