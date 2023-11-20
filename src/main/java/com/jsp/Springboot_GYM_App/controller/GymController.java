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

import com.jsp.Springboot_GYM_App.dto.Gym;
import com.jsp.Springboot_GYM_App.service.GymService;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




@RestController
public class GymController {

	@Autowired
	private GymService gymService;
	
	@PostMapping("/saveGym")
	@ApiOperation(value = "save gym",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "gym  saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
		public ResponseEntity<ResponseStructure<Gym>>saveGym(@Valid @RequestBody Gym gym)
	{
		return gymService.saveGym(gym);	
	}
	
	@PutMapping("/updateGym")
	@ApiOperation(value = "update gym",notes = "Api is used for updating " )
	@ApiResponses({ @ApiResponse(code = 201, message = "gym  updated Successfully"),
				@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Gym>> updateGym(@RequestBody Gym gym ,@RequestParam int id) {
		return gymService.updateGym( id,gym);
	}
	
	
	@PutMapping("/addExistingBranch")
	@ApiOperation(value = "update gym",notes = "Api is used for updating " )
	@ApiResponses({ @ApiResponse(code = 201, message = "gym  updated Successfully"),
				@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Gym>> addExistingBranch(@RequestParam List<Integer> branchId ,@RequestParam int id) {
		return gymService.addExistingBranch( id,branchId);
	}
	
	
	@GetMapping("/fetchAllGym")
	@ApiOperation(value = "fetch All gym",notes = "Api is used for fetching " )
	@ApiResponses({ @ApiResponse(code = 302, message = "All gym  fetched Successfully"),
				@ApiResponse(code = 400, message = "Id not found in Database") })
	public List<Gym> fetchAll(){
		return gymService.fetchAll();
	}
	
	@GetMapping("/fetchGym")
	@ApiOperation(value = "fetch gym",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 302, message = "gym  saved Successfully"),
				@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Gym>> fetchGym(@RequestParam int id) {
		return gymService.fetchGym(id);
	}
	
	@DeleteMapping("/deleteGym")
	@ApiOperation(value = "delete gym",notes = "Api is used for deleting " )
	@ApiResponses({ @ApiResponse(code = 201, message = "gym  deleteed Successfully"),
				@ApiResponse(code = 400, message = "Id not found in Database") })
	public ResponseEntity<ResponseStructure<Gym>> deleteGym(@RequestParam int id) {
		return gymService.deleteGym(id);
	}
}
