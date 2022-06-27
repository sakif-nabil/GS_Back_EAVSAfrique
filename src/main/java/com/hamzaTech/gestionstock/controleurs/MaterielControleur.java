package com.hamzaTech.gestionstock.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamzaTech.gestionstock.entities.Materiel;
import com.hamzaTech.gestionstock.services.MaterielService;

@CrossOrigin("*")
@RestController
public class MaterielControleur {

	@Autowired
	private MaterielService materielService;

	
	@GetMapping("/materiel/{id}")
	
	public ResponseEntity<Materiel> getAnnonceById(@PathVariable("id") Long id) throws Exception {

		Materiel materiel = materielService.getMaterielById(id);



		return new ResponseEntity<Materiel>(materiel, HttpStatus.OK);

	}
	
	

	 @PostMapping("/materiel")
	 public ResponseEntity<Long> createMateriel(@RequestBody Materiel materiel){
	        
	        
		 Materiel newmateriel= materielService.createMateriel(materiel);
		 
			return new ResponseEntity<Long>(newmateriel.getId(), HttpStatus.CREATED);
	   }
	 
	 
	 @PutMapping("/materiel")
	 public  ResponseEntity<Materiel> updateMateriel(@RequestBody Materiel materiel){
	        
		 Materiel newmateriel= materielService.updateMateriel(materiel);
		 
			return new ResponseEntity<Materiel>(newmateriel, HttpStatus.OK);
	   }
	 
	 
	 @DeleteMapping("/materiel/delete")
	 public  ResponseEntity<Void> deleteMateriel(@RequestBody Materiel materiel){
	        
		 materielService.deleteMateriel(materiel);
		 
		 return new ResponseEntity<Void>(HttpStatus.OK);
		 
	   }
	 
	@GetMapping("/materielpaginatedList")		
	public ResponseEntity<List<Materiel>>  paginatedListMateriel() throws Exception {
			 
			 List<Materiel> list=materielService.getAllMateriel();
			 
			 return new ResponseEntity<List<Materiel>>(list, HttpStatus.OK);
			 
		 }
	 
	 

	
	
}
