package com.fedi.patients.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatientt;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nom;
	@NotNull
	@Size (min = 6,max = 12)
	private String prenom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateConsultation;
	@NotNull
	@Size (min = 5,max = 6)
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
