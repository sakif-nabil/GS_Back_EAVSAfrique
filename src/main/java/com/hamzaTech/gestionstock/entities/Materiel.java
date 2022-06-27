package com.hamzaTech.gestionstock.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Materiel implements Serializable {

	
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String libelle;
	    private String unite;
	    private int numeroSerie ;
	    private double prix;
	    
	    private boolean estEmprunter;
	    
	   
	    @ManyToOne
	    private Categorie categorie;
	    
//	    @ManyToMany(mappedBy = "listMateriel")
//	    private List<Bon> listBon;


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


		public String getUnite() {
			return unite;
		}


		public void setUnite(String unite) {
			this.unite = unite;
		}


		public int getNumeroSerie() {
			return numeroSerie;
		}


		public void setNumeroSerie(int numeroSerie) {
			this.numeroSerie = numeroSerie;
		}


		public double getPrix() {
			return prix;
		}


		public void setPrix(double prix) {
			this.prix = prix;
		}


		public Categorie getCategorie() {
			return categorie;
		}


		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}


		public boolean isEstEmprunter() {
			return estEmprunter;
		}


		public void setEstEmprunter(boolean estEmprunter) {
			this.estEmprunter = estEmprunter;
		}


//		public List<Bon> getListBon() {
//			return listBon;
//		}
//
//
//		public void setListBon(List<Bon> listBon) {
//			this.listBon = listBon;
//		}


		


		
	    
	    
	    
	    
	   

}
