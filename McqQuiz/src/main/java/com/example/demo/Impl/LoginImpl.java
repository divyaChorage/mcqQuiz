package com.example.demo.Impl;

import java.util.List;

import com.example.demo.entity.Login;
import com.example.demo.entity.Subjects;

public interface LoginImpl {
   
	
	public int saveUser(Login data);
	public Login loginUser(String email,Long password);
	public Login getOneUser(int id);
	
	public  List<Subjects> getAllSubjectByUserId(int id);
	
	public Subjects saveEmp1(Subjects emp,int id);
}
