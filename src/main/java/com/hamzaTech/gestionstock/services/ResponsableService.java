package com.hamzaTech.gestionstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


import org.springframework.transaction.annotation.Transactional;

import com.hamzaTech.gestionstock.dao.ResponsableRepository;
import com.hamzaTech.gestionstock.entities.Responsable;

@Service
public class ResponsableService {
	
	@Autowired
	private ResponsableRepository responsableRepository;
	
	 
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public Responsable createResponsable(Responsable responsable) {
		return responsableRepository.save(responsable);
	}


	public Responsable getResponsableById(Long id) {
		
		return responsableRepository.findById(id).get();
	}


	public Responsable updateResponsable(Responsable responsable) {
		
		return responsableRepository.save(responsable);
	}


	public void deleteResponsable(Responsable responsable) {
		responsableRepository.delete(responsable);
		
	}


	public List<Responsable> getAllResponsable() {
		
		return responsableRepository.findAll();
	}

}
