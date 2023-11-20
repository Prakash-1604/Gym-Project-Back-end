package com.jsp.Springboot_GYM_App.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BranchHead {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int branchHeadId;
	private String branchHeadName;
	private String branchHeadEmail;
	private long branchHeadPhone;
	

	
	public int getBranchHeadId() {
		return branchHeadId;
	}
	public void setBranchHeadId(int branchHeadId) {
		this.branchHeadId = branchHeadId;
	}
	public String getBranchHeadName() {
		return branchHeadName;
	}
	public void setBranchHeadName(String branchHeadName) {
		this.branchHeadName = branchHeadName;
	}
	public String getBranchHeadEmail() {
		return branchHeadEmail;
	}
	public void setBranchHeadEmail(String branchHeadEmail) {
		this.branchHeadEmail = branchHeadEmail;
	}
	public long getBranchHeadPhone() {
		return branchHeadPhone;
	}
	public void setBranchHeadPhone(long branchHeadPhone) {
		this.branchHeadPhone = branchHeadPhone;
	}
	
}
