package com.jsp.Springboot_GYM_App.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Springboot_GYM_App.dto.Gym;

public interface GymRepo extends JpaRepository<Gym, Integer> {

}
