package com.hamzaTech.gestionstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


import org.springframework.transaction.annotation.Transactional;

import com.hamzaTech.gestionstock.dao.MaterielRepository;
import com.hamzaTech.gestionstock.entities.Materiel;


@Service
public class MaterielService {
	
	@Autowired
	private MaterielRepository materielRepository;
	
	 
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Materiel createMateriel(Materiel materiel) {
		return materielRepository.save(materiel);
	}


	public Materiel getMaterielById(Long id) {
		
		return materielRepository.findById(id).get();
	}


	public Materiel updateMateriel(Materiel materiel) {
		
		return materielRepository.save(materiel);
	}


	public void deleteMateriel(Materiel materiel) {
		materielRepository.delete(materiel);
		
	}


	public List<Materiel> getAllMateriel() {
		
		return materielRepository.findAll();
	}

}
