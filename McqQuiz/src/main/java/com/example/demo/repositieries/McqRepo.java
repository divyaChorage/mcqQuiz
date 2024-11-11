package com.example.demo.repositieries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Mcq;
import com.example.demo.entity.SubmittedAns;

public interface McqRepo extends JpaRepository<Mcq, Integer>{

	
	List<Mcq>  findBySubjectId(int subjectId);

	
	List<Mcq>  getAllMcqBySubjectId(int subjectId);
	


}
