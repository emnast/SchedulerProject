package com.example.demo.batchprocessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Stream;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ListeExecJob;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;


@ConditionalOnProperty(name = "scheduler.enabled")
@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer, DisposableBean {

	@Value("${scheduler.trigger.cron-expression}")
	protected String cronExpression;
	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	
	 @Value("${scheduler.enabled:true}")
	    private boolean active;
	
	@Autowired
	private TaskRepository repository;

	@Override
	
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		//List<Task> tasks = Arrays.asList(new Task(), new Task());//get from DB
		
		List<Task> tasks = repository.findAll();
		tasks.forEach(t -> {
			
	//if(t.getActive() == true) {
		
			ListeExecJob liste= new ListeExecJob();
			//liste.setTask(tasks);
			liste.setDate_execution(t.getDate_execution());
			
			Runnable runnableTask = () -> executeBatFile(t.getScript(), liste);
			liste.setFin_execution(new Date());
	
			Trigger trigger = new Trigger() {

				@Override
				public Date nextExecutionTime(TriggerContext triggerContext) {

					CronTrigger crontrigger = new CronTrigger(t.getCronExpression());

					return crontrigger.nextExecutionTime(triggerContext);

				}

			};

			taskRegistrar.addTriggerTask(runnableTask, trigger);
//	}
		});
		
	}

	@Override
	public void destroy() throws Exception {

		if (executor != null) {

			executor.shutdownNow();

		}
	}
	
	//@Transactional(readOnly=true)
	public void executeBatFile(String filePath, ListeExecJob liste) {
		try {
			
			Runtime.getRuntime().
			   exec("cmd /c " + filePath);
			liste.setStatus("success");
			
		} catch (IOException e) {
			e.printStackTrace();
			liste.setStatus("failed");
			
		}
		
	}

}

