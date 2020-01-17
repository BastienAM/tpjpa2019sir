package fr.istic.sir.rest.domain;

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
}
