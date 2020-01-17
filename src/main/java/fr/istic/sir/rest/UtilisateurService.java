package fr.istic.sir.rest;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import fr.istic.sir.rest.dao.DaoUtilisateur;
import fr.istic.sir.rest.dao.EntityManagerHelper;
import fr.istic.sir.rest.domain.Utilisateur;

public class UtilisateurService {

	DaoUtilisateur daoUtilisateur;

	@GET
	@Path("/utilisateur/{utilisateuremail}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur getUtilisateur(@PathParam("utilisateuremail") String email) {
		Utilisateur u = this.daoUtilisateur.findByEmail(email);
		return u;
	}

	@GET
	@Path("/utilisateur/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilisateur> getUtilisateurs() {
		return daoUtilisateur.findAll();

	}

	@POST
	@Path("/utilisateur/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Utilisateur createUtilisateur(Utilisateur u) {
		return daoUtilisateur.save(u);

	}
	
	@DELETE
	@Path("/utilisateur/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUtilisateur(Utilisateur u) {
		daoUtilisateur.delete(u.getEmail());
	}

}
