package com.jsp.Springboot_GYM_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Springboot_GYM_App.dao.GymDao;
import com.jsp.Springboot_GYM_App.dto.Gym;
import com.jsp.Springboot_GYM_App.exception.GymIdNotFound;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;


@Service
public class GymService {

	private static ResponseStructure<Gym> responseStructure=new ResponseStructure<>();

	@Autowired
	private GymDao gymDao;
	
	public ResponseEntity<ResponseStructure<Gym>> saveGym(Gym gym)
	{
		Gym dbGym=gymDao.saveGym(gym);
		if(dbGym!=null)
		{
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Sucessfully inserted");
			responseStructure.setData( dbGym);
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.CREATED);
		}
		return null;	
	}
	
	public ResponseEntity<ResponseStructure<Gym>> updateGym( int id,Gym gym) {
		
		Gym dbGym=gymDao.updateGym(id,gym);
		if(dbGym!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessfully updated");
			responseStructure.setData( dbGym);
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.FOUND);
		}
		throw new GymIdNotFound();
	}
	
	public ResponseEntity<ResponseStructure<Gym>> addExistingBranch(int id,List<Integer> branchId) {
		
		Gym dbGym=gymDao.addExistingBranch(id,branchId);
		if(dbGym!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessfully updated");
			responseStructure.setData( dbGym);
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.FOUND);
		}
		throw new GymIdNotFound();
	}
	
	public List<Gym> fetchAll(){
		return gymDao.fetchAll();
	}
	
	public ResponseEntity<ResponseStructure<Gym>> fetchGym(int id) {
		Gym gym=gymDao.fetchGym(id);
		if(gym!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessfully Fetched");
			responseStructure.setData(gym);
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.FOUND);
		}
		throw new GymIdNotFound();
	}
	
	public ResponseEntity<ResponseStructure<Gym>> deleteGym(int id) {
		Gym gym=gymDao.deleteGym(id);
		if(gym!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessfully Fetched");
			responseStructure.setData(gym);
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.FOUND);
		}
		throw new GymIdNotFound();
	}
}
