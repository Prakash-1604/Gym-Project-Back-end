package com.jsp.Springboot_GYM_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Springboot_GYM_App.dao.BranchHeadDao;
import com.jsp.Springboot_GYM_App.dto.BranchHead;
import com.jsp.Springboot_GYM_App.exception.BranchHeadIdNotFound;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

@Service
public class BranchHeadService {

    private static ResponseStructure<BranchHead> responseStructure = new ResponseStructure<>();

    @Autowired
    private BranchHeadDao branchHeadDao;

    public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead) {
        BranchHead dbBranchHead = branchHeadDao.saveBranchHead(branchHead);
        if (dbBranchHead != null) {
            responseStructure.setStatus(HttpStatus.CREATED.value());
            responseStructure.setMessage("Successfully inserted");
            responseStructure.setData(dbBranchHead);
            return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.CREATED);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHead(int id, BranchHead branchHead) {
        BranchHead dbBranchHead = branchHeadDao.updateBranchHead(id, branchHead);
        if (dbBranchHead != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbBranchHead);
            return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchHeadIdNotFound();
    }

    public List<BranchHead> fetchAll() {
        return branchHeadDao.fetchAll();
    }

    public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHead(int id) {
        BranchHead branchHead = branchHeadDao.fetchBranchHead(id);
        if (branchHead != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(branchHead);
            return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchHeadIdNotFound();
    }

    public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHead(int id) {
        BranchHead branchHead = branchHeadDao.deleteBranchHead(id);
        if (branchHead != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(branchHead);
            return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.FOUND);
        }
        throw new BranchHeadIdNotFound();
    }
}
