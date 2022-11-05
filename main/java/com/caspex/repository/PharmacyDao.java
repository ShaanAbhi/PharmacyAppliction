package com.caspex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.caspex.model.Pharmacy;

@Repository
public interface PharmacyDao extends JpaRepository<Pharmacy, Integer>{
	
	
	/*
	 * public List<Pharmacy> findByName(String name);
	 * 
	 * public List<Pharmacy> findByNameAndPrices(String name, int prices);
	 * 
	 * public List<Pharmacy> findByNameOrPrices(String name, int prices);
	 */

}
