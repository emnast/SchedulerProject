package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Fichier;
import com.example.demo.service.FichierService;

@CrossOrigin
@RestController
@RequestMapping("/Fichier")
public class FichierController {
	@Autowired
	private FichierService fservice;



	public FichierController(FichierService fservice) {
		super();
		this.fservice = fservice;
	}

	// @PostMapping("/tasks")
	@RequestMapping(method = RequestMethod.GET)
	public List<Fichier> listAllFichier() {
		return fservice.listAllFichier();
	}

	// Add task

	@RequestMapping(method = RequestMethod.POST)
	public Fichier addFichier(@RequestBody Fichier f) {
		return fservice.addFichier(f);
	}

	// find by id
	@RequestMapping(value = "/findById/{idFichier}", method = RequestMethod.GET)
	public Fichier getByreferenece(@PathVariable Integer id) {
		return fservice.getByreferenece(id);
	}

	// delete par id
	@RequestMapping(value = "/{idFichier}", method = RequestMethod.DELETE)
	public void deleteFichier(@PathVariable Integer id) {
		fservice.deleteFichier(id);
	}

	// Modifier user
	@RequestMapping(value = "/{idFichier}", method = RequestMethod.PUT)
	public Fichier updateFichier(@PathVariable Integer id, @RequestBody Fichier f) {
		return fservice.updateFichier(id, f);
	}
}
