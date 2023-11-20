package com.jsp.Springboot_GYM_App.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int trainerId;
	private String trainerName;
	private String trainerEmail;
	private long trainerPhone;
	private int trainerExperience;
	

	
	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainerEmail() {
		return trainerEmail;
	}
	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}
	public long getTrainerPhone() {
		return trainerPhone;
	}
	public void setTrainerPhone(long trainerPhone) {
		this.trainerPhone = trainerPhone;
	}
	public int getTrainerExperience() {
		return trainerExperience;
	}
	public void setTrainerExperience(int trainerExperience) {
		this.trainerExperience = trainerExperience;
	}
	
}
