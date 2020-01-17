package fr.istic.sir.rest.dao;

public class GenericDao<T> {
	 final Class<T> typeParameterClass;
	 
	 public GenericDao(Class<T> typeParameterClass) {
	        this.typeParameterClass = typeParameterClass;
	    }
	 
	public T findById(String id) {
        return EntityManagerHelper.getEntityManager().find(typeParameterClass, id);
    }
}
