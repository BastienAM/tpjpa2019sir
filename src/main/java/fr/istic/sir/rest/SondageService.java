package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import fr.istic.sir.rest.dao.DaoSondage;
import fr.istic.sir.rest.dao.GenericDao;
import fr.istic.sir.rest.domain.Sondage;

public class SondageService {
	
	DaoSondage daoSondage;
	
	@GET
	@Path("/sondage/{sondageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Sondage getSondage(@PathParam("sondageid") String id) {
		
		GenericDao<Sondage> dao = new GenericDao<Sondage>(Sondage.class);
		return daoSondage.findById(id);
	}

}
