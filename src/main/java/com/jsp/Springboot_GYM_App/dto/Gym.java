package com.jsp.Springboot_GYM_App.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
public class Gym {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gymId;
	
	@NotNull(message = "Gym name cannot be null")
	@NotBlank(message = "Gym name cannot be blank")
	private String gymName;
	@NotNull(message = "Gym name cannot be null")
	@NotBlank(message = "Gym name cannot be blank")
	private String gymOwner;
	@NotNull(message = "Gym name cannot be null")
	@NotBlank(message = "Gym name cannot be blank")
	private String gymGst;
	@NotNull(message = "Gym name cannot be null")
	@Pattern(regexp="[6789]{1}\\d{9}",message="Invalid Number")
	private String gymNumber;
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<Branch> branchs;
	
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymOwner() {
		return gymOwner;
	}
	public void setGymOwner(String gymOwner) {
		this.gymOwner = gymOwner;
	}
	public String getGymGst() {
		return gymGst;
	}
	public void setGymGst(String gymGst) {
		this.gymGst = gymGst;
	}
	public String getGymNumber() {
		return gymNumber;
	}
	public void setGymNumber(String gymNumber) {
		this.gymNumber = gymNumber;
	}

	
	

}
