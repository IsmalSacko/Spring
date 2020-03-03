package com.projet.liste;

import java.util.Date;

// import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class ListeAFaire {
	
	private int id;
	private String utilisateur;
	
	@Size(min = 4, message = "Entrer au minimum 4 caractères")
	private String description;
	
	private Date targetDate;
	private boolean estEffectuée;
	
	public ListeAFaire() {
		super();
	}
	
	public ListeAFaire(int id, String utilisateur, String description, Date targetDate, boolean estEffectuée) {
		super();
		this.id = id;
		this.utilisateur = utilisateur;
		this.description = description;
		this.targetDate = targetDate;
		this.estEffectuée = estEffectuée;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isEstEffectuée() {
		return estEffectuée;
	}
	public void setEstEffectuée(boolean estEffectuée) {
		this.estEffectuée = estEffectuée;
	}
	
	@Override
	public String toString() {
		return "ListeAFaire [id=" + id + ", utilisateur=" + utilisateur + ", description=" + description
				+ ", targetDate=" + targetDate + ", estEffectuée=" + estEffectuée + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListeAFaire other = (ListeAFaire) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
