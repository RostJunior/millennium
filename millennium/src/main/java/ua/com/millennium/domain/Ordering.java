package ua.com.millennium.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class is for the storage of orders in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2016-01-30
 * 
 */
@Entity
@NamedQueries(
{
@NamedQuery(name = "Order.getId", query = "select a from Ordering a where a.idOrder =:idOrder"),
@NamedQuery(name = "Order.getStatus", query = "select a from Ordering a where a.status =:status"),
@NamedQuery(name = "Order.getNumberOrder", query = "select a from Ordering a where a.numberOrder =:numberOrder")
})
public class Ordering {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOrder;
	
	@Column
	private String numberOrder;
		
	@Column
	@Temporal(value = TemporalType.DATE)
	private Date dateOrder;
	
	@Column
	private int totalOrder;
	
	@Column
	private String status;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private User deskOrder;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "order")
	private List<Cart> carts;

	
	public Ordering(){
		
	}
	
	
	
	public Ordering(String numberOrder, int totalOrder, User deskOrder) {
		
		
		this.numberOrder = numberOrder;
		this.dateOrder = new Date();
		this.totalOrder = totalOrder;
		this.status = "waiting";
		this.deskOrder = deskOrder;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getNumberOrder() {
		return numberOrder;
	}

	public void setNumberOrder(String numberOrder) {
		this.numberOrder = numberOrder;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getDeskOrder() {
		return deskOrder;
	}

	public void setDeskOrder(User deskOrder) {
		this.deskOrder = deskOrder;
	}



	@Override
	public String toString() {
		return "Ordering [numberOrder=" + numberOrder + ", dateOrder=" + dateOrder + ", totalOrder=" + totalOrder
				+ ", status=" + status + ", deskOrder=" + deskOrder + "]";
	}
	
	

	
}
	