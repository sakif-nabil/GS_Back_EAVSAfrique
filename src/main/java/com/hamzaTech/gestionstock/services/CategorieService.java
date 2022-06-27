package com.hamzaTech.gestionstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


import org.springframework.transaction.annotation.Transactional;

import com.hamzaTech.gestionstock.dao.CategorieRepository;
import com.hamzaTech.gestionstock.entities.Categorie;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	 
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Categorie createCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}


	public Categorie getCategorieById(Long id) {
		
		return categorieRepository.findById(id).get();
	}


	public Categorie updateCategorie(Categorie categorie) {
		
		return categorieRepository.save(categorie);
	}


	public void deleteCategorie(Categorie categorie) {
		categorieRepository.delete(categorie);
		
	}


	public List<Categorie> getAllCategorie() {
		
		return categorieRepository.findAll();
	}

}
