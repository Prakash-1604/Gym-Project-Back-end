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

import com.jsp.Springboot_GYM_App.dto.MemberShip;
import com.jsp.Springboot_GYM_App.service.MemberShipService;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MemberShipController {

    @Autowired
    private MemberShipService memberShipService;

    @PostMapping("/saveMemberShip")
    @ApiOperation(value = "save membership", notes = "API is used for saving")
    @ApiResponses({ @ApiResponse(code = 201, message = "Membership saved Successfully"),
            @ApiResponse(code = 400, message = "Fields cannot be null or blank") })
    public ResponseEntity<ResponseStructure<MemberShip>> saveMembership(@Valid @RequestBody MemberShip memberShip) {
        return memberShipService.saveMemberShip(memberShip);
    }

    @PutMapping("/updateMemberShip")
    @ApiOperation(value = "update membership", notes = "API is used for updating")
    @ApiResponses({ @ApiResponse(code = 201, message = "Membership updated Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<MemberShip>> updateMembership(@RequestBody MemberShip memberShip, @RequestParam int id) {
        return memberShipService.updateMemberShip(id, memberShip);
    }

    @GetMapping("/fetchAllMemberShips")
    @ApiOperation(value = "fetch All memberships", notes = "API is used for fetching")
    @ApiResponses({ @ApiResponse(code = 302, message = "All memberships fetched Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public List<MemberShip> fetchAll() {
        return memberShipService.fetchAll();
    }

    @GetMapping("/fetchMemberShip")
    @ApiOperation(value = "fetch membership", notes = "API is used for fetching")
    @ApiResponses({ @ApiResponse(code = 302, message = "Membership fetched Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<MemberShip>> fetchMembership(@RequestParam int id) {
        return memberShipService.fetchMemberShip(id);
    }

    @DeleteMapping("/deleteMemberShip")
    @ApiOperation(value = "delete membership", notes = "API is used for deleting")
    @ApiResponses({ @ApiResponse(code = 201, message = "Membership deleted Successfully"),
            @ApiResponse(code = 400, message = "Id not found in Database") })
    public ResponseEntity<ResponseStructure<MemberShip>> deleteMembership(@RequestParam int id) {
        return memberShipService.deleteMemberShip(id);
    }
}
