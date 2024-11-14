package com.example.demo.repositieries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Login;


public interface LoginRepo  extends JpaRepository<Login, Integer>{

	public Login findByEmailAndPassword(String email,Long  password);
}
