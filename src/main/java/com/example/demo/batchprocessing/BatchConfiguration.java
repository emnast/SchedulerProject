/*package com.example.demo.batchprocessing;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
 
 @Autowired
 public JobBuilderFactory jobBuilderFactory;
 
 @Autowired
 public StepBuilderFactory stepBuilderFactory;

 
 @Autowired
 DataSource dataSource;
 
 private static final String QUERY_FIND_TACHES =
           "select * from hr.task";

   @Bean
   public ItemReader<Task> taskItemReader() {
       JdbcCursorItemReader<Task> databaseReader = new JdbcCursorItemReader<>();

       databaseReader.setDataSource(dataSource);
       databaseReader.setSql(QUERY_FIND_TACHES);
       databaseReader.setRowMapper(new TaskRowMapper());

       return databaseReader;
  }*/
   
 /*
 @Bean
 public CustomItemWriter writer() {
  return new CustomItemWriter();
 }*/
   
	/*@Bean
	public TaskItemProcessor processor() {
		return new TaskItemProcessor();
	}

	  
	@Bean
	public ItemWriter<Task> itemWriter(TaskRepository taskRepository) {
	  	return new ItemWriter<Task>() {
	  		private int task = 0;
	
	  		@Override
	  		public void write(List<? extends Task> items) throws Exception {
	  			task += items.size();
	
	  			System.out.println("written " + task + " brackets");
	
	  		}
	  	};
	}
 
 @Bean
 public Step step1(ItemReader<Task> taskItemReader, ItemWriter<Task> itemWriter) {
  return stepBuilderFactory.get("step1")
    .<Task, Task> chunk(10)
    .reader(taskItemReader)
    .processor(processor())
    .writer(itemWriter)
    .build();
 }
 
 @Bean
 public Job testJob(JobCompletionNotificationListener listener, Step step1) {
  return jobBuilderFactory.get("testJob")
    .incrementer(new RunIdIncrementer())
    //.listener(listener)
    .flow(step1)
    .end()
    .build();
 }
 
	@Bean
	public Job ExecuteTacheJob(JobCompletionNotificationListener listener, Step step1) {
	   return jobBuilderFactory.get("ExecuteTacheJob")
	     .incrementer(new RunIdIncrementer())
	    // .listener(listener)
	     .flow(step1)
	     .end()
	     .build();
	}
}

*/
