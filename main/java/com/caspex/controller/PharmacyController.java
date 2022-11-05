package com.caspex.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.security.RolesAllowed;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.caspex.model.Pharmacy;
import com.caspex.exception.PharmacyException;
import com.caspex.repository.PharmacyDao;
import com.caspex.service.PharmacyService;

@RestController
public class PharmacyController {
	
	@Autowired
	private PharmacyService pharmacyService; ///service
	
	
	@Autowired
	private PharmacyDao pharmacyDao; //repository
	
	
	
	
	@PostMapping("/pharmacys")
	@RolesAllowed({"abhi-admin","abhi-user"})
	public ResponseEntity<Pharmacy> savePharmacyHandler(@RequestBody Pharmacy pharmacy){
		
		Pharmacy savedPharmacy= pharmacyService.savePharmacy(pharmacy);
	
		
		return new ResponseEntity<Pharmacy>(savedPharmacy,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/pharmacys/{mediId}")
	@RolesAllowed({"abhi-admin","abhi-user"})
	public Pharmacy getPharmacytByMediId(@PathVariable("mediId") Integer mediId) {
		
		return pharmacyService.getPharmacyByMediId(mediId);
		
	}
	
	@GetMapping("/pharmacys")
	@RolesAllowed({"abhi-admin","abhi-user"})
	public ResponseEntity<List<Pharmacy>> getAllPharmacysDetails(){
		
		
		List<Pharmacy> pharmacys= pharmacyService.getAllPharmacys();
		
		
		return new ResponseEntity<List<Pharmacy>>(pharmacys, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/pharmacys/{mediId}")
	@RolesAllowed("abhi-admin")
	public Pharmacy deletePharmacyHandler(@PathVariable("mediId") Integer mediId){
		
		return pharmacyService.deletePharmacyByMediId(mediId);
		
		
	}
	
	
	@PutMapping("/pharmacys")
	@RolesAllowed({"abhi-admin","abhi-user"})
	public ResponseEntity<Pharmacy> updateStudentHandler(@RequestBody Pharmacy pharmacy){
		
		Pharmacy updatedPharmacy= pharmacyService.updatePharmacy(pharmacy);
		
		return new ResponseEntity<Pharmacy>(updatedPharmacy,HttpStatus.ACCEPTED);
		
		
	}
	@PutMapping("/pharmacys/{mediId}")
	@RolesAllowed({"abhi-admin","abhi-user"})
	public ResponseEntity<Pharmacy> updatePharmacyMediId(@RequestBody Pharmacy pharmacy, @PathVariable("mediId") Integer mediId){

	        try {
	            Pharmacy existUser = pharmacyService.getPharmacyByMediId(mediId);
	            pharmacy.setMediId(mediId);            
	            Pharmacy updatedPharmacy= pharmacyService.updatePharmacyMediId(pharmacy);
	            return new ResponseEntity<Pharmacy>(updatedPharmacy,HttpStatus.ACCEPTED);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	
		
	}
	

}
