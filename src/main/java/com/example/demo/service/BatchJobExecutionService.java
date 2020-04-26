package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BatchJobExecution;
import com.example.demo.repository.BatchJobExecutionRepository;

@Service
public class BatchJobExecutionService {

    @Autowired
    BatchJobExecutionRepository batchJobExecutionRepository;

    public List<BatchJobExecution> findAllBatches() {
        return batchJobExecutionRepository.findAll();
    }

    public List<BatchJobExecution> findBatchesByCreateTime(Date createTime) {
        return batchJobExecutionRepository.findByCreateTime(createTime);
    }

    public List<BatchJobExecution> findBatchesByStatus(String status) {
        return batchJobExecutionRepository.findByStatus(status);
    }
}


