package com.example.demo.service;

import com.example.demo.entity.ListeExecJob;
import com.example.demo.entity.Task;
import com.example.demo.repository.ListeExecJobRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class TaskSchedulerService {

	private ScheduledTaskRegistrar taskRegistrar;
	private ListeExecJobRepository listeExecJobRepository;
	private TaskRepository taskRepository;
	private ScheduledExecutorService executor;

	@Autowired
	public TaskSchedulerService(final ScheduledTaskRegistrar taskRegistrar, final ListeExecJobRepository listeExecJobRepository,
	                            final ScheduledExecutorService executor, final TaskRepository taskRepository) {
		this.taskRegistrar = taskRegistrar;
		this.listeExecJobRepository = listeExecJobRepository;
		this.executor = executor;
		this.taskRepository = taskRepository;
	}

	public void scheduleTask(List<Task> tasks){
		ListeExecJob liste= new ListeExecJob();

		tasks.stream().filter(Task::getActive).forEach(t -> {
			liste.setTask(t);
			liste.setDate_execution(new Date());

			Runnable runnableTask = () -> executeBatFile(t.getScript(), liste);
			liste.setFin_execution(new Date());

			Trigger trigger = triggerContext -> {
				CronTrigger crontrigger = new CronTrigger(t.getCronExpression());
				return crontrigger.nextExecutionTime(triggerContext);
			};

			taskRegistrar.addTriggerTask(runnableTask, trigger);
			liste.setFin_execution(new Date());
			t.addListe(liste);
			listeExecJobRepository.save(liste);
		});
	}

	public String executeNow(Task t) {
		System.out.println("going to execute the task now...");
		ListeExecJob liste= new ListeExecJob();
		liste.setTask(t);
		liste.setDate_execution(new Date());

		Runnable runnableTask = () -> executeBatFile(t.getScript(), liste);
		executor.schedule(runnableTask,3L, TimeUnit.SECONDS);

		System.out.println("task was executed .");
		t.addListe(liste);
		liste.setTask(t);
		listeExecJobRepository.save(liste);
		taskRepository.save(t);
		return "OK";
	}

	private void executeBatFile(String filePath, ListeExecJob liste) {
		try {
			Runtime.getRuntime().exec("cmd /c " + filePath);
			liste.setStatus("success");
		} catch (IOException e) {
			e.printStackTrace();
			liste.setStatus("failed");
		}
	}

}
