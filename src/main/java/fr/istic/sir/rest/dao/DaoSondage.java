package fr.istic.sir.rest.dao;

import fr.istic.sir.rest.domain.Sondage;

public class DaoSondage {
	
	public Sondage findById(String id) {
        return EntityManagerHelper.getEntityManager().find(Sondage.class, id);
    }

}
