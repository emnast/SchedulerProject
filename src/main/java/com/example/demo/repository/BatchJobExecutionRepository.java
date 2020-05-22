/*package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BatchJobExecution;

@Repository
public interface BatchJobExecutionRepository extends JpaRepository<BatchJobExecution, Long> {

    //Récupérer tous les batchs par la date de création
    List<BatchJobExecution> findByCreateTime(Date createTime);
    //Récupérer tous les batchs par le status
    List<BatchJobExecution> findByStatus(String status);
}*/
