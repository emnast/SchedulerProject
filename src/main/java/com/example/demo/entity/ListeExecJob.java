package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;

@SuppressWarnings("serial")
@Entity
@Table(name ="liste")
@JsonIgnoreProperties(
        value = {"dateCreation"},
        allowGetters = true
) 
public class ListeExecJob implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_liste")
    private int idListe;
	
    
    @Column(name = "status")
    private String status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation")
    @CreatedDate
    private Date date_creation;
    
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @JoinColumn(name = "date_execution")
    private Date date_execution;
    
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Column(name = "fin_execution")
    private Date fin_execution;
    
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Column(name = "next_execution")
    private Date next_execution;
    
   
    @ManyToOne
    @JoinColumn(name = "id_task")
    private Task task;
  
    
    public int getIdListe() {
  		return idListe;
  	}

  	public void setIdListe(int idListe) {
  		this.idListe = idListe;
  	}
  	

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_execution() {
		return date_execution;
	}

	public void setDate_execution(Date date_execution) {
		this.date_execution = date_execution;
	}

	public Date getFin_execution() {
		return fin_execution;
	}

	public void setFin_execution(Date fin_execution) {
		this.fin_execution = fin_execution;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Task getTask() {
		return task;
		}

		public void setTask(Task task) {
		this.task = task;
		}


	public ListeExecJob() {
	
		
	}

	public ListeExecJob(int idListe, String status, Date date_creation, Date date_execution, Date fin_execution,
			Date next_execution) {
		super();
		this.idListe = idListe;
		this.status = status;
		this.date_creation = date_creation;
		this.date_execution = date_execution;
		this.fin_execution = fin_execution;
		this.next_execution = next_execution;
	}
	

}
