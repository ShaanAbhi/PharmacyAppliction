package com.caspex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pharmacy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int mediId;
	
	@Column
	private String medicineName;
	
	@Column
	private int Price;

	public int getMediId() {
		return mediId;
	}

	public void setMediId(int mediId) {
		this.mediId = mediId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}
	
	

}
