package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reunion_Utilisateur {
	
	private long id;
	private String lienWeb;
	private String clearCode;
	
	private List<DateSondage> datesSelectionnees = new ArrayList<DateSondage>();
	private Reunion reunion;
	private Utilisateur utilisateur;
	
	public Reunion_Utilisateur() {}
	
	public Reunion_Utilisateur(String lienWeb, String clearCode, Reunion reunion, Utilisateur utilisateur) {
		super();
		this.lienWeb = lienWeb;
		this.clearCode = clearCode;
		this.reunion = reunion;
		this.utilisateur = utilisateur;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLienWeb() {
		return lienWeb;
	}
	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
	}
	public String getClearCode() {
		return clearCode;
	}
	public void setClearCode(String clearCode) {
		this.clearCode = clearCode;
	}
	
	@ManyToMany
	@JoinTable(name = "Date_Selectionnee", joinColumns = @JoinColumn(name = "datesSelectionnees"), inverseJoinColumns = @JoinColumn(name = "id"))
	public List<DateSondage> getDatesSelectionnees() {
		return datesSelectionnees;
	}
	public void setDatesSelectionnees(List<DateSondage> datesSelectionnees) {
		this.datesSelectionnees = datesSelectionnees;
	}
	
	
	@ManyToOne
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
	@ManyToOne
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
