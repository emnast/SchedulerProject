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
	@Column(name = "id")
    private int id;
	
    
    @Column(name = "status")
    private String status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd 'T' HH:mm")
    @Column(name = "date_creation")
    @CreatedDate
    private Date date_creation;
    
    @JsonFormat(pattern="yyyy-MM-dd 'T' HH:mm")
    @JoinColumn(name = "date_execution")
    private Date date_execution;
    
    @JsonFormat(pattern="yyyy-MM-dd 'T' HH:mm")
    @Column(name = "fin_execution")
    private Date fin_execution;
    
    @JsonFormat(pattern="yyyy-MM-dd 'T' HH:mm")
    @Column(name = "next_execution")
    private Date next_execution;
    
    @Column(name = "logfile")
    private String logfile;
   // private Duration duration;
    
   
    public String getLogfile() {
		return logfile;
	}

	public void setLogfile(String logfile) {
		this.logfile = logfile;
	}

		@ManyToOne
    @JoinColumn(name = "id_task")
    @JsonIgnore
    private Task task;
    
	@OneToOne(mappedBy = "liste")
	@JoinColumn(name = "liste_id")
    private Fichier f;
  
	public Fichier getF() {
		return f;
	}

	public void setF(Fichier f) {
		this.f = f;
	}
/*	public void addF(Fichier f) {
		getF().add((Fichier) f);
		((Fichier) f).setListe(this);
	}*/
    
    public int getIdListe() {
  		return id;
  	}

  	public void setIdListe(int idListe) {
  		this.id = idListe;
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

	/*public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration= duration;
	}*/
	

	public Task getTask() {
		return task;
		}

		public void setTask(Task task) {
		this.task = task;
		}


	public ListeExecJob() {
		
	}

	public ListeExecJob(int idListe, String status, Date date_creation, Date date_execution, Date fin_execution,
			Date next_execution, String logfile) {
		super();
		this.id = idListe;
		this.status = status;
		this.date_creation = date_creation;
		this.date_execution = date_execution;
		this.fin_execution = fin_execution;
		this.next_execution = next_execution;
		//this.duration = duration;
		this.logfile=logfile;
	}

}
