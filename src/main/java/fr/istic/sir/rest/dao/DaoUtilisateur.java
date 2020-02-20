package fr.istic.sir.rest.dao;

import java.util.List;

import fr.istic.sir.rest.domain.Utilisateur;

public class DaoUtilisateur {

	public Utilisateur findByEmail(String email) {
		return EntityManagerHelper.getEntityManager().find(Utilisateur.class, email);

	}

	public Utilisateur save(Utilisateur u) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(u);

		EntityManagerHelper.commit();
		return u;

	}

	public List<Utilisateur> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u", Utilisateur.class)
				.getResultList();
	}

	public void delete(String email) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findByEmail(email));
		EntityManagerHelper.commit();
	}

}
