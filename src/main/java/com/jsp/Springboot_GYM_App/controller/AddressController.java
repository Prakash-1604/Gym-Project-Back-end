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

import com.jsp.Springboot_GYM_App.dto.Address;
import com.jsp.Springboot_GYM_App.service.AddressService;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/saveAddress")
    @ApiOperation(value = "save address", notes = "API is used for saving")
    @ApiResponses({ @ApiResponse(code = 201, message = "Address saved Successfully"),
            @ApiResponse(code = 400, message = "Fields cannot be null or blank") })
    public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("/updateAddress")
    @ApiOperation(value = "update address", notes = "API is used for updating")
    @ApiResponses({ @ApiResponse(code = 201, message = "Address updated Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address, @RequestParam int id) {
        return addressService.updateAddress(id, address);
    }

    @GetMapping("/fetchAllAddresses")
    @ApiOperation(value = "fetch All address", notes = "API is used for fetching")
    @ApiResponses({ @ApiResponse(code = 302, message = "All addresses fetched Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public List<Address> fetchAll() {
        return addressService.fetchAll();
    }

    @GetMapping("/fetchAddress")
    @ApiOperation(value = "fetch address", notes = "API is used for fetching")
    @ApiResponses({ @ApiResponse(code = 302, message = "Address fetched Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Address>> fetchAddress(@RequestParam int id) {
        return addressService.fetchAddress(id);
    }

    @DeleteMapping("/deleteAddress")
    @ApiOperation(value = "delete address", notes = "API is used for deleting")
    @ApiResponses({ @ApiResponse(code = 201, message = "Address deleted Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id) {
        return addressService.deleteAddress(id);
    }
}
