package ua.com.millennium.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.millennium.dao.OrderingDao;
import ua.com.millennium.domain.Ordering;

/**
 * The practical implementation of operations ProductDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class OrderingDaoImpl extends GeneralDaoImpl<Ordering, Integer> implements OrderingDao{

	public OrderingDaoImpl() {
		super(Ordering.class);
		
	}

	@Transactional
	public Ordering findById(int id) {
		
		return (Ordering) em.createNamedQuery("Order.getId").setParameter("idOrder", id).getSingleResult();
	}

	@Transactional
	public Ordering findByStatus(String status) {
		
		return (Ordering) em.createNamedQuery("Order.getStatus").setParameter("status", status).getSingleResult();
	}

	@Transactional
	public Ordering findByNumberOrder(String numberOrder) {
		
		return (Ordering) em.createNamedQuery("Order.getNumberOrder").setParameter("numberOrder", numberOrder).getSingleResult();
	}

		
}
