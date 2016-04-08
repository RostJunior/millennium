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
 * This class is for the storage of roles in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2016-01-30
 * 
 */

@Entity
@NamedQuery(name = "Role.getId", query = "select a from Role a where a.idRole =:idRole")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRole;

	@Column
	private String nameRole;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "roleUser")
	private List<User> usersList;

	/* Constructors: */
	public Role() {

	}

	public Role(String name) {

		this.nameRole = name;
	}

	/* Getters and Setters: */

	public int getId() {
		return idRole;
	}

	public void setId(int id) {
		this.idRole = id;
	}

	public String getName() {
		return nameRole;
	}

	public void setName(String name) {
		this.nameRole = name;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	/* method toString: */

	@Override
	public String toString() {
		return "Role [id=" + idRole + ", name=" + nameRole + "]";
	}

}
