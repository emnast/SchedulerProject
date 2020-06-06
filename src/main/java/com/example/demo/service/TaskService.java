package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.config.SchedulerConfig;
import com.example.demo.entity.ListeExecJob;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.batchprocessing.CronUtil;



@Service
@Transactional(propagation = Propagation.SUPPORTS)
@Primary
public class TaskService {

	private TaskRepository repository;

	private TaskSchedulerService taskSchedulerService;

	@Autowired
	public TaskService(TaskRepository repository, TaskSchedulerService taskSchedulerService) {
		super();
		this.repository = repository;
		this.taskSchedulerService = taskSchedulerService;
	}

	public List<Task> listAllTask() {
		return repository.findAll();
	}

	public Task addTask(Task task) {
		taskSchedulerService.scheduleTask(Collections.singletonList(task));
        repository.save(task);
		return task;

	}

	public Task updateTask(Integer id, Task task) {
		Task job1 = new Task();
		job1 = task;
		job1.setId(id);
		return addTask(job1);
	}

	public void deleteTask(Integer id) {
		repository.deleteById(id);
	}

	public Task getByreferenece(Integer id) {
		return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
	}
}
