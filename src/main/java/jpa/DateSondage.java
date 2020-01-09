package jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class DateSondage {

	private long id;
	private Date date;

	private Sondage sondage;

	private List<Reunion_Utilisateur> utilisateurs = new ArrayList<Reunion_Utilisateur>();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(mappedBy = "datesProposees")
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	@ManyToMany(mappedBy = "datesSelectionnees")
	public List<Reunion_Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Reunion_Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}
