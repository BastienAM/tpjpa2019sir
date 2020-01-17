package fr.istic.sir.rest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sondage {
	
	private long id;
	private DateSondage dateRetenue;
	private String lienWeb;	
	private Utilisateur createur;
	
	private List<DateSondage> datesProposees = new ArrayList<DateSondage>();
	
	public Sondage() {}

	public Sondage(String lienWeb, Utilisateur createur) {
		super();
		this.lienWeb = lienWeb;
		this.createur = createur;
	}


	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne
	public DateSondage getDateRetenue() {
		return dateRetenue;
	}
	public void setDateRetenue(DateSondage dateRetenue) {
		this.dateRetenue = dateRetenue;
	}
	
	
	public String getLienWeb() {
		return lienWeb;
	}
	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
	}
	
	@ManyToOne
	public Utilisateur getCreateur() {
		return createur;
	}
	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
	
	@OneToMany(mappedBy = "sondage")
	public List<DateSondage> getDatesProposees() {
		return datesProposees;
	}
	public void setDatesProposees(List<DateSondage> datesProposees) {
		this.datesProposees = datesProposees;
	}
	
}
