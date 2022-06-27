package com.hamzaTech.gestionstock.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock implements Serializable {

	
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String libelle;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
	    
	   
	   

}
