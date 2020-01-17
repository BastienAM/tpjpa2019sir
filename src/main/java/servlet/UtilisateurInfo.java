package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.sir.rest.dao.EntityManagerHelper;
import fr.istic.sir.rest.domain.Allergie;
import fr.istic.sir.rest.domain.JpaTest;
import fr.istic.sir.rest.domain.Preference;
import fr.istic.sir.rest.domain.Utilisateur;

@WebServlet(name = "utilisateurinfo", urlPatterns = { "/UtilisateurInfo" })
public class UtilisateurInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

		//manager.close();
		//EntityManagerHelper.closeEntityManagerFactory();
		
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		String rep = "<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n";
		rep += "<table>";

		List<Utilisateur> utilisateurs = manager.createQuery("Select a From Utilisateur a", Utilisateur.class)
				.getResultList();

		for (Utilisateur utilisateur : utilisateurs) {
			rep += "<tr>";
			rep += "<td>" + utilisateur.getEmail() + "</td>";
			rep += "<td>" + utilisateur.getNom() + "</td>";
			rep += "<td>" + utilisateur.getPrenom() + "</td>";

			rep += "<td> Preferences <ul>";
			for (Preference preference : utilisateur.getPreferences())
				rep += "<li>" + preference.getLibelle() + "</li>";
			rep += "</ul></td>";

			rep += "<td> Allergies <ul>";
			for (Allergie allergie : utilisateur.getAllergies())
				rep += "<li>" + allergie.getLibelle() + "</li>";
			rep += "</ul></td>";
			rep += "</tr>";
		}
		rep += "</table>";
		rep += "</BODY></HTML>";

		out.println(rep);
	}

}
