package com.fedi.patients.entities;
import org.springframework.data.rest.core.config.Projection;
public interface PatientProjection {
	@Projection(name = "nomPat", types = { Patient.class })
	public interface ProduitProjection {
	public String getNom();
	}


}
