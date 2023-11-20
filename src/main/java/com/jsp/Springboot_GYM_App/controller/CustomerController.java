package com.jsp.Springboot_GYM_App.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Springboot_GYM_App.dto.Customer;
import com.jsp.Springboot_GYM_App.service.CustomerService;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomer")
    @ApiOperation(value = "save customer", notes = "API is used for saving customer")
    @ApiResponses({ @ApiResponse(code = 201, message = "Customer saved Successfully"),
            @ApiResponse(code = 400, message = "Fields cannot be null or blank") })
    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    @ApiOperation(value = "update customer", notes = "API is used for updating customer")
    @ApiResponses({ @ApiResponse(code = 201, message = "Customer updated Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer, @RequestParam int id) {
        return customerService.updateCustomer(id, customer);
    }

    @GetMapping("/fetchAllCustomers")
    @ApiOperation(value = "fetch All customers", notes = "API is used for fetching all customers")
    @ApiResponses({ @ApiResponse(code = 302, message = "All customers fetched Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public List<Customer> fetchAll() {
        return customerService.fetchAll();
    }

    @GetMapping("/fetchCustomer")
    @ApiOperation(value = "fetch customer", notes = "API is used for fetching customer")
    @ApiResponses({ @ApiResponse(code = 302, message = "Customer saved Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Customer>> fetchCustomer(@RequestParam int id) {
        return customerService.fetchCustomer(id);
    }

    @DeleteMapping("/deleteCustomer")
    @ApiOperation(value = "delete customer", notes = "API is used for deleting customer")
    @ApiResponses({ @ApiResponse(code = 201, message = "Customer deleted Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int id) {
        return customerService.deleteCustomer(id);
    }
}
