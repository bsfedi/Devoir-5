package com.fedi.patients;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.fedi.patients.entities.Patient;
import com.fedi.patients.repos.*;
import com.fedi.patients.service.PatientService;
@SpringBootTest
class PatientsApplicationTests {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private PatientService patientService ;
	@Test
	public void testCreatePatient() {
		Patient pat = new Patient("Ali","Ben Slaha",new Date(),"16:00");
		patientRepository.save(pat);
		}
	 @Test
	 public void testFindPatientt()
	 {
	 Patient p = patientRepository.findById(1L).get();
	 System.out.println(p);
	 }
	 @Test
	 public void testUpdatePatient()
	 {
	  Patient p = patientRepository.findById(1L).get();
	 p.setPrenom("ben ahmed");
	 patientRepository.save(p);
	 }
	 @Test
	 public void testDeletePatient(){
		 patientRepository.deleteById(1L);;
	 }
	 @Test
	 public void testListerTousPatients()
	 {
	 List<Patient> pats = patientRepository.findAll();
	 for (Patient p : pats)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testFindByNomProduitContains()
	 {
	 Page<Patient> pats = patientService.getAllPatientsParPage(0,2);
	 System.out.println(pats.getSize());
	 for (Patient  p : pats)
	 {
	 System.out.println(p);
	 }}
}
