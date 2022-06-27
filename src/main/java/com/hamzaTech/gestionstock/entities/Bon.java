package com.hamzaTech.gestionstock.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
public class Bon implements Serializable {

	
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    
	   
	    @ManyToOne
	    private Client client;
       
	    @ManyToMany(targetEntity = Materiel.class,fetch = FetchType.LAZY)
	    @JoinTable(
	      name = "bon_materiel", 
	      joinColumns = @JoinColumn(name = "bon_id"), 
	      inverseJoinColumns = @JoinColumn(name = "matriel_id"))
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private List<Materiel> listMateriel ;
        
	    
	   private  LocalDate dateDePret;
	   
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public List<Materiel> getListMateriel() {
			return listMateriel;
		}

		public void setListMateriel(List<Materiel> listMateriel) {
			this.listMateriel = listMateriel;
		}

		public LocalDate getDateDePret() {
			return dateDePret;
		}

		public void setDateDePret(LocalDate dateDePret) {
			this.dateDePret = dateDePret;
		}
		
	    
	    
	    
	    
	   

}
