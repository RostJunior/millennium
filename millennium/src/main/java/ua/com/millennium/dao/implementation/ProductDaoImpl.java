package ua.com.millennium.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.millennium.dao.ProductDao;
import ua.com.millennium.domain.Product;

/**
 * The practical implementation of operations ProductDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class ProductDaoImpl extends GeneralDaoImpl<Product, Integer> implements ProductDao{

	public ProductDaoImpl() {
		super(Product.class);
		
	}

	@Transactional
	public Product findById(int id) {
		
		return (Product) em.createNamedQuery("Product.getId").setParameter("idProduct", id).getSingleResult();
	}

}
