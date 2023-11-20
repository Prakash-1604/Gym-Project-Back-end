package com.jsp.Springboot_GYM_App.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springboot_GYM_App.dto.Branch;
import com.jsp.Springboot_GYM_App.dto.Gym;
import com.jsp.Springboot_GYM_App.repo.BranchRepo;
import com.jsp.Springboot_GYM_App.repo.GymRepo;

@Repository
public class GymDao {
	
	@Autowired
	private GymRepo gymRepo;


	@Autowired
	private BranchRepo branchRepo;
	
	public Gym saveGym(Gym gym) {
		return gymRepo.save(gym);
	}
	
	public Gym updateGym( int id,Gym gym) {
		Optional<Gym> dbGym=gymRepo.findById(id);
		if(dbGym.isPresent()) {
			gym.setGymId(id);
			return this.saveGym(gym);
		}
		return null;
		
	}
	
	public Gym addExistingBranch(int id,List<Integer> branchId) {
		Optional<Gym> dbGym=gymRepo.findById(id);
		if(dbGym.isPresent()) {
			Gym gym=dbGym.get();
			List<Branch> branch = gym.getBranchs();
			for(Integer i:branchId) {
				branch.add(branchRepo.findById(i).get());
			}
			gym.setBranchs(branch);
			return this.saveGym(gym);
		}
		return null;
		
	}

	public List<Gym> fetchAll(){
		return gymRepo.findAll();
	}
	
	public Gym fetchGym(int id) {
		Optional<Gym> gym=gymRepo.findById(id);
		if(gym.isPresent()) {
			return gym.get();
		}
		return null;
	}
	
	public Gym deleteGym(int id) {
		Optional<Gym> gym=gymRepo.findById(id);
		if(gym.isPresent()) {
			gymRepo.deleteById(id);
			return gym.get();
		}
		return null;
	}
}
