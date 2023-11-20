package com.jsp.Springboot_GYM_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Springboot_GYM_App.dao.BranchDao;
import com.jsp.Springboot_GYM_App.dto.Branch;
import com.jsp.Springboot_GYM_App.exception.BranchIdNotFound;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

@Service
public class BranchService {

    private static ResponseStructure<Branch> responseStructure = new ResponseStructure<>();

    @Autowired
    private BranchDao branchDao;

    public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
        Branch dbBranch = branchDao.saveBranch(branch);
        if (dbBranch != null) {
            responseStructure.setStatus(HttpStatus.CREATED.value());
            responseStructure.setMessage("Successfully inserted");
            responseStructure.setData(dbBranch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch branch)  {
        Branch dbBranch = branchDao.updateBranch(id, branch);
        if (dbBranch != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbBranch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchIdNotFound();
    }
    
    public ResponseEntity<ResponseStructure<Branch>> addBranchHead(int id, int branchHeadId)  {
        Branch dbBranch = branchDao.addBranchHead(id, branchHeadId);
        if (dbBranch != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbBranch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchIdNotFound();
    }
    
    public ResponseEntity<ResponseStructure<Branch>> addAddress(int id, int addressId)  {
        Branch dbBranch = branchDao.addAddress(id, addressId);
        if (dbBranch != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbBranch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchIdNotFound();
    }

    public ResponseEntity<ResponseStructure<Branch>> addTrainers(int id, List<Integer> trainerId)  {
        Branch dbBranch = branchDao.addTrainers(id, trainerId);
        if (dbBranch != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbBranch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchIdNotFound();
    }
    
    public ResponseEntity<ResponseStructure<Branch>> addMemberShips(int id, List<Integer> memberShipId)  {
        Branch dbBranch = branchDao.addMemberShips(id, memberShipId);
        if (dbBranch != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbBranch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchIdNotFound();
    }
    
    public ResponseEntity<ResponseStructure<Branch>> addCustomers(int id, List<Integer> customerId)  {
        Branch dbBranch = branchDao.addCustomers(id, customerId);
        if (dbBranch != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbBranch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchIdNotFound();
    }
    
    
    public List<Branch> fetchAll() {
        return branchDao.fetchAll();
    }

    public ResponseEntity<ResponseStructure<Branch>> fetchBranch(int id) {
        Branch branch = branchDao.fetchBranch(id);
        if (branch != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(branch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchIdNotFound();
    }

    public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
        Branch branch = branchDao.deleteBranch(id);
        if (branch != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(branch);
            return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchIdNotFound();
    }
}
