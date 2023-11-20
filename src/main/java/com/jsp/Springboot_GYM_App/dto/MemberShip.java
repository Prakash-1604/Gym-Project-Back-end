package com.jsp.Springboot_GYM_App.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MemberShip {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberShipId;
	private String memberShipName;
	private int memberShipDuaration;
	private String memberShipType;
	

	
	public int getMemberShipId() {
		return memberShipId;
	}
	public void setMemberShipId(int memberShipId) {
		this.memberShipId = memberShipId;
	}
	public String getMemberShipName() {
		return memberShipName;
	}
	public void setMemberShipName(String memberShipName) {
		this.memberShipName = memberShipName;
	}
	public int getMemberShipDuaration() {
		return memberShipDuaration;
	}
	public void setMemberShipDuaration(int memberShipDuaration) {
		this.memberShipDuaration = memberShipDuaration;
	}
	public String getMemberShipType() {
		return memberShipType;
	}
	public void setMemberShipType(String memberShipType) {
		this.memberShipType = memberShipType;
	}
}
