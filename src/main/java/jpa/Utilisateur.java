package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

	private String email;
	private String nom;
	private String prenom;

	private List<Allergie> allergies = new ArrayList<Allergie>();
	private List<Preference> preferences = new ArrayList<Preference>();
	private List<Sondage> sondages = new ArrayList<Sondage>();
	private List<Reunion_Utilisateur> reunionsUtilisateurs = new ArrayList<Reunion_Utilisateur>();
	
	public Utilisateur() {}

	public Utilisateur(String email, String nom, String prenom) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@ManyToMany
	@JoinTable(name = "Utilisateur_Allergie", joinColumns = @JoinColumn(name = "allergies"), inverseJoinColumns = @JoinColumn(name = "id"))
	public List<Allergie> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergie> allergies) {
		this.allergies = allergies;
	}

	@ManyToMany
	@JoinTable(name = "Utilisateur_Preference", joinColumns = @JoinColumn(name = "preferences"), inverseJoinColumns = @JoinColumn(name = "id"))
	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

	@OneToMany(mappedBy = "createur")
	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

	@OneToMany
	public List<Reunion_Utilisateur> getReunionsUtilisateurs() {
		return reunionsUtilisateurs;
	}

	public void setReunionsUtilisateurs(List<Reunion_Utilisateur> reunionsUtilisateurs) {
		this.reunionsUtilisateurs = reunionsUtilisateurs;
	}
	
	

}
