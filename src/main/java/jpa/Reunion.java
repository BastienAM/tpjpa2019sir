package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reunion {

	private long id;
	private String libelle;
	private String resume;
	private String lienPad;
	
	private Sondage sondage;
	private List<Reunion_Utilisateur> reunionsUtilisateurs = new ArrayList<Reunion_Utilisateur>();
	
	public Reunion() {}
	
	public Reunion(String libelle, String resume, String lienPad) {
		super();
		this.libelle = libelle;
		this.resume = resume;
		this.lienPad = lienPad;
	}


	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getLienPad() {
		return lienPad;
	}
	public void setLienPad(String lienPad) {
		this.lienPad = lienPad;
	}
	
	@OneToOne
	public Sondage getSondage() {
		return sondage;
	}
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	
	@OneToMany
	public List<Reunion_Utilisateur> getReunionsUtilisateurs() {
		return reunionsUtilisateurs;
	}
	public void setReunionsUtilisateurs(List<Reunion_Utilisateur> reunionsUtilisateurs) {
		this.reunionsUtilisateurs = reunionsUtilisateurs;
	}
	
	
}
