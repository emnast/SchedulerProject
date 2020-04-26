package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Scheduler;
import com.example.demo.service.SchedulerService;


@CrossOrigin
@RestController
@RequestMapping(value = "/scheduler")
public class SchedulerController {

	@Autowired
    private SchedulerService schservice;
	
	@Autowired
	public SchedulerController(SchedulerService schservice) {
		super();
		this.schservice= schservice;
	}
	
	@RequestMapping(method = RequestMethod.GET) 
	public List<Scheduler> listAllScheduler() {
		return schservice.listAllScheduler();
	}

	//Add user
@RequestMapping(method = RequestMethod.POST)
	public Scheduler addScheduler(@RequestBody Scheduler sch) {
		return schservice.addScheduler(sch);
	}

//Modifier user 
@RequestMapping(method = RequestMethod.PUT,value = "/{idScheduler}")
public Scheduler updateScheduler(@PathVariable Integer id, @RequestBody Scheduler sch) {
	return schservice.updateScheduler(id, sch);
}
//delete par id
@RequestMapping(value="/{idScheduler}",method=RequestMethod.DELETE)
public void deleteScheduler(@PathVariable int id) {
	schservice.deleteScheduler(id);
}

//find by id
@RequestMapping(value = "/{idscheduler}",method = RequestMethod.GET )
	public Scheduler getByreferenece(@PathVariable int id) {
		return schservice.getByreferenece(id);
	}

}
