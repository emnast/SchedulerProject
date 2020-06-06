package com.example.demo.listener;

import java.util.Date;
import java.util.List;

import com.example.demo.config.SchedulerConfig;
import com.example.demo.service.TaskSchedulerService;
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
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartupApplicationListenerExample implements ApplicationListener<ContextStartedEvent> {

	@Autowired 
	private TaskRepository repository;

	@Autowired
	private TaskSchedulerService taskSchedulerService;

 
    @Override
    @Transactional
    public void onApplicationEvent(ContextStartedEvent event) {
		List<Task> tasks = repository.findAll();
		taskSchedulerService.scheduleTask(tasks);
		tasks.forEach(repository::save);
    }

}
