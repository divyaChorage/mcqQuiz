package com.example.demo.Impl;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Mcq;
import com.example.demo.entity.ReviewTestDTO;
import com.example.demo.entity.Subjects;
import com.example.demo.entity.SubmittedAns;



public interface McqImpl {
	public Mcq addMCQToSubject(int subjectId, Mcq mcq);
	
	public List<Mcq> getMCQsBySubjectId(int subjectId);
	
	public int deleteMcq(int mcqId);
	
	
	public List<Subjects> getAllSubjects();
	
	SubmittedAns submitQuiz(int userId, int subjectId, List<Integer> mcqIds, List<String> userAnswers);

	
	List<SubmittedAns> getViewScore(int userId,int subjectId);
	
	 List<Subjects> getSubjectsByUserId(int loginId);
	 
	 List<SubmittedAns> getReviewTest(int subjectId, int userId);
	 
	 
	 List<Mcq> getMcqsByIds(int subjectId);
	 
	 
	 
	 Mcq updateMcqBycqId(Mcq mcq,int mcqId);	
	 
	 
	 int deleteSubject(int subjectId);
}