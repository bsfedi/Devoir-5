package com.fedi.patients.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fedi.patients.entities.Medecin;
import com.fedi.patients.entities.Patient;
@RepositoryRestResource(path = "rest")
public interface PatientRepository extends JpaRepository<Patient , Long> {
	List<Patient> findByNom(String nom);
	List<Patient> findByNomContains(String nom);
	/*@Query("select p from Patient p where p.nom like %?1 and p.prenom like %?2 ")
	List<Patient> findByNomPrenomPatient (String nom, String prenom);*/

	@Query("select p from Patient p where p.nom like %:nomP and p.prenom like %:prenomP")
	List<Patient> findByNomPrenomPatient (@Param("nomP") String nom,@Param("prenomP") String prenom);

	@Query("select p from Patient p where p.medecin = ?1")
	List<Patient> findByMedecin (Medecin medecin);
	
	List<Patient> findByMedecinIdMed(Long id);
	
	List<Patient> findByOrderByNomAsc();
	
	@Query("select p from Patient p order by p.nom ASC, p.prenom DESC")
	List<Patient> trierPatientsNomPrenom ();



}
