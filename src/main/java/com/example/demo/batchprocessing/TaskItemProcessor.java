package com.example.demo.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.demo.entity.Task;
public class TaskItemProcessor implements ItemProcessor<Task, Task> {

	  private static final Logger log = LoggerFactory.getLogger(TaskItemProcessor.class);

	  @Override
	  public Task process(final Task task) throws Exception {
		  System.out.println("Traitement de la taches");
		  
		  if(task == null) {
			  throw new NullPointerException("Aucune tache disponible");
		  }
		  /**Sinon
		  /* Si une tache existe alors et que le status est en attente et la date d'execution
		  */
		  System.out.println("task name " + task.getNom_job());

		  
		  return task;
	  }

}
