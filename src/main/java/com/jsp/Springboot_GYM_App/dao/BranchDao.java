package com.jsp.Springboot_GYM_App.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springboot_GYM_App.dto.Address;
import com.jsp.Springboot_GYM_App.dto.Branch;
import com.jsp.Springboot_GYM_App.dto.BranchHead;
import com.jsp.Springboot_GYM_App.dto.Customer;
import com.jsp.Springboot_GYM_App.dto.MemberShip;
import com.jsp.Springboot_GYM_App.dto.Trainer;
import com.jsp.Springboot_GYM_App.repo.AddressRepo;
import com.jsp.Springboot_GYM_App.repo.BranchHeadRepo;
import com.jsp.Springboot_GYM_App.repo.BranchRepo;
import com.jsp.Springboot_GYM_App.repo.CustomerRepo;
import com.jsp.Springboot_GYM_App.repo.MemberShipRepo;
import com.jsp.Springboot_GYM_App.repo.TrainerRepo;

@Repository
public class BranchDao {
	
		
		@Autowired
		private BranchRepo branchRepo;
		
		@Autowired
		private BranchHeadRepo branchHeadRepo;
		
		@Autowired
		private AddressRepo addressRepo;
		
		@Autowired
		private CustomerRepo customerRepo;
		
		@Autowired
		private TrainerRepo trainerRepo;
		
		@Autowired
		private MemberShipRepo memberShipRepo;
		
		public Branch saveBranch(Branch branch) {
			return branchRepo.save(branch);
		}
		
		public Branch updateBranch(int id, Branch branch) {
		    Optional<Branch> dbBranch = branchRepo.findById(id);
		    if (dbBranch.isPresent()) {
		        branch.setBranchId(id);
		        return this.saveBranch(branch);
		    }
		    return null;
		}

		public Branch addBranchHead(int id, int branchHeadId) {
		    Optional<Branch> dbBranch = branchRepo.findById(id);
		    if (dbBranch.isPresent()) {
			    Branch branch=dbBranch.get();
			    BranchHead branchHead=branch.getBranchHead();
		    	branchHead=branchHeadRepo.findById(branchHeadId).get();
		        branch.setBranchHead(branchHead);
		        return this.saveBranch(branch);
		    }
		    return null;
		}
		
		public Branch addAddress(int id, int addressId) {
		    Optional<Branch> dbBranch = branchRepo.findById(id);
		    if (dbBranch.isPresent()) {
			    Branch branch=dbBranch.get();
			    Address address=branch.getAddress();
		    	address=addressRepo.findById(addressId).get();
		        branch.setAddress(address);
		        return this.saveBranch(branch);
		    }
		    return null;
		}
		
		public Branch addCustomers(int id, List<Integer> customerId) {
		    Optional<Branch> dbBranch = branchRepo.findById(id);
		    if (dbBranch.isPresent()) {
			    Branch branch=dbBranch.get();
			    List<Customer> customer=branch.getCustomers();
			    for(Integer i:customerId) {
			    	customer.add(customerRepo.findById(i).get());
			    }
		        branch.setCustomers(customer);
		        return this.saveBranch(branch);
		    }
		    return null;
		}
		
		public Branch addTrainers(int id, List<Integer> trainerId) {
		    Optional<Branch> dbBranch = branchRepo.findById(id);
		    if (dbBranch.isPresent()) {
			    Branch branch=dbBranch.get();
			    List<Trainer> trainer=branch.getTrainers();
			    for(Integer i:trainerId) {
			    	trainer.add(trainerRepo.findById(i).get());
			    }
		        branch.setTrainers(trainer);
		        return this.saveBranch(branch);
		    }
		    return null;
		}
		
		
		public Branch addMemberShips(int id, List<Integer> memberShipId) {
		    Optional<Branch> dbBranch = branchRepo.findById(id);
		    if (dbBranch.isPresent()) {
			    Branch branch=dbBranch.get();
			    List<MemberShip> memberShip=branch.getMemberships();
		        for (Integer memberId : memberShipId) {
		            boolean exists = false;
		            
		            // Check if the membership ID already exists in the branch's memberships
		            for (MemberShip existingMembership : memberShip) {
		                if (memberId.equals(existingMembership.getMemberShipId())) {
		                    exists = true;
		                    break;
		                }
		            }
		            
		            // If the membership ID doesn't exist in the branch's memberships, add it
		            if (!exists) {
		                memberShip.add(memberShipRepo.findById(memberId).get());
		            }
		        }
		        branch.setMemberships(memberShip);
		        return this.saveBranch(branch);
		    }
		    return null;
		}

		public List<Branch> fetchAll() {
		    return branchRepo.findAll();
		}

		public Branch fetchBranch(int id) {
		    Optional<Branch> branch = branchRepo.findById(id);
		    if (branch.isPresent()) {
		        return branch.get();
		    }
		    return null;
		}

		public Branch deleteBranch(int id) {
		    Optional<Branch> branch = branchRepo.findById(id);
		    if (branch.isPresent()) {
		        branchRepo.deleteById(id);
		        return branch.get();
		    }
		    return null;
		}
}

