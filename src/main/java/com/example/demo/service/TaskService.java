package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ListeExecJob;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

import java.util.List;

@Service
@Transactional(propagation= Propagation.SUPPORTS)
@Primary
public class TaskService {

	@Autowired
    private TaskRepository repository;
	
	@Autowired
    private ListeExecJobService service;
	
	@Autowired
	public TaskService(TaskRepository repository) {
		super();
		this.repository = repository;
	}
	
    public List<Task> listAllTask(){
        return repository.findAll();
    }
    public Task addTask(Task task){
     //  return repository.save(task);
      ListeExecJob ab = service.getByreferenece(task.getListe().getIdListe());
    	task.setListe(ab);
		ab.addTask(task);
		System.out.println(task.getListe().getIdListe());
    	ab.addTask(task);
    	repository.save(task);
    	
    /*		ListeExecJob ab = service.getByreferenece(((Task) task).getListe().getIdListe());
		ab.addTask(task);*/
		
    	
    	return task;
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

