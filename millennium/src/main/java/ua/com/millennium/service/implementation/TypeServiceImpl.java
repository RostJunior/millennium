package ua.com.millennium.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.millennium.dao.TypeDao;
import ua.com.millennium.domain.Type;
import ua.com.millennium.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService{
	
	@Autowired
	private TypeDao dao;

	public void createType(String name) {
		
		Type type = new Type(name);
		
		dao.create(type);
		
	}

	public List<Type> getAllType() {
		
		return dao.getAll();
	}

	public void deleteType(int idType) {
		
		dao.delete(dao.findById(idType));
		
	}

	public void updateType(int idType, String name) {
		
		Type type = dao.findById(idType);
		
		type.setName(name);
		
		dao.edit(type);
		
	}

	public Type findByIdType(int idType) {
		
		return dao.findById(idType);
		
	}
	
	

}
