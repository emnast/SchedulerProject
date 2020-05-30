package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ListeExecJob;
import com.example.demo.entity.Task;
import com.example.demo.repository.ListeExecJobRepository;

@Service
@Transactional
@Primary
public class ListeExecJobService {

	@Autowired
	private ListeExecJobRepository SJIRepos;

	@Autowired
	private TaskService serv;
	
	@Autowired
	public ListeExecJobService(ListeExecJobRepository SJIRepos) {
		super();
		this.SJIRepos = SJIRepos;
	}

	public List<ListeExecJob> listAllListeExecJob() {
		return SJIRepos.findAll();
	}

	public ListeExecJob addListeExecJob(ListeExecJob SJI) {
		Task t = serv.getByreferenece(SJI.getTask().getId());
		t.addListe(SJI);
		/*if (t == null) {
			t = new Task();
			serv.addTask(t);
			System.out.println("ID:"+t.getId());
		}*/
		
		return SJIRepos.save(SJI);
		
	}

	public ListeExecJob getByreferenece(Integer idListe) {
		return SJIRepos.findById(idListe).isPresent() ? SJIRepos.findById(idListe).get() : null;

	}

	public void deleteListeExecJob(Integer idListe) {
		SJIRepos.deleteById(idListe);
	}

	public ListeExecJob updateListeExecJob(Integer idListe, ListeExecJob sji) {
		ListeExecJob sji01 = new ListeExecJob();
		sji01 = sji;
		sji01.setIdListe(idListe);
		return addListeExecJob(sji01);
	}

	public void deleteById(Integer idListe) {
		SJIRepos.deleteById(idListe);
	}

}
