/*package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BatchJobExecution;
import com.example.demo.service.BatchJobExecutionService;



@CrossOrigin
@RestController
@RequestMapping(value = "/BatchJobExec")
public class BatchJobExecutionController {
	@Autowired
    private BatchJobExecutionService batchservice;

	public BatchJobExecutionController(BatchJobExecutionService batchservice) {
		super();
		this.batchservice= batchservice;
		
	}

	@RequestMapping(method = RequestMethod.GET) 
    public List<BatchJobExecution> findAllBatches() {
        return batchservice.findAllBatches();
    }

	@RequestMapping(value = "/{createTime}",method = RequestMethod.GET )
    public List<BatchJobExecution> findBatchesByCreateTime(Date createTime) {
        return batchservice.findBatchesByCreateTime(createTime);
    }

	@RequestMapping(value = "/{status}",method = RequestMethod.GET )
    public List<BatchJobExecution> findBatchesByStatus(String status) {
        return batchservice.findBatchesByStatus(status);
    }
}*/
