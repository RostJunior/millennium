package ua.com.millennium.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.millennium.dao.CartDao;
import ua.com.millennium.domain.Cart;
import ua.com.millennium.domain.Ordering;
import ua.com.millennium.domain.Product;
import ua.com.millennium.service.CartService;


@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao dao;
	
	
	public void createCart(Ordering order, Product product, int count) {
		
		Cart cart = new Cart(order, product, count);
		
		dao.create(cart);
		
	}

	public List<Cart> getAllCart() {
		
		return dao.getAll();
	}

	public Cart findById(int idCart) {
		
		return dao.findById(idCart);
	}

	public void deleteCart(int idCart) {
		
		dao.delete(dao.findById(idCart));
		
	}

	public void updateCart(int idCart, Ordering order, Product product, int count, int totalPrice) {
		
		Cart cart = dao.findById(idCart);
		
		cart.setOrder(order);
		cart.setProduct(product);
		cart.setCount(count);
		cart.setTotalPrice(totalPrice);
		
		dao.edit(cart);
		
	}

	public void createCartTemp(Product product, int count) {
		Cart cart = new Cart(product, count);
		
		dao.create(cart);
		
	}
	
	

}
