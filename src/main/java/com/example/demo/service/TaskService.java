package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
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

import com.example.demo.batchprocessing.SchedulerConfig;
import com.example.demo.entity.ListeExecJob;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.batchprocessing.CronUtil;



@Service
@Transactional(propagation = Propagation.SUPPORTS)
@Primary
public class TaskService {

	@Autowired
	private TaskRepository repository;
	

	@Autowired
	private ListeExecJobService service;

	
	private ScheduledTaskRegistrar taskRegistrar;

	@Autowired
	private SchedulerConfig sc;

	@Autowired
	public TaskService(TaskRepository repository) {
		super();
		this.repository = repository;
		this.taskRegistrar = new ScheduledTaskRegistrar();
	}

	public List<Task> listAllTask() {
		return repository.findAll();
	}

	public Task addTask(Task task) {

		ListeExecJob liste = new ListeExecJob();
		/*if (ab == null) {
			ab = task.getListe();
			service.addListeExecJob(ab);
			System.out.println("(Add TASK) Execution List ID:"+ab.getIdListe());
		}
		  ListeExecJob ab = service.getByreferenece(task.getListe().getIdListe());
         if(ab==null) {
       	  ab=task.getListe();
       	  service.addListeExecJob(ab);
       	  System.out.println(ab.getIdListe());*/
		
		if (task.getActive()==true) {
		Runnable runnableTask = () -> sc.executeBatFile(task.getScript(), liste);

		Trigger trigger = new Trigger() {

			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger crontrigger = new CronTrigger(task.getCronExpression());
				return crontrigger.nextExecutionTime(triggerContext);
			}
		};
		taskRegistrar.addTriggerTask(runnableTask, trigger);
		}
		/*List<ListeExecJob> a =task.getListe();
		repository.save(task);
		for (Iterator iterator = a.iterator(); iterator.hasNext();) {
			ListeExecJob e = (ListeExecJob) iterator.next();
			e.setTask(task);
		}
		service.updateList(a);*/
                           rep.save(liste);
				repository.save(task);

		return task;

	}

	public String executeNow(Task t) {
		System.out.println("going to execute the task now...");
		CronTrigger crontrigger;
		String cronExpression = t.getCronExpression();

		cronExpression = "";
		try {
			Date d = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dt = dateFormat.format(d);
			Date cronDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dt);
			CronUtil calHelper = new CronUtil(cronDate);
			cronExpression += "" + calHelper.getSeconds() + 1;
			cronExpression += " " + calHelper.getMins();
			cronExpression += " " + calHelper.getHours();
			cronExpression += " " + calHelper.getDaysOfMonth();
			cronExpression += " " + calHelper.getMonths();
			cronExpression += " ?" ;
			
			System.out.println("generated cron:"+cronExpression);
		} catch (ParseException e) {
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}

		crontrigger = new CronTrigger(cronExpression);
		ListeExecJob liste= new ListeExecJob();
		liste.setTask(t);
		liste.setDate_execution(new Date());
		
		/*ListeExecJob ab = null;
		if(t.getListe() != null)
			ab = service.getByreferenece(((ListeExecJob) t.getListe()).getIdListe());
		else {
			ab = service.addListeExecJob(new ListeExecJob());
			t.setListe((List<ListeExecJob>) ab);
		}
		System.out.println("(Execute Now) Execution List ID:"+ab.getIdListe());
		final ListeExecJob liste = ab;*/
		Runnable runnableTask = () -> sc.executeBatFile(t.getScript(), liste);
		taskRegistrar.addTriggerTask(runnableTask, crontrigger);
		
		
		
		System.out.println("task was executed .");
	//	service.updateListeExecJob(liste.getIdListe(), liste);
		t.addListe(liste);
		liste.setTask(t);
		rep.save(liste);
		repository.save(t);
		return "OK";
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
