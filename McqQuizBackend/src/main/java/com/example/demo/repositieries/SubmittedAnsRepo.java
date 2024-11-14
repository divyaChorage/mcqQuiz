package com.example.demo.repositieries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ReviewTestDTO;
import com.example.demo.entity.SubmittedAns;


public interface SubmittedAnsRepo  extends JpaRepository<SubmittedAns, Integer> {
    List<SubmittedAns> findByUserIdAndSubjectId(int userId, int subjectId);
    

   
}
