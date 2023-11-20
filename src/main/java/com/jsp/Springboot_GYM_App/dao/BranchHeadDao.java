package com.jsp.Springboot_GYM_App.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springboot_GYM_App.dto.BranchHead;
import com.jsp.Springboot_GYM_App.repo.BranchHeadRepo;

@Repository
public class BranchHeadDao {
	
		
		@Autowired
		private BranchHeadRepo branchHeadRepo;
		
		public BranchHead saveBranchHead(BranchHead branchHead) {
			return branchHeadRepo.save(branchHead);
		}
		
		public BranchHead updateBranchHead(int id, BranchHead branchHead) {
		    Optional<BranchHead> dbBranchHead = branchHeadRepo.findById(id);
		    if (dbBranchHead.isPresent()) {
		        branchHead.setBranchHeadId(id);
		        return this.saveBranchHead(branchHead);
		    }
		    return null;
		}

		public List<BranchHead> fetchAll() {
		    return branchHeadRepo.findAll();
		}

		public BranchHead fetchBranchHead(int id) {
		    Optional<BranchHead> branchHead = branchHeadRepo.findById(id);
		    if (branchHead.isPresent()) {
		        return branchHead.get();
		    }
		    return null;
		}

		public BranchHead deleteBranchHead(int id) {
		    Optional<BranchHead> branchHead = branchHeadRepo.findById(id);
		    if (branchHead.isPresent()) {
		        branchHeadRepo.deleteById(id);
		        return branchHead.get();
		    }
		    return null;
		}


}
