package ua.com.millennium.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.millennium.dao.OrderingDao;

import ua.com.millennium.domain.Ordering;
import ua.com.millennium.domain.User;
import ua.com.millennium.service.OrderingService;

@Service("orderingService")
public class OrderingServiceImpl implements OrderingService{

	@Autowired
	private OrderingDao dao;
	
	
	public List<Ordering> getAllOrder() {
		
		return dao.getAll();
	}

	public void deleteOrder(int idOrder) {
		
		dao.delete(dao.findById(idOrder));
		
	}

	public void updateOrdering(int idOrder, User deskOrder, Date date, int total) {
		
		Ordering order = dao.findById(idOrder);
		
		order.setDeskOrder(deskOrder);
		order.setDateOrder(date);
		order.setTotalOrder(total);
		dao.edit(order);
	}

	public void createOrder(User deskOrder, int total, String numberOrder) {
		
		Ordering order = new Ordering(numberOrder, total, deskOrder);
		dao.create(order);
		
	}

	public Ordering findByStatus(String status) {
		
		return dao.findByStatus(status);
	}

	public Ordering findByNumberOrder(String numberOrder) {
		
		return dao.findByNumberOrder(numberOrder);
	}

	public Ordering findById(int id) {
		
		return dao.findById(id);
	}

	public void updateStatus(int idOrder) {
		Ordering order = dao.findById(idOrder);
		
		order.setStatus("done");
		dao.edit(order);
		
	}
	
	
}
