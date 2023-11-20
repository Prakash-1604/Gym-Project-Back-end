package com.jsp.Springboot_GYM_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Springboot_GYM_App.dao.MemberShipDao;
import com.jsp.Springboot_GYM_App.dto.MemberShip;
import com.jsp.Springboot_GYM_App.exception.MemberShipIdNotFound;
import com.jsp.Springboot_GYM_App.util.ResponseStructure;

@Service
public class MemberShipService {

	private static ResponseStructure<MemberShip> responseStructure = new ResponseStructure<>();

	@Autowired
	private MemberShipDao memberShipDao;

	public ResponseEntity<ResponseStructure<MemberShip>> saveMemberShip(MemberShip memberShip) {
		MemberShip dbMemberShip = memberShipDao.saveMemberShip(memberShip);
		if (dbMemberShip != null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Successfully inserted");
			responseStructure.setData(dbMemberShip);
			return new ResponseEntity<ResponseStructure<MemberShip>>(responseStructure, HttpStatus.CREATED);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<MemberShip>> updateMemberShip(int id, MemberShip memberShip) {

		MemberShip dbMemberShip = memberShipDao.updateMemberShip(id, memberShip);
		if (dbMemberShip != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully updated");
			responseStructure.setData(dbMemberShip);
			return new ResponseEntity<ResponseStructure<MemberShip>>(responseStructure, HttpStatus.FOUND);
		}
		throw new MemberShipIdNotFound();
	}

	public List<MemberShip> fetchAll() {
		return memberShipDao.fetchAll();
	}

	public ResponseEntity<ResponseStructure<MemberShip>> fetchMemberShip(int id) {
		MemberShip memberShip = memberShipDao.fetchMemberShip(id);
		if (memberShip != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched");
			responseStructure.setData(memberShip);
			return new ResponseEntity<ResponseStructure<MemberShip>>(responseStructure, HttpStatus.FOUND);
		}
		throw new MemberShipIdNotFound();
	}

	public ResponseEntity<ResponseStructure<MemberShip>> deleteMemberShip(int id) {
		MemberShip memberShip = memberShipDao.deleteMemberShip(id);
		if (memberShip != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Fetched");
			responseStructure.setData(memberShip);
			return new ResponseEntity<ResponseStructure<MemberShip>>(responseStructure, HttpStatus.FOUND);
		}
		throw new MemberShipIdNotFound();
	}
}
