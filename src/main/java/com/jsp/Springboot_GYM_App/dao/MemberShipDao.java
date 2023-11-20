package com.jsp.Springboot_GYM_App.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springboot_GYM_App.dto.MemberShip;
import com.jsp.Springboot_GYM_App.repo.MemberShipRepo;

@Repository
public class MemberShipDao {
	
		
		@Autowired
		private MemberShipRepo memberShipRepo;
		
		public MemberShip saveMemberShip(MemberShip memberShip) {
			return memberShipRepo.save(memberShip);
		}
		
		public MemberShip updateMemberShip(int id,MemberShip memberShip) {
			
		    Optional<MemberShip> dbMemberShip= memberShipRepo.findById(id);
		    if(dbMemberShip.isPresent()) {
		    	memberShip.setMemberShipId(id);
		    	return this.saveMemberShip(memberShip);
		    }
		    return null;
		}

		public List<MemberShip> fetchAll() {
		    return memberShipRepo.findAll();
		}

		public MemberShip fetchMemberShip(int id) {
			
		    Optional<MemberShip> memberShip= memberShipRepo.findById(id);
		    if(memberShip.isPresent()) {
		    	return memberShip.get();
		    }
		    return null;
		}

		public MemberShip deleteMemberShip(int id) {
			Optional<MemberShip> memberShip=memberShipRepo.findById(id);
			if(memberShip.isPresent()) {
			    memberShipRepo.deleteById(id);
			    return memberShip.get();
			}
			return null;
		}

}
