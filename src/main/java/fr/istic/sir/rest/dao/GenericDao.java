package fr.istic.sir.rest.dao;

import java.util.List;

public class GenericDao<T> {

	private Class<T> type;

	public GenericDao(Class<T> type) {
		this.type = type;
	}

	public T findById(Object id) {
		return EntityManagerHelper.getEntityManager().find(type, id);
	}

	public T create(T u) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(u);
		EntityManagerHelper.commit();
		return u;
	}

	public T update(T u) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().merge(u);
		EntityManagerHelper.commit();
		return u;
	}

	public List<T> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select u from " + type.getName() + " as u", type)
				.getResultList();
	}

	public void delete(Object id) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findById(id));
		EntityManagerHelper.commit();
	}
}
