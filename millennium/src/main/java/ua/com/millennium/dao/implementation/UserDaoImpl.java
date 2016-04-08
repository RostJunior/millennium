package ua.com.millennium.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.millennium.dao.UserDao;
import ua.com.millennium.domain.User;

/**
 * The practical implementation of operations UserDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class UserDaoImpl extends GeneralDaoImpl<User, Integer> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
		
	}

	@Transactional
	public User findById(int id) {
		
		return (User) em.createNamedQuery("User.getId").setParameter("idUser", id).getSingleResult();
	}

	public User findByName(String name) {
		
		return (User) em.createNamedQuery("User.getNameUser").setParameter("nameUser", name).getSingleResult();
	}

}
