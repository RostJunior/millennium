/**
 * 
 */
package ua.com.millennium.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.millennium.dao.CartDao;
import ua.com.millennium.domain.Cart;

/**
 * The practical implementation of operations CartDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class CartDaoImpl extends GeneralDaoImpl<Cart, Integer> implements CartDao {

	public CartDaoImpl() {
		super(Cart.class);
		
	}

	@Transactional
	public Cart findById(int id) {
		
		return (Cart) em.createNamedQuery("Cart.getId").setParameter("idCart", id).getSingleResult();
	}

}
