package com.example.demo.config;

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
import org.springframework.context.annotation.Bean;
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
import com.example.demo.repository.ListeExecJobRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.ListeExecJobService;
import com.example.demo.service.TaskService;


@ConditionalOnProperty(name = "scheduler.enabled")
@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

	private ScheduledTaskRegistrar taskRegistrar;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		this.taskRegistrar = taskRegistrar;
		taskRegistrar.setScheduler(executor());
	}

	@Bean(destroyMethod="shutdown")
	public ScheduledExecutorService executor() {
		return Executors.newSingleThreadScheduledExecutor();
	}

	@Bean
	public ScheduledTaskRegistrar taskRegistrar(){
		return taskRegistrar;
	}
}

