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

import com.jsp.Springboot_GYM_App.dto.BranchHead;
import com.jsp.Springboot_GYM_App.service.BranchHeadService;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchHeadController {

	@Autowired
	private BranchHeadService branchHeadService;
	
	@PostMapping("/saveBranchHead")
	@ApiOperation(value = "save branchHead", notes = "Api is used for saving branchHead")
	@ApiResponses({ @ApiResponse(code = 201, message = "branchHead saved Successfully"),
			@ApiResponse(code = 400, message = "fields cannot be null or blank") })
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@Valid @RequestBody BranchHead branchHead) {
		return branchHeadService.saveBranchHead(branchHead);
	}

	@PutMapping("/updateBranchHead")
	@ApiOperation(value = "update branchHead", notes = "Api is used for updating")
	@ApiResponses({ @ApiResponse(code = 201, message = "branchHead updated Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHead(@RequestBody BranchHead branchHead,
			@RequestParam int id) {
		return branchHeadService.updateBranchHead(id, branchHead);
	}

	@GetMapping("/fetchAllBranchHeads")
	@ApiOperation(value = "fetch All branchHead", notes = "Api is used for fetching")
	@ApiResponses({ @ApiResponse(code = 302, message = "All branchHead fetched Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public List<BranchHead> fetchAll() {
		return branchHeadService.fetchAll();
	}

	@GetMapping("/fetchBranchHead")
	@ApiOperation(value = "fetch branchHead", notes = "Api is used for saving")
	@ApiResponses({ @ApiResponse(code = 302, message = "branchHead saved Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHead(@RequestParam int id) {
		return branchHeadService.fetchBranchHead(id);
	}

	@DeleteMapping("/deleteBranchHead")
	@ApiOperation(value = "delete branchHead", notes = "Api is used for deleting")
	@ApiResponses({ @ApiResponse(code = 201, message = "branchHead deleted Successfully"),
			@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHead(@RequestParam int id) {
		return branchHeadService.deleteBranchHead(id);
	}
}
