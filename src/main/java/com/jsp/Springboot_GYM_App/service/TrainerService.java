package com.jsp.Springboot_GYM_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Springboot_GYM_App.dao.TrainerDao;
import com.jsp.Springboot_GYM_App.dto.Trainer;
import com.jsp.Springboot_GYM_App.exception.TrainerIdNotFound;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

@Service
public class TrainerService {

    private static ResponseStructure<Trainer> responseStructure = new ResponseStructure<>();

    @Autowired
    private TrainerDao trainerDao;

    public ResponseEntity<ResponseStructure<Trainer>> saveTrainer(Trainer trainer) {
        Trainer dbTrainer = trainerDao.saveTrainer(trainer);
        if (dbTrainer != null) {
            responseStructure.setStatus(HttpStatus.CREATED.value());
            responseStructure.setMessage("Successfully inserted");
            responseStructure.setData(dbTrainer);
            return new ResponseEntity<ResponseStructure<Trainer>>(responseStructure, HttpStatus.CREATED);
        }
        return null;
    }

    public ResponseEntity<ResponseStructure<Trainer>> updateTrainer(int id, Trainer trainer) {
        Trainer dbTrainer = trainerDao.updateTrainer(id, trainer);
        if (dbTrainer != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully updated");
            responseStructure.setData(dbTrainer);
            return new ResponseEntity<ResponseStructure<Trainer>>(responseStructure, HttpStatus.FOUND);
        }
        throw new TrainerIdNotFound();
    }

    public List<Trainer> fetchAll() {
        return trainerDao.fetchAll();
    }

    public ResponseEntity<ResponseStructure<Trainer>> fetchTrainer(int id) {
        Trainer trainer = trainerDao.fetchTrainer(id);
        if (trainer != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(trainer);
            return new ResponseEntity<ResponseStructure<Trainer>>(responseStructure, HttpStatus.FOUND);
        }
        throw new TrainerIdNotFound();
    }

    public ResponseEntity<ResponseStructure<Trainer>> deleteTrainer(int id) {
        Trainer trainer = trainerDao.deleteTrainer(id);
        if (trainer != null) {
            responseStructure.setStatus(HttpStatus.FOUND.value());
            responseStructure.setMessage("Successfully Fetched");
            responseStructure.setData(trainer);
            return new ResponseEntity<ResponseStructure<Trainer>>(responseStructure, HttpStatus.FOUND);
        }
        throw new TrainerIdNotFound();
    }
}
