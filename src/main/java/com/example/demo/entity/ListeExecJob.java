package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name ="ListeExecJob")
@JsonIgnoreProperties(
        value = {"dateCreation"},
        allowGetters = true
) 
public class ListeExecJob implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	
    @Column(name = "nom_job", length = 20,nullable = false)
    private String nom_job;
    
    @Column(name = "status", length = 100, nullable = false)
    private String status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation", length = 20,nullable = false)
    @CreatedDate
    private Date date_creation;
    
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Column(name = "date_execution", length = 100, nullable = false)
    private Date date_execution;
    
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Column(name = "fin_execution", length = 100, nullable = false)
    private Date fin_execution;
  
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_job() {
		return nom_job;
	}

	public void setNom_job(String nom_job) {
		this.nom_job = nom_job;
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

	public void setFin_execution(Date fin_exécution) {
		this.fin_execution = fin_exécution;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public ListeExecJob() {
		super();
		
	}
	

}
