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
@RequestMapping(value = "/listeExecJob")
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
@RequestMapping(value = "/{id}",method = RequestMethod.GET )
public ListeExecJob getByreferenece(@PathVariable int id) {
	return sjiservice.getByreferenece(id);
}

//delete par id
@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
public void deleteListeExecJob(@PathVariable int id) {
	sjiservice.deleteListeExecJob(id);
}

//Modifier user 
@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
public ListeExecJob updateListeExecJob(@PathVariable Integer id, @RequestBody ListeExecJob sji) {
	return sjiservice.updateListeExecJob(id, sji);
}

}
