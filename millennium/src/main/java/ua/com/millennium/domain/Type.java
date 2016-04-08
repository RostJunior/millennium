package ua.com.millennium.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * This class is for storage of types of goods in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2016-01-30
 * 
 */
@Entity
@NamedQuery(name = "Type.getId", query = "select a from Type a where a.idType=:idType")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idType;
	
	@Column
	private String nameType;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "typeProduct")
	private List<Product> productList;

	/* Constructors: */

	public Type() {

	}

	public Type(String name) {
		this.nameType = name;
	}

	/* Getters and Setters: */

	public int getId() {
		return idType;
	}

	public void setId(int id) {
		this.idType = id;
	}

	public String getName() {
		return nameType;
	}

	public void setName(String name) {
		this.nameType = name;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	/* method toString: */

	@Override
	public String toString() {
		return "Type [id=" + idType + ", name=" + nameType + "]";
	}

}
