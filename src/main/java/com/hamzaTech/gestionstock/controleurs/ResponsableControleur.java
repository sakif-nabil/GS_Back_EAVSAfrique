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

import com.hamzaTech.gestionstock.entities.Responsable;
import com.hamzaTech.gestionstock.services.ResponsableService;

@CrossOrigin("*")
@RestController
public class ResponsableControleur {

	@Autowired
	private ResponsableService responsableService;

	
	@GetMapping("/responsable/{id}")
	
	public ResponseEntity<Responsable> getAnnonceById(@PathVariable("id") Long id) throws Exception {

		Responsable responsable = responsableService.getResponsableById(id);



		return new ResponseEntity<Responsable>(responsable, HttpStatus.OK);

	}
	
	

	 @PostMapping("/responsable")
	 public ResponseEntity<Long> createResponsable(@RequestBody Responsable responsable){
	        
	        
		 Responsable newresponsable= responsableService.createResponsable(responsable);
		 
			return new ResponseEntity<Long>(newresponsable.getId(), HttpStatus.CREATED);
	   }
	 
	 
	 @PutMapping("/responsable")
	 public  ResponseEntity<Responsable> updateResponsable(@RequestBody Responsable responsable){
	        
		 Responsable newresponsable= responsableService.updateResponsable(responsable);
		 
			return new ResponseEntity<Responsable>(newresponsable, HttpStatus.OK);
	   }
	 
	 
	 @DeleteMapping("/responsable")
	 public  ResponseEntity<Void> deleteResponsable(@RequestBody Responsable responsable){
	        
		 responsableService.deleteResponsable(responsable);
		 
		 return new ResponseEntity<Void>(HttpStatus.OK);
		 
	   }
	 
	@GetMapping("/responsablepaginatedList")		
	public ResponseEntity<List<Responsable>>  paginatedListResponsable() throws Exception {
			 
			 List<Responsable> list=responsableService.getAllResponsable();
			 
			 return new ResponseEntity<List<Responsable>>(list, HttpStatus.OK);
			 
		 }
	 
	 

	
	
}
