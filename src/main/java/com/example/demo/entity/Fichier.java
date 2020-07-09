package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "fichier")
public class Fichier implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fichierLog", length = 1000)
	private String fichierLog;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference("liste")
    private ListeExecJob liste;


	public Integer getIdFichier() {
		return id;
	}
	
	public ListeExecJob getListe() {
		return liste;
	}

	public void setListe(ListeExecJob liste) {
		this.liste = liste;
	}

	public void setIdFichier(Integer idFichier) {
		this.id = idFichier;
	}
	public Fichier(Integer idFichier, String fichier) {
		super();
		this.id = idFichier;
		this.fichierLog = fichier;
	}
	public String getFichierLog() {
		return fichierLog;
	}


	public void setFichierLog(String fichierLog) {
		this.fichierLog = fichierLog;
	}


	public Fichier() {
		super();
	}
}
