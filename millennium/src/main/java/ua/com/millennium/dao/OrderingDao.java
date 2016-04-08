package ua.com.millennium.dao;

import ua.com.millennium.domain.Ordering;

/**
 *Dao interface for find object Ordering in the database by ID
 * 
 */
public interface OrderingDao extends GeneralDao<Ordering, Integer>{

	Ordering findById(int id);
	Ordering findByStatus(String status);
	Ordering findByNumberOrder(String numberOrder);
}
