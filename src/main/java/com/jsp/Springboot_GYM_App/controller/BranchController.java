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

import com.jsp.Springboot_GYM_App.dto.Branch;
import com.jsp.Springboot_GYM_App.service.BranchService;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@PostMapping("/saveBranch")
	@ApiOperation(value = "save branch", notes = "Api is used for saving")
	@ApiResponses({ @ApiResponse(code = 201, message = "branch saved Successfully"),
			@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@PutMapping("/updateBranch")
	@ApiOperation(value = "update branch", notes = "Api is used for updating")
	@ApiResponses({ @ApiResponse(code = 201, message = "branch updated Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @RequestParam int id) {
		return branchService.updateBranch(id, branch);
	}
	
	@PutMapping("/addBranchHead")
	@ApiOperation(value = "add branchHead", notes = "Api is used for updating")
	@ApiResponses({ @ApiResponse(code = 201, message = "branch updated Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Branch>> addBranchHead(@RequestParam int id, @RequestParam int branchHeadId) {
		return branchService.addBranchHead(id, branchHeadId);
	}

	@PutMapping("/addAddress")
	@ApiOperation(value = "add address", notes = "Api is used for updating")
	@ApiResponses({ @ApiResponse(code = 201, message = "branch updated Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Branch>> addAddress(@RequestParam int id, @RequestParam int addressId) {
		return branchService.addAddress(id, addressId);
	}
	
	@PutMapping("/addTrainers")
	@ApiOperation(value = "add trainers", notes = "Api is used for updating")
	@ApiResponses({ @ApiResponse(code = 201, message = "branch updated Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Branch>> addTriners(@RequestParam int id, @RequestParam List<Integer> trainerId) {
		return branchService.addTrainers(id, trainerId);
	}
	
	@PutMapping("/addMemberShips")
	@ApiOperation(value = "add memberShips", notes = "Api is used for updating")
	@ApiResponses({ @ApiResponse(code = 201, message = "branch updated Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Branch>> addMemberShips(@RequestParam int id, @RequestParam List<Integer> memberShipId) {
		return branchService.addMemberShips(id, memberShipId);
	}
	
	@PutMapping("/addCustomers")
	@ApiOperation(value = "add customers", notes = "Api is used for updating")
	@ApiResponses({ @ApiResponse(code = 201, message = "branch updated Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Branch>> addCustomers(@RequestParam int id, @RequestParam List<Integer> customerId) {
		return branchService.addCustomers(id, customerId);
	}
	
	@GetMapping("/fetchAllBranches")
	@ApiOperation(value = "fetch All branch", notes = "Api is used for fetching")
	@ApiResponses({ @ApiResponse(code = 302, message = "All branch fetched Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public List<Branch> fetchAll() {
		return branchService.fetchAll();
	}

	@GetMapping("/fetchBranch")
	@ApiOperation(value = "fetch branch", notes = "Api is used for fetching")
	@ApiResponses({ @ApiResponse(code = 302, message = "branch saved Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Branch>> fetchBranch(@RequestParam int id) {
		return branchService.fetchBranch(id);
	}

	@DeleteMapping("/deleteBranch")
	@ApiOperation(value = "delete branch", notes = "Api is used for deleting")
	@ApiResponses({ @ApiResponse(code = 201, message = "branch deleted Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return branchService.deleteBranch(id);
	}
}
