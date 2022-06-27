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

import com.hamzaTech.gestionstock.entities.Categorie;
import com.hamzaTech.gestionstock.services.CategorieService;

@CrossOrigin("*")
@RestController
public class CategorieControleur {

	@Autowired
	private CategorieService categorieService;

	
	@GetMapping("/categorie/{id}")
	
	public ResponseEntity<Categorie> getAnnonceById(@PathVariable("id") Long id) throws Exception {

		Categorie categorie = categorieService.getCategorieById(id);



		return new ResponseEntity<Categorie>(categorie, HttpStatus.OK);

	}
	
	

	 @PostMapping("/categorie")
	 public ResponseEntity<Long> createCategorie(@RequestBody Categorie categorie){
	        
	        
		 Categorie newcategorie= categorieService.createCategorie(categorie);
		 
			return new ResponseEntity<Long>(newcategorie.getId(), HttpStatus.CREATED);
	   }
	 
	 
	 @PutMapping("/categorie")
	 public  ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorie){
	        
		 Categorie newcategorie= categorieService.updateCategorie(categorie);
		 
			return new ResponseEntity<Categorie>(newcategorie, HttpStatus.OK);
	   }
	 
	 
	 @DeleteMapping("/categorie")
	 public  ResponseEntity<Void> deleteCategorie(@RequestBody Categorie categorie){
	        
		 categorieService.deleteCategorie(categorie);
		 
		 return new ResponseEntity<Void>(HttpStatus.OK);
		 
	   }
	 
	@GetMapping("/categoriepaginatedList")		
	public ResponseEntity<List<Categorie>>  paginatedListCategorie() throws Exception {
			 
			 List<Categorie> list=categorieService.getAllCategorie();
			 
			 return new ResponseEntity<List<Categorie>>(list, HttpStatus.OK);
			 
		 }
	 
	 

	
	
}
