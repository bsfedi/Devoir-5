package com.fedi.patients.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fedi.patients.entities.*;
import com.fedi.patients.service.*;
@Controller
public class PatientControllelr {
	@Autowired
	PatientService patientService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("patient", new Patient());
	modelMap.addAttribute("mode","new");
	return "formPatient";
	}

	@RequestMapping("/savePatient")
	public String savePatient(@Valid Patient patient ,BindingResult bindingResult)

	{
	if (bindingResult.hasErrors()) return "formPatient";
	patientService.savePatient(patient);
	return "formPatient";
	}
	

	@RequestMapping("/listePatients")
	public String listePatients(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)

	{
	Page<Patient> pats = patientService.getAllPatientsParPage(page,size);
	modelMap.addAttribute("patients", pats);
	modelMap.addAttribute("pages", new int[pats.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);

	return "listePatients";
	}
	@RequestMapping("/supprimerPatient")
	public String supprimerPatient(@RequestParam("id") Long id,
	 ModelMap modelMap,@RequestParam (name="page",defaultValue = "3") int page,
	 @RequestParam (name="size", defaultValue = "3") int size)

	{
	patientService.deletePatientById(id);
	Page<Patient> pats = patientService.getAllPatientsParPage(page, size);
	modelMap.addAttribute("patients", pats);
	modelMap.addAttribute("pages", new int[pats.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);

	return "listePatients";
	}
	@RequestMapping("/modifierPatient")
	public String editerPatient(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Patient p= patientService.getPatient(id);
	modelMap.addAttribute("patient", p);
	modelMap.addAttribute("mode","edit");
	return "formPatient";
	}
	@RequestMapping("/updatePatient")
	public String updatePatient(@ModelAttribute("patient") Patient patient,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateConsultation = dateformat.parse(String.valueOf(date));
	 patient.setDateConsultation(dateConsultation);

	 patientService.updatePatient(patient);
	 List<Patient> pats = patientService.getAllPatients();
	 modelMap.addAttribute("patients", pats);
	return "listePatients";
	}
}
