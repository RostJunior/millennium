package ua.com.millennium.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * This class is for the storage of carts in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2016-01-30
 * 
 */

@Entity
@NamedQuery(name = "Cart.getId", query = "select a from Cart a where a.idCart=:idCart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCart;
	
	private int idTemp;
	
	@Column
	private int count;
	
	@Column
	private int totalPrice;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Ordering order;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Product prod;
	
	
	/* Constructors: */
	
	public Cart() {
		
	}

public Cart(Product product, int count) {
		this.prod = product;
		this.count = count;
		totalPrice = product.getPrice() * count;
			
	}

public Cart(Product product, int count, int idTemp) {
	this.idTemp = idTemp;
	this.prod = product;
	this.count = count;
	totalPrice = product.getPrice() * count;
		
}



	
	public Cart(Ordering order, Product product, int count) {
		
		this.order = order;
		this.prod = product;
		this.count = count;
		totalPrice = product.getPrice() * count;
	}



	public Cart(Ordering order, Product product, int count, int totalPrice) {
		
		this.order = order;
		this.prod = product;
		this.count = count;
		this.totalPrice = totalPrice;
	}


	/* Getters and Setters: */
	public int getId() {
		return idCart;
	}



	public void setId(int id) {
		this.idCart = id;
	}



	public Ordering getOrder() {
		return order;
	}



	public void setOrder(Ordering order) {
		this.order = order;
	}



	public Product getProduct() {
		return prod;
	}



	public void setProduct(Product product) {
		this.prod = product;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public int getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getIdTemp() {
		return idTemp;
	}

	public void setIdTemp(int idTemp) {
		this.idTemp = idTemp;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	/* method toString: */
	@Override
	public String toString() {
		return "Cart [id=" + idCart + ", idTemp=" + idTemp + ", order=" + order + ", product=" + prod + ", count=" + count + ", totalPrice="
				+ totalPrice + "]";
	}
	
	
}
