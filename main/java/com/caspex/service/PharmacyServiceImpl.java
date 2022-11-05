package com.caspex.service;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.caspex.repository.PharmacyDao;

import com.caspex.exception.PharmacyException;
import com.caspex.model.Pharmacy;

@Service
public class PharmacyServiceImpl implements PharmacyService {
	
//	@Autowired
//	private PharmacyServiceImpl pharmacy;
	
	@Autowired
	private PharmacyDao pharmacyDao;

	@Override
	public Pharmacy savePharmacy(Pharmacy pharmacy) {    //Service interface
		
		return  pharmacyDao.save(pharmacy);            //JPArepo by DAO class
	}

	@Override
	public Pharmacy getPharmacyByMediId(Integer mediId) {
		// TODO Auto-generated method stub
		return pharmacyDao.findById(mediId).orElseThrow(()->new PharmacyException("No medicine found"));
	}

	@Override
	public List<Pharmacy> getAllPharmacys() {
		
		
		List<Pharmacy> pharmacys = pharmacyDao.findAll();
		
		if(pharmacys.size()>0)
			return pharmacys;
		
		else 
			throw new PharmacyException("No medicine found");
	}

	@Override
	public Pharmacy deletePharmacyByMediId(Integer mediId) {
		
		Pharmacy existingPharmacy = pharmacyDao.findById(mediId).orElseThrow(()-> new PharmacyException("No medicine found"));
		
		pharmacyDao.delete(existingPharmacy);
		return existingPharmacy;
	}

	@Override
	public Pharmacy updatePharmacy(Pharmacy pharmacy) {
		
		Optional<Pharmacy> opt= pharmacyDao.findById(pharmacy.getMediId());
		
		if(opt.isPresent()) {
			Pharmacy existingPharmacy = opt.get();
			
			return pharmacyDao.save(pharmacy);
		}else
			throw new PharmacyException("Invalid medicine details");
	}

	//@Override
//	public List<Pharmacy> getPharmacyDetailsByName(String name) {
//		List<Pharmacy> pharmacys = pharmacyDao.findByName(name);
//		
//		if(pharmacys.size()>0)
//			return pharmacys;
//		
//		else 
//			throw new PharmacyException("No medicine found with this name"+name);
//	}

	@Override
	public Pharmacy updatePharmacyMediId(Pharmacy pharmacy) {
        
        return pharmacyDao.save(pharmacy);
		
	}

	@Override
	public List<Pharmacy> getPharmacyDetailsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
