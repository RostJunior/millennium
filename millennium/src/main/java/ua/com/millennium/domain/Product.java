package ua.com.millennium.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * This class is for the storage of products in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2016-01-30
 * 
 */

@Entity
@NamedQuery(name = "Product.getId", query = "select a from Product a where a.idProduct =:idProduct")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduct;

	@Column
	private String nameProduct;

	@Column
	private int priceProduct;

	@Column
	private String describeProduct;

	@Column
	private String standartProduct;
	
	@Column
	private String namePhotoProduct;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Type typeProduct;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "prod")
	private List<Cart> carts;

	/* Constructors: */
	
	public Product() {

	}

	public Product(String name, int price, String describe, String standart, Type type, String namePhoto) {
		this.nameProduct = name;
		this.priceProduct = price;
		this.describeProduct = describe;
		this.standartProduct = standart;
		this.typeProduct = type;
		this.namePhotoProduct = namePhoto;
	}

	/* Getters and Setters: */

	public int getId() {
		return idProduct;
	}

	public void setId(int id) {
		this.idProduct = id;
	}

	public String getName() {
		return nameProduct;
	}

	public void setName(String name) {
		this.nameProduct = name;
	}

	public int getPrice() {
		return priceProduct;
	}

	public void setPrice(int price) {
		this.priceProduct = price;
	}

	public String getDescribe() {
		return describeProduct;
	}

	public void setDescribe(String describe) {
		this.describeProduct = describe;
	}

	public String getStandart() {
		return standartProduct;
	}

	public void setStandart(String standart) {
		this.standartProduct = standart;
	}

	public Type getType() {
		return typeProduct;
	}

	public void setType(Type type) {
		this.typeProduct = type;
	}

	public String getNamePhoto() {
		return namePhotoProduct;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhotoProduct = namePhoto;
	}
	
	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	

	/* method toString: */



	@Override
	public String toString() {
		return "Product [id=" + idProduct + ", name=" + nameProduct + ", price=" + priceProduct + ", describe=" + describeProduct + ", standart="
				+ standartProduct + ", type=" + typeProduct + ", namePhoto=" + namePhotoProduct + "]";
	}

}
