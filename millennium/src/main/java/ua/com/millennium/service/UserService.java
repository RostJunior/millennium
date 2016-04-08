package ua.com.millennium.service;

import java.util.List;

import ua.com.millennium.domain.Role;
import ua.com.millennium.domain.User;

public interface UserService {
	
	void createUserFull(String name, String telephone, String email, String login, String password, Role role);
	
	void createUser(String name, String telephone, String email);
	
	List<User> getAllUser();
	
	User findByName(String name);
	void deleteUser(int idUser);
	
	void updateUserFull(int idUser, String name, String telephone, String email, String login, String password, Role role);
	
	void updateUser(int idUser, String name, String telephone, String email);
	
}
