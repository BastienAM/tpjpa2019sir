package jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		JpaTest jpaTest = new JpaTest(manager);

		try {
			jpaTest.creationUtilisateur();
			jpaTest.createSondage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		// factory.close();
	}

	public void creationUtilisateur() {
		Preference preference1 = new Preference("Porc au caramel");
		Preference preference2 = new Preference("Poulet coco");
		Preference preference3 = new Preference("POISSON");

		List<Preference> lP1 = new ArrayList<Preference>();
		lP1.add(preference1);
		lP1.add(preference2);
		lP1.add(preference3);

		Allergie allergie1 = new Allergie("ROUX");
		Allergie allergie2 = new Allergie("salerno");

		List<Allergie> lA1 = new ArrayList<Allergie>();
		List<Allergie> lA2 = new ArrayList<Allergie>();

		lA1.add(allergie1);
		lA1.add(allergie2);

		lA2.add(allergie2);

		Utilisateur u1 = new Utilisateur("gjjjjjjjjjjjjjjjjj", "Salerno", "Quentin");
		Utilisateur u2 = new Utilisateur("quentinbgdu35@gmail.com", "Sarrazin", "Dadmien");
		Utilisateur u3 = new Utilisateur("sdcsdv", "dvwxdv", "wsvxdv");

		u1.setPreferences(lP1);
		u1.setAllergies(lA2);
		u2.setAllergies(lA1);

		manager.persist(u1);
		manager.persist(u2);
		manager.persist(u3);
		manager.persist(preference1);
		manager.persist(preference2);
		manager.persist(preference3);
		manager.persist(allergie1);
		manager.persist(allergie2);
	}

	public void createSondage() {
		List<Utilisateur> utilisateurs = manager.createQuery("Select a From Utilisateur a", Utilisateur.class)
				.getResultList();
		if (utilisateurs.size() > 0) {
			Sondage sondage = new Sondage(
					"https://docs.google.com/document/d/1IfN_LvfZCZJIu4aNO3_2zpZqAsjObqWRd8Bs4sYtN1I/edit",
					utilisateurs.get(0));
			List<DateSondage> ld = new ArrayList<DateSondage>();

			DateSondage ds1 = new DateSondage(new Date(2019, 1, 1), sondage);
			DateSondage ds2 = new DateSondage(new Date(), sondage);
			DateSondage ds3 = new DateSondage(new Date(2020, 1, 1), sondage);

			ld.add(ds1);
			ld.add(ds2);
			ld.add(ds3);
			
			sondage.setDateRetenue(ds2);
			
			sondage.setDatesProposees(ld);

			Reunion reunion1 = new Reunion("reunionA", "ffff",
					"https://www.google.com/search?q=s&rlz=1C1GCEB_enFR883FR883&oq=s&aqs=chrome..69i57j0l4j69i60.848j0j7&sourceid=chrome&ie=UTF-8");
			reunion1.setSondage(sondage);
			
			int i = 0;
			for(Utilisateur elem: utilisateurs) {
				List<Reunion_Utilisateur> reunionsUtilisateurs = new ArrayList<Reunion_Utilisateur>();
				Reunion_Utilisateur ru = new Reunion_Utilisateur("hugcfxdw", "ADID54"+i, reunion1, elem);
				reunionsUtilisateurs.add(ru);

				 manager.persist(ru);
				 i++;
			 }
			
			manager.persist(sondage);
			manager.persist(reunion1);

			manager.persist(ds1);
			manager.persist(ds2);
			manager.persist(ds3);
		}

	}

}
