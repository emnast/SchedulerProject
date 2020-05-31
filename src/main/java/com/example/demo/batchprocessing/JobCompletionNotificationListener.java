/*package com.example.demo.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	  private final JdbcTemplate jdbcTemplate;

	  @Autowired
	  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	  }

	  @Override
	  public void afterJob(JobExecution jobExecution) {
	    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
	      log.info("!!! JOB FINISHED! Changer le status de la taches exécutée");*/

	      /*jdbcTemplate.query("SELECT id, libelle FROM taches",
	        (rs, row) -> new Taches(
	          rs.getString(1),
	          rs.getString(2))
	      ).forEach(taches -> log.info("Found <" + taches + "> in the database."));*/
	   /*  }

	    
	   @Override
		  public void afterJob(JobExecution jobExecution) {
			  if( jobExecution.getStatus() == BatchStatus.COMPLETED ){

			        jobExecution.setExitStatus(new ExitStatus("CUSTOM SUCCESS STATUS"));

			    } else if(jobExecution.getStatus() == BatchStatus.FAILED){

			       jobExecution.setExitStatus(new ExitStatus("CUSTOM FAILURE STATUS"));

			    }
		  }
	  }
}*/
