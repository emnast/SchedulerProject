package com.example.demo;


import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan(basePackages = {"com.example"})
@EnableJpaRepositories("com.example.demo.repository")
@EnableScheduling
@EnableJpaAuditing
@EnableConfigurationProperties
@SpringBootApplication
public class ProjectSchedulerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ProjectSchedulerApplication.class, args);
		applicationContext.start();
	}

}
