package ua.com.millennium.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.millennium.dao.UserDao;
import ua.com.millennium.domain.Role;
import ua.com.millennium.domain.User;
import ua.com.millennium.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	public void createUserFull(String name, String telephone, String email, String login, String password, Role role) {
		
		User user = new User(name, telephone, email, login, password, role);
		
		dao.create(user);
		
	}

	public void createUser(String name, String telephone, String email) {
		
		User user = new User(name, telephone, email);
		
		dao.create(user);
		
	}

	public List<User> getAllUser() {
		
		return dao.getAll();
	}

	public void deleteUser(int idUser) {
		
		dao.delete(dao.findById(idUser));
		
	}

	public void updateUserFull(int idUser, String name, String telephone, String email, String login, String password,
			Role role) {
		
		User user = dao.findById(idUser);
		user.setNameUser(name);
		user.setTelephoneUser(telephone);
		user.setEmailUser(email);
		user.setLoginUser(login);
		user.setPasswordUser(password);
		user.setRoleUser(role);
		
		dao.edit(user);
		
	}

	public void updateUser(int idUser, String name, String telephone, String email) {
		
		User user = dao.findById(idUser);
		
		user.setNameUser(name);
		user.setTelephoneUser(telephone);
		user.setEmailUser(email);
		
		dao.edit(user);
		
	}

	public User findByName(String name) {
		
		return dao.findByName(name);
	}

}
