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

import com.hamzaTech.gestionstock.entities.Client;
import com.hamzaTech.gestionstock.services.ClientService;

@CrossOrigin("*")
@RestController
public class ClientControleur {

	@Autowired
	private ClientService clientService;

	
	@GetMapping("/client/{id}")
	
	public ResponseEntity<Client> getAnnonceById(@PathVariable("id") Long id) throws Exception {

		Client client = clientService.getClientById(id);



		return new ResponseEntity<Client>(client, HttpStatus.OK);

	}
	
	

	 @PostMapping("/client")
	 public ResponseEntity<Long> createClient(@RequestBody Client client){
	        
	        
		 Client newclient= clientService.createClient(client);
		 
			return new ResponseEntity<Long>(newclient.getId(), HttpStatus.CREATED);
	   }
	 
	 
	 @PutMapping("/client")
	 public  ResponseEntity<Client> updateClient(@RequestBody Client client){
	        
		 Client newclient= clientService.updateClient(client);
		 
			return new ResponseEntity<Client>(newclient, HttpStatus.OK);
	   }
	 
	 
	 @DeleteMapping("/client")
	 public  ResponseEntity<Void> deleteClient(@RequestBody Client client){
	        
		 clientService.deleteClient(client);
		 
		 return new ResponseEntity<Void>(HttpStatus.OK);
		 
	   }
	 
	@GetMapping("/clientpaginatedList")		
	public ResponseEntity<List<Client>>  paginatedListClient() throws Exception {
			 
			 List<Client> list=clientService.getAllClient();
			 
			 return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
			 
		 }
	 
	 

	
	
}
