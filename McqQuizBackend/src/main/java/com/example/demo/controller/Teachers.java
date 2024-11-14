package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Impl.LoginImpl;
import com.example.demo.entity.Login;
import com.example.demo.entity.Subjects;
import com.example.demo.repositieries.LoginRepo;
import com.example.demo.repositieries.SubjectRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Teachers {
	
	 @Autowired
	     SubjectRepo subjectRepo;
	 
	 @Autowired
	 LoginRepo loginRepo;
	 
	   @Autowired
	    private LoginImpl loginImpl;

	   
}