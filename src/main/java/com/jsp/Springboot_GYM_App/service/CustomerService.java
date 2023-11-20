package com.jsp.Springboot_GYM_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Springboot_GYM_App.dao.CustomerDao;
import com.jsp.Springboot_GYM_App.dto.Customer;
import com.jsp.Springboot_GYM_App.exception.CustomerIdNotFound;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

@Service
public class CustomerService {

    private static ResponseStructure<Customer> responseStructure = new ResponseStructure<>();

    @Autowired
    private CustomerDao customerDao;

    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
        Customer dbCustomer = customerDao.saveCustomer(customer);
        if (dbCustomer != null) {
            responseStructure.setStatus(HttpStatus.CREATED.value());
            responseStructure.setMessage("Successfully inserted");
            responseStructure.setData(dbCustomer);
            return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int id, Customer customer) {
        Customer dbCustomer = customerDao.updateCustomer(id, customer);
        if (dbCustomer != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbCustomer);
            return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
        }
        throw new CustomerIdNotFound();
    }

    public List<Customer> fetchAll() {
        return customerDao.fetchAll();
    }

    public ResponseEntity<ResponseStructure<Customer>> fetchCustomer(int id) {
        Customer customer = customerDao.fetchCustomer(id);
        if (customer != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(customer);
            return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
        }
        throw new CustomerIdNotFound();
    }

    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
        Customer customer = customerDao.deleteCustomer(id);
        if (customer != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(customer);
            return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
        }
        throw new CustomerIdNotFound();
    }
}
