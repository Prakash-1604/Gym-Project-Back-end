package com.jsp.Springboot_GYM_App.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springboot_GYM_App.dto.Trainer;
import com.jsp.Springboot_GYM_App.repo.TrainerRepo;

@Repository
public class TrainerDao {
	
		
		@Autowired
		private TrainerRepo trainerRepo;
		
		public Trainer saveTrainer(Trainer trainer) {
			return trainerRepo.save(trainer);
		}
	    public Trainer updateTrainer(int id, Trainer trainer) {
	        Optional<Trainer> dbTrainer = trainerRepo.findById(id);
	        if (dbTrainer.isPresent()) {
	            trainer.setTrainerId(id);
	            return this.saveTrainer(trainer);
	        }
	        return null;
	    }

	    public List<Trainer> fetchAll() {
	        return trainerRepo.findAll();
	    }

	    public Trainer fetchTrainer(int id) {
	        Optional<Trainer> trainer = trainerRepo.findById(id);
	        if (trainer.isPresent()) {
	            return trainer.get();
	        }
	        return null;
	    }

	    public Trainer deleteTrainer(int id) {
	        Optional<Trainer> trainer = trainerRepo.findById(id);
	        if (trainer.isPresent()) {
	            trainerRepo.deleteById(id);
	            return trainer.get();
	        }
	        return null;
	    }

}
