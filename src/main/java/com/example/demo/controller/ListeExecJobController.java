package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ListeExecJob;
import com.example.demo.service.ListeExecJobService;


@CrossOrigin
@RestController
@RequestMapping("/Liste")
public class ListeExecJobController {
	
	@Autowired
    private ListeExecJobService sjiservice;

	@Autowired
	public ListeExecJobController(ListeExecJobService SJIService) {
		super();
		this.sjiservice= SJIService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET) 
    public List<ListeExecJob> listAllListeExecJob() {
 	return sjiservice.listAllListeExecJob();
}

	//Add user
@RequestMapping(method = RequestMethod.POST)
public ListeExecJob addListeExecJob(@RequestBody ListeExecJob sji) {
	return sjiservice.addListeExecJob(sji);
}

// find by id
@RequestMapping(value = "/findById/{idListe}", method = RequestMethod.GET )
public ListeExecJob getByreferenece(@PathVariable Integer idListe) {
	return sjiservice.getByreferenece(idListe);
}

//delete par id
@RequestMapping(value="/{idListe}",method=RequestMethod.DELETE)
public void deleteListeExecJob(@PathVariable Integer idListe) {
	sjiservice.deleteListeExecJob(idListe);
}

//Modifier user 
@RequestMapping(value = "/{idListe}", method = RequestMethod.PUT)
public ListeExecJob updateListeExecJob(@PathVariable Integer idListe, @RequestBody ListeExecJob sji) {
	return sjiservice.updateListeExecJob(idListe, sji);
}

}
