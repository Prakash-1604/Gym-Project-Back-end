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

import com.jsp.Springboot_GYM_App.dto.Trainer;
import com.jsp.Springboot_GYM_App.service.TrainerService;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TrainerController {

    @Autowired
    private TrainerService trainerService;
    
    @PostMapping("/saveTrainer")
    @ApiOperation(value = "save trainer", notes = "Api is used for saving trainer")
    @ApiResponses({ @ApiResponse(code = 201, message = "Trainer saved Successfully"),
            @ApiResponse(code = 400, message = "fields cannot be null or blank") })
    public ResponseEntity<ResponseStructure<Trainer>> saveTrainer(@Valid @RequestBody Trainer trainer) {
        return trainerService.saveTrainer(trainer);
    }
    
    @PutMapping("/updateTrainer")
    @ApiOperation(value = "update trainer", notes = "Api is used for updating")
    @ApiResponses({ @ApiResponse(code = 201, message = "Trainer updated Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Trainer>> updateTrainer(@RequestBody Trainer trainer, @RequestParam int id) {
        return trainerService.updateTrainer(id, trainer);
    }
    
    @GetMapping("/fetchAllTrainers")
    @ApiOperation(value = "fetch All trainer", notes = "Api is used for fetching")
    @ApiResponses({ @ApiResponse(code = 302, message = "All trainer fetched Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public List<Trainer> fetchAll() {
        return trainerService.fetchAll();
    }
    
    @GetMapping("/fetchTrainer")
    @ApiOperation(value = "fetch trainer", notes = "Api is used for fetching")
    @ApiResponses({ @ApiResponse(code = 302, message = "Trainer fetched Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Trainer>> fetchTrainer(@RequestParam int id) {
        return trainerService.fetchTrainer(id);
    }
    
    @DeleteMapping("/deleteTrainer")
    @ApiOperation(value = "delete trainer", notes = "Api is used for deleting")
    @ApiResponses({ @ApiResponse(code = 201, message = "Trainer deleted Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<Trainer>> deleteTrainer(@RequestParam int id) {
        return trainerService.deleteTrainer(id);
    }
}
