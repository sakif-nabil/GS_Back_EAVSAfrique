package com.hamzaTech.gestionstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


import org.springframework.transaction.annotation.Transactional;

import com.hamzaTech.gestionstock.dao.BonRepository;

import com.hamzaTech.gestionstock.entities.Bon;


@Service
public class BonService {
	
	@Autowired
	private BonRepository bonRepository;
	
	 
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Bon createBon(Bon bon) {
		return bonRepository.save(bon);
	}


	public Bon getBonById(Long id) {
		
		return bonRepository.findById(id).get();
	}


	public Bon updateBon(Bon bon) {
		
		return bonRepository.save(bon);
	}


	public void deleteBon(Bon bon) {
		bonRepository.delete(bon);
		
	}


	public List<Bon> getAllBon() {
		
		return bonRepository.findAll();
	}

}
