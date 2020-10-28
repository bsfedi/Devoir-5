package com.fedi.patients;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fedi.patients.entities.Patient;
import com.fedi.patients.service.PatientService;

@SpringBootApplication
public class PatientsApplication implements CommandLineRunner{
	@Autowired
	PatientService patientService;

	public static void main(String[] args) {
		SpringApplication.run(PatientsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	patientService.savePatient(new Patient("Ahmed","cherif",new Date(),"15:00"));
	patientService.savePatient(new Patient("Ali","msakni",new Date(),"16:00"));
	patientService.savePatient(new Patient("Jed","Ben ahmed",new Date(),"17:00"));
	}
}
