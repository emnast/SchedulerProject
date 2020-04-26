package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name ="Scheduler")
public class Scheduler implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	
    @Column(name = "nom_job", length = 20,nullable = false)
    private String nom_job;
    
    @Column(name = "date_exécution", length = 20,nullable = false)
    private Date date_exécution;
    
    @Column(name = "temps_exécution", length = 100, nullable = false)
    private String temps_exécution;
    
  
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
    public Date getDate_exécution() {
        return date_exécution;
    }
    public void setDate_exécution(Date date_exécution) {
        this.date_exécution = date_exécution;
    }
    public String getTemps_exécution() {
        return temps_exécution;
    }
    public void setTemps_exécution(String temps_exécution) {
        this.temps_exécution = temps_exécution;
    }
    public Scheduler() {
    }
    public Scheduler(String nom_job, Date date_exécution, String temps_exécution ) {
        this.nom_job = nom_job;
        this.date_exécution = date_exécution;
        this.temps_exécution = temps_exécution;
    }

}
