package com.fedi.patients.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatientt;
	private String nom;
	private String prenom;
	private Date dateConsultation;
	private String heure ;
	
	@ManyToOne
	private Medecin medecin ;
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Patient() {
		super();
	}
	
	public Patient(String nom, String prenom, Date dateConsultation, String heure) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateConsultation = dateConsultation;
		this.heure = heure;
	}

	public Long getIdPatientt() {
		return idPatientt;
	}
	public void setIdPatientt(Long idPatientt) {
		this.idPatientt = idPatientt;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	@Override
	public String toString() {
		return "Patient [idPatientt=" + idPatientt + ", nom=" + nom + ", prenom=" + prenom + ", dateConsultation="
				+ dateConsultation + ", heure=" + heure + "]";
	}
	
	

}
