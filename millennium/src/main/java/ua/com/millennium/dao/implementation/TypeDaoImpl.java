package ua.com.millennium.dao.implementation;

import org.springframework.stereotype.Repository;

import ua.com.millennium.dao.TypeDao;
import ua.com.millennium.domain.Type;

/**
 * The practical implementation of operations TypeDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class TypeDaoImpl extends GeneralDaoImpl<Type, Integer> implements TypeDao {

	public TypeDaoImpl() {
		super(Type.class);
		
	}

	public Type findById(int id) {
		
		return (Type) em.createNamedQuery("Type.getId").setParameter("idType", id).getSingleResult();
	}
	
	

}
