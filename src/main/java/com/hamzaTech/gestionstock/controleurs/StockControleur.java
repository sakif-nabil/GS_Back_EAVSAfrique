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

import com.hamzaTech.gestionstock.entities.Stock;
import com.hamzaTech.gestionstock.services.StockService;

@CrossOrigin("*")
@RestController
public class StockControleur {

	@Autowired
	private StockService stockService;

	
	@GetMapping("/stock/{id}")
	
	public ResponseEntity<Stock> getAnnonceById(@PathVariable("id") Long id) throws Exception {

		Stock stock = stockService.getStockById(id);



		return new ResponseEntity<Stock>(stock, HttpStatus.OK);

	}
	
	

	 @PostMapping("/stock")
	 public ResponseEntity<Long> createStock(@RequestBody Stock stock){
	        
	        
		 Stock newstock= stockService.createStock(stock);
		 
			return new ResponseEntity<Long>(newstock.getId(), HttpStatus.CREATED);
	   }
	 
	 
	 @PutMapping("/stock")
	 public  ResponseEntity<Stock> updateStock(@RequestBody Stock stock){
	        
		 Stock newstock= stockService.updateStock(stock);
		 
			return new ResponseEntity<Stock>(newstock, HttpStatus.OK);
	   }
	 
	 
	 @DeleteMapping("/stock")
	 public  ResponseEntity<Void> deleteStock(@RequestBody Stock stock){
	        
		 stockService.deleteStock(stock);
		 
		 return new ResponseEntity<Void>(HttpStatus.OK);
		 
	   }
	 
	@GetMapping("/stockpaginatedList")		
	public ResponseEntity<List<Stock>>  paginatedListStock() throws Exception {
			 
			 List<Stock> list=stockService.getAllStock();
			 
			 return new ResponseEntity<List<Stock>>(list, HttpStatus.OK);
			 
		 }
	 
	 

	
	
}
