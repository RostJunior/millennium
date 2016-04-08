package ua.com.millennium.service;

import java.util.List;

import ua.com.millennium.domain.Type;

public interface TypeService {
	
	void createType(String name);
	
	List<Type> getAllType();
	
	Type findByIdType(int idType);
	
	void deleteType(int idType);
	
	void updateType(int idType, String name);
	
	
}
