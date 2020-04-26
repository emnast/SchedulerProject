package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

import java.util.List;

@Service
@Transactional
@Primary
public class TaskService {

	@Autowired
    private TaskRepository repository;
	
	@Autowired
	public TaskService(TaskRepository repository) {
		super();
		this.repository = repository;
	}
	
    public List<Task> listAllTask(){
        return repository.findAll();
    }
    public Task addTask(Task task){
       return repository.save(task);
    }
    
    public Task updateTask(Integer id , Task task){
    	Task job1 = new Task();
    	job1 = task;
    	job1.setId(id);
    	return addTask(job1);
     }
    public void deleteTask(Integer id){
        repository.deleteById(id);
    }
    public Task getByreferenece(Integer id){
    	 return repository.findById(id).isPresent()? repository.findById(id).get():null;
    }
}

