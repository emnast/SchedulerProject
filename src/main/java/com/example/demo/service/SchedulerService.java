package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Scheduler;
import com.example.demo.repository.SchedulerRepository;

@Service
@Transactional
@Primary
public class SchedulerService {

	@Autowired
    private SchedulerRepository SchRepos;
	
	@Autowired
	public SchedulerService(SchedulerRepository SchRepos) {
		super();
		this.SchRepos = SchRepos;
	}
	 public List<Scheduler> listAllScheduler(){
	        return SchRepos.findAll();
	    }
	    public Scheduler addScheduler(Scheduler sch){
	       return SchRepos.save(sch);
	    }
	    public Scheduler getByreferenece(int id){
	        return SchRepos.findById(id).get();
	    }
	    public void deleteScheduler(int id){
	    	SchRepos.deleteById(id);
	    }

		
		public Scheduler updateScheduler(Integer id , Scheduler sch){
		Scheduler sch01 = new Scheduler();
		sch01 = sch;
		sch01.setId(id);
		return addScheduler(sch01);
	 }

	public void deleteById(Integer id) {
		SchRepos.deleteById(id);
	}
}
