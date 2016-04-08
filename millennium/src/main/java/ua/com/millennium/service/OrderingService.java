package ua.com.millennium.service;

import java.util.Date;
import java.util.List;

import ua.com.millennium.domain.Ordering;
import ua.com.millennium.domain.User;

public interface OrderingService {
	
	void createOrder(User deskOrder, int total, String numberOrder);
	
	List<Ordering> getAllOrder();
	
	void deleteOrder(int idOrder);
	
	void updateOrdering(int idOrder, User deskOrder, Date date, int total);
	
	void updateStatus(int idOrder);
	
	Ordering findByStatus(String status);
	
	Ordering findByNumberOrder(String numberOrder);
	
	Ordering findById(int id);
	

}
