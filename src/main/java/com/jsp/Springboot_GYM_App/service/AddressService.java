package com.jsp.Springboot_GYM_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Springboot_GYM_App.dao.AddressDao;
import com.jsp.Springboot_GYM_App.dto.Address;
import com.jsp.Springboot_GYM_App.exception.AddressIdNotFound;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

@Service
public class AddressService {

    private static ResponseStructure<Address> responseStructure = new ResponseStructure<>();

    @Autowired
    private AddressDao addressDao;

    public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
        Address dbAddress = addressDao.saveAddress(address);
        if (dbAddress != null) {
            responseStructure.setStatus(HttpStatus.CREATED.value());
            responseStructure.setMessage("Successfully inserted");
            responseStructure.setData(dbAddress);
            return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
        Address dbAddress = addressDao.updateAddress(id, address);
        if (dbAddress != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbAddress);
            return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
        }
        throw new AddressIdNotFound();
    }

    public List<Address> fetchAll() {
        return addressDao.fetchAll();
    }

    public ResponseEntity<ResponseStructure<Address>> fetchAddress(int id) {
        Address address = addressDao.fetchAddress(id);
        if (address != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(address);
            return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
        }
        throw new AddressIdNotFound();
    }

    public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
        Address address = addressDao.deleteAddress(id);
        if (address != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(address);
            return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
        }
        throw new AddressIdNotFound();
    }
}
