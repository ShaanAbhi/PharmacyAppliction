package com.caspex.service;

import java.util.List;

import com.caspex.model.Pharmacy;

public interface PharmacyService {
		
	public Pharmacy savePharmacy(Pharmacy pharmacy);
	
	public Pharmacy getPharmacyByMediId(Integer mediId); 
	
	public List<Pharmacy> getAllPharmacys();
	
	public Pharmacy deletePharmacyByMediId(Integer mediId);
	
	public Pharmacy updatePharmacy(Pharmacy pharmacy);
	
	
	public List<Pharmacy> getPharmacyDetailsByName(String name);

	public Pharmacy updatePharmacyMediId(Pharmacy pharmacy);

	
}
