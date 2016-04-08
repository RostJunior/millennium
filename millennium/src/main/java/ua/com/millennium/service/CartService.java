package ua.com.millennium.service;

import java.util.List;

import ua.com.millennium.domain.Cart;
import ua.com.millennium.domain.Ordering;
import ua.com.millennium.domain.Product;

/**
 * Service interface for {@link Cart}s.
 * 
 * @author Tanskiy R.
 */

public interface CartService {
	
	void createCart(Ordering order, Product product, int count);
	
	List<Cart> getAllCart();
	
	Cart findById(int idCart);
	
	
	void deleteCart(int idCart);
	
	void updateCart(int idCart, Ordering order, Product product, int count, int totalPrice);

	void createCartTemp(Product product, int count);
}
