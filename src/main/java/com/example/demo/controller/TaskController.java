package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Task")
public class TaskController {
	
	
	@Autowired
    private TaskService jobservice;
	
   /* public String viewHomePage(Model model) {
        List<Job> listJob = jobservice.listAllJob();
        model.addAttribute("listJob", listJob);
        return "index";
    }*/

	@Autowired
	public TaskController(TaskService jobservice) {
		super();
		this.jobservice = jobservice;
	}

		//@PostMapping("/tasks")
	@RequestMapping(method = RequestMethod.GET) 
	public List<Task> listAllTask() {
		return jobservice.listAllTask();
	}

		//Add task
	@RequestMapping(method = RequestMethod.POST)
	public Task addTask(@RequestBody Task task) {
		return jobservice.addTask(task);
	}

	// find by id
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET )
	public Task getByreferenece(@PathVariable Integer id) {
		return jobservice.getByreferenece(id);
	}

	//delete par id
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deleteTask(@PathVariable Integer id) {
		jobservice.deleteTask(id);
	}

	//Modifier task
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Task updateTask(@PathVariable Integer id, @RequestBody Task task) {
		return jobservice.updateTask(id, task);
	}
	
		// executeNow
	@RequestMapping(value = "/executeNow", method = RequestMethod.POST)
	public void executeNow(@RequestBody Task task) {
		System.out.println("Controller: going to execute the task now...");
		String result = jobservice.executeNow(task);
		System.out.println("result: "+result);
		System.out.println("Controller: task was executed .");
	}

}
