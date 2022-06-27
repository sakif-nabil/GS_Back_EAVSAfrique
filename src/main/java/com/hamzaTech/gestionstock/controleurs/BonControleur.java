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

import com.hamzaTech.gestionstock.entities.Bon;
import com.hamzaTech.gestionstock.entities.Bon;
import com.hamzaTech.gestionstock.services.BonService;
import com.hamzaTech.gestionstock.services.BonService;
import com.hamzaTech.gestionstock.services.GenerateBonWord;
@CrossOrigin("*")
@RestController
public class BonControleur {

	@Autowired
	private BonService bonService;
	
	@Autowired
	private GenerateBonWord generateBonWord;

	
	@GetMapping("/bon/{id}")
	
	public ResponseEntity<Bon> getBonById(@PathVariable("id") Long id) throws Exception {

		Bon bon = bonService.getBonById(id);



		return new ResponseEntity<Bon>(bon, HttpStatus.OK);

	}
	
	

	 @PostMapping("/bon")
	 public ResponseEntity<Long> createBon(@RequestBody Bon bon){
	        
	        
		 Bon newbon= bonService.createBon(bon);
		 
			return new ResponseEntity<Long>(newbon.getId(), HttpStatus.CREATED);
	   }
	 
	 
	 @PutMapping("/bon")
	 public  ResponseEntity<Bon> updateBon(@RequestBody Bon bon){
	        
		 Bon newbon= bonService.updateBon(bon);
		 
			return new ResponseEntity<Bon>(newbon, HttpStatus.OK);
	   }
	 
	 
	 @DeleteMapping("/bon")
	 public  ResponseEntity<Void> deleteBon(@RequestBody Bon bon){
	        
		 bonService.deleteBon(bon);
		 
		 return new ResponseEntity<Void>(HttpStatus.OK);
		 
	   }
	 
	@GetMapping("/bonpaginatedList")		
	public ResponseEntity<List<Bon>>  paginatedListBon() throws Exception {
			 
			 List<Bon> list=bonService.getAllBon();
			 
			 return new ResponseEntity<List<Bon>>(list, HttpStatus.OK);
			 
		 }
	 
	 
@GetMapping("/imprimerBon/{id}")
	
	public ResponseEntity<Bon> imprimerBonById(@PathVariable("id") Long id) throws Exception {

		Bon bon = bonService.getBonById(id);
		generateBonWord.generatePdf(bon);
         

		return new ResponseEntity<Bon>(bon, HttpStatus.OK);

	}
	
	
}
