package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ListeExecJob;
import com.example.demo.repository.ListeExecJobRepository;



@Service
@Transactional
@Primary
public class ListeExecJobService {
	
	@Autowired
    private ListeExecJobRepository SJIRepos;
	
	@Autowired
	public ListeExecJobService(ListeExecJobRepository SJIRepos) {
		super();
		this.SJIRepos = SJIRepos;
	}
	
	 public List<ListeExecJob> listAllListeExecJob(){
	        return SJIRepos.findAll();
	    }
	    public ListeExecJob addListeExecJob(ListeExecJob SJI){
	       return SJIRepos.save(SJI);
	    }
	    public ListeExecJob getByreferenece(int id){
	        return SJIRepos.findById(id).get();
	    }
	    public void deleteListeExecJob(int id){
	    	SJIRepos.deleteById(id);
	    }

		
		public ListeExecJob updateListeExecJob(Integer id , ListeExecJob sji){
		ListeExecJob sji01 = new ListeExecJob();
		sji01 = sji;
		sji01.setId(id);
		return addListeExecJob(sji01);
	 }

	public void deleteById(Integer id) {
		SJIRepos.deleteById(id);
	}

}
