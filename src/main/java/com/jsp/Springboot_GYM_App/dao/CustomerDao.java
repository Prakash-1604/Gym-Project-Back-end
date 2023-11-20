package com.jsp.Springboot_GYM_App.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springboot_GYM_App.dto.Customer;
import com.jsp.Springboot_GYM_App.repo.CustomerRepo;

@Repository
public class CustomerDao {
	
		
		@Autowired
		private CustomerRepo customerRepo;
		
		public Customer saveCustomer(Customer customer) {
			return customerRepo.save(customer);
		}

		    public Customer updateCustomer(int id, Customer customer) {
		        Optional<Customer> dbCustomer = customerRepo.findById(id);
		        if (dbCustomer.isPresent()) {
		            customer.setCustomerId(id);
		            return this.saveCustomer(customer);
		        }
		        return null;
		    }

		    public List<Customer> fetchAll() {
		        return customerRepo.findAll();
		    }

		    public Customer fetchCustomer(int id) {
		        Optional<Customer> customer = customerRepo.findById(id);
		        if (customer.isPresent()) {
		            return customer.get();
		        }
		        return null;
		    }

		    public Customer deleteCustomer(int id) {
		        Optional<Customer> customer = customerRepo.findById(id);
		        if (customer.isPresent()) {
		            customerRepo.deleteById(id);
		            return customer.get();
		        }
		        return null;
		    }
		}



