package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Fichier;
import com.example.demo.entity.ListeExecJob;
import com.example.demo.entity.Task;
import com.example.demo.repository.FichierRepository;

@Service
@Transactional
@Primary
public class FichierService {

	@Autowired
	private FichierRepository repoF;
	
	@Autowired
	private TaskService s;
	
	@Autowired
	private ListeExecJobService serviceliste;

	public FichierService(FichierRepository repoF) {
		super();
		this.repoF = repoF;
	}

	public List<Fichier> listAllFichier() {
		return repoF.findAll();
	}

	public Fichier addFichier(Fichier f) {
 
        ListeExecJob liste = serviceliste.getByreferenece(f.getListe().getIdListe());
		liste.setF(f);
		return repoF.save(f);
	}

	public Fichier updateFichier(Integer id, Fichier f) {
		Fichier f1  = new Fichier();
		f1 = f;
		f1.setIdFichier(id);
		return addFichier(f1);
	}

	public void deleteFichier(Integer id) {
		repoF.deleteById(id);
	}

	public Fichier getByreferenece(Integer id) {
		return repoF.findById(id).isPresent() ? repoF.findById(id).get() : null;
	}

}
