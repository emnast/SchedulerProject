package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Scheduler;

public interface SchedulerRepository extends JpaRepository<Scheduler, Integer>{

}
