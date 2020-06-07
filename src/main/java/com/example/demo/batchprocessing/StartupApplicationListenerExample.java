/*package com.example.demo.batchprocessing;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ListeExecJob;
import com.example.demo.entity.Task;
import com.example.demo.repository.ListeExecJobRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.ListeExecJobService;
import com.example.demo.service.TaskService;

@Component
public class StartupApplicationListenerExample implements
  ApplicationListener<ContextStartedEvent> {

	@Autowired 
	private TaskRepository repository;
	
	@Autowired
	private ListeExecJobRepository rep;

	@Autowired
	private ListeExecJobService service;
	

	@Autowired
	private TaskService ser;

	
	private ScheduledTaskRegistrar taskRegistrar;

	@Autowired
	private SchedulerConfig sc;
 
    @Override 
    public void onApplicationEvent(ContextStartedEvent event) {
    	
    	ListeExecJob liste = new ListeExecJob();
    	Task task=new Task();
		
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
		rep.save(liste);
		repository.save(task);
    }

}*/
