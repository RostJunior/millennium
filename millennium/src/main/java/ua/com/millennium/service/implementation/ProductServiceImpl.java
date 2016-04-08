package ua.com.millennium.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.millennium.dao.ProductDao;
import ua.com.millennium.domain.Product;
import ua.com.millennium.domain.Type;
import ua.com.millennium.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	
	public void createProduct(String name, int price, String describe, String standart, Type type, String namePhoto) {
		
		Product product = new Product(name, price, describe, standart, type, namePhoto);
	
		dao.create(product);
				
	}

	public List<Product> getAllProduct() {
		
		return dao.getAll();
	}

	public Product findById(int idProduct) {
		
		return dao.findById(idProduct);
	}

	public void deleteProduct(int idProduct) {

		dao.delete(dao.findById(idProduct));
		
	}

	public void updateProduct(int idProduct, String name, int price, String describe, String standart, Type type,
			String namePhoto) {
		
		Product product = dao.findById(idProduct);
		
		product.setName(name);
		product.setPrice(price);
		product.setDescribe(describe);
		product.setStandart(standart);
		product.setType(type);
		product.setNamePhoto(namePhoto);
		
		dao.edit(product);
		
	}

}
