package com.fedi.patients.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fedi.patients.entities.Patient;
public interface PatientRepository extends JpaRepository<Patient , Long> {

}
