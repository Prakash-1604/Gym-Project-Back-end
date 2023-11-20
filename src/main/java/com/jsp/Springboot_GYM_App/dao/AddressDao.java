package com.jsp.Springboot_GYM_App.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springboot_GYM_App.dto.Address;
import com.jsp.Springboot_GYM_App.repo.AddressRepo;

@Repository
public class AddressDao {
	
		
		@Autowired
		private AddressRepo addressRepo;
		
		public Address saveAddress(Address address) {
			return addressRepo.save(address);
		}
		public Address updateAddress(int id, Address address) {
		    Optional<Address> dbAddress = addressRepo.findById(id);
		    if (dbAddress.isPresent()) {
		        address.setAddressId(id);
		        return this.saveAddress(address);
		    }
		    return null;
		}

		public List<Address> fetchAll() {
		    return addressRepo.findAll();
		}

		public Address fetchAddress(int id) {
		    Optional<Address> address = addressRepo.findById(id);
		    if (address.isPresent()) {
		        return address.get();
		    }
		    return null;
		}

		public Address deleteAddress(int id) {
		    Optional<Address> address = addressRepo.findById(id);
		    if (address.isPresent()) {
		        addressRepo.deleteById(id);
		        return address.get();
		    }
		    return null;
		
		}
}
