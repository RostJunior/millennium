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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * This class is for the storage of users in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2016-01-30
 * 
 */

@Entity
@NamedQueries(
{
	@NamedQuery(name = "User.getId", query = "select a from User a where a.idUser =:idUser"),
	@NamedQuery(name = "User.getNameUser", query = "select a from User a where a.nameUser =:nameUser")

})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	
	@Column
	private String nameUser;
	
	@Column
	private String telephoneUser;
	
	@Column
	private String emailUser;
	
	@Column
	private String loginUser;
	
	@Column
	private String passwordUser;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Role roleUser;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "deskOrder")
	private List<Ordering> orders;

	/* Constructors: */
	public User() {

	}

	public User(String name, String telephone, String email, String login, String password, Role role) {

		this.nameUser = name;
		this.telephoneUser = telephone;
		this.emailUser = email;
		this.loginUser = login;
		this.passwordUser = password;
		this.roleUser = role;
	}

	public User(String name, String telephone, String email) {

		this.nameUser = name;
		this.telephoneUser = telephone;
		this.emailUser = email;
	}
	
	/* Getters and Setters: */

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getTelephoneUser() {
		return telephoneUser;
	}

	public void setTelephoneUser(String telephoneUser) {
		this.telephoneUser = telephoneUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public Role getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(Role roleUser) {
		this.roleUser = roleUser;
	}
	
	/* method toString: */

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", telephoneUser=" + telephoneUser + ", emailUser="
				+ emailUser + ", loginUser=" + loginUser + ", passwordUser=" + passwordUser + ", roleUser=" + roleUser
				+ "]";
	}

}

	