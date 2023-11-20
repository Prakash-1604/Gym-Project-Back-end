package com.jsp.Springboot_GYM_App.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private String addressArea;
	private String addressCity;
	private int addressPincode;
	private String addressState;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressArea() {
		return addressArea;
	}
	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public int getAddressPincode() {
		return addressPincode;
	}
	public void setAddressPincode(int addressPincode) {
		this.addressPincode = addressPincode;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	
	
}
