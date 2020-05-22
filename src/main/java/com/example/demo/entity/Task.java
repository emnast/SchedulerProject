package com.example.demo.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name ="task")
public class Task implements Serializable{
	
	//@GeneratedValue(generator = "task_id_seq")
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "cronExpression", length = 20)
	private String cronExpression;
	
    @Column(name = "nom_job", length = 20,nullable = false)
    private String nom_job;
    
    @Column(name = "type_commande", length = 20,nullable = false)
    private String type_commande;
    
    @Column(name = "description", length = 100, nullable = false)
    private String description;
    
    @Column(name = "script", length = 100, nullable = false)
    private String script;
    
   @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Column(name = "date_execution")
    private Date date_execution;
    
   @Column(name = "active")
   private boolean  active;
   
   @JsonBackReference
   @ManyToOne
   @JoinColumn(name="id_liste")
   private ListeExecJob liste;
   
    
    public ListeExecJob getListe() {
	return liste;
}
public void setListe(ListeExecJob liste) {
	this.liste = liste;
}


	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom_job() {
        return nom_job;
    }
    public void setNom_job(String nom_job) {
        this.nom_job = nom_job;
    }
    public String getType_commande() {
        return type_commande;
    }
    public void setType_commande(String type_commande) {
        this.type_commande = type_commande;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getScript() {
        return script;
    }
    public void setScript(String script) {
        this.script = script;
    }
    public Date getDate_execution() {
        return date_execution;
    }
    public void setDate_execution(Date date_execution) {
        this.date_execution = date_execution;
    }
  
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean  active) {
        this.active = active;
    }
	  
	
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
    
    public Task() {
    	
    }
    public Task(Integer id, String nom_job, String type_commande, String description, String script,
    		Date date_execution, String cronExpression, boolean  active) {
    	super();
    	this.id=id;
        this.nom_job = nom_job;
        this.type_commande = type_commande;
        this.description = description;
        this.script = script;
       this.date_execution = date_execution;
        this.cronExpression = cronExpression;
        this.active=active ;
       
    }
  
}


