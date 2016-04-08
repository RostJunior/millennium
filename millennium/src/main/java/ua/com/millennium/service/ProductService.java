package ua.com.millennium.service;

import java.util.List;

import ua.com.millennium.domain.Product;
import ua.com.millennium.domain.Type;

public interface ProductService {
	
	void createProduct(String name, int price, String describe, String standart, Type type, String namePhoto);

	List<Product> getAllProduct();
	
	Product findById(int idProduct);
	
	void deleteProduct(int idProduct);
	
	void updateProduct(int idProduct, String name, int price, String describe, String standart, Type type, String namePhoto);
	
	
}
