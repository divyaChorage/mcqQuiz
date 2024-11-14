package com.example.demo.controller;


import java.util.Map;

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

import com.example.demo.Impl.McqImpl;
import com.example.demo.entity.Mcq;
import com.example.demo.entity.QuizSubmissionRequest;
import com.example.demo.entity.ReviewTestDTO;
import com.example.demo.entity.Subjects;
import com.example.demo.entity.SubmittedAns;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	McqImpl mcqImpl;
	
	
	
	  @GetMapping("getAllSub")
	    public ResponseEntity<List<Subjects>> gettingSubj() {
	        List<Subjects> sub = mcqImpl.getAllSubjects();
	        System.out.println("gettingSubj in controller-----------"+sub);
	        return ResponseEntity.ok(sub);
	    }
	  
	  

	    @PostMapping("submitQuiz")
	    public ResponseEntity<SubmittedAns> submitQuiz(@RequestBody QuizSubmissionRequest submissionRequest) {
	        SubmittedAns submittedAns = mcqImpl.submitQuiz(
	                submissionRequest.getUserId(),
	                submissionRequest.getSubjectId(),
	                submissionRequest.getMcqIds(),
	                submissionRequest.getUserAnswers()
	        );
	        return ResponseEntity.ok(submittedAns);
	    }
	
	    
	    
	    @GetMapping("viewScore/{userId}/{subjectId}")
	    public ResponseEntity<List<SubmittedAns>> getViewScore(
	            @PathVariable int userId, @PathVariable int subjectId) {
	        List<SubmittedAns> submittedAnsList = mcqImpl.getViewScore(userId, subjectId);
	        if (!submittedAnsList.isEmpty()) {
	            return ResponseEntity.ok(submittedAnsList);
	        }
	        return ResponseEntity.notFound().build();
	    }
	    
	    
	    @GetMapping("reviewTest/{userId}/{subjectId}")
	    public ResponseEntity<List<SubmittedAns>> reviewTest(
	    		@PathVariable int userId, @PathVariable int subjectId) {
	        List<SubmittedAns> reviewData = mcqImpl.getReviewTest(subjectId, userId);
	        if (reviewData != null && !reviewData.isEmpty()) {
	            return ResponseEntity.ok(reviewData);
	        }
	        return ResponseEntity.notFound().build();
	    }
	    
	    
	    @GetMapping("reviewTestDetails/{subjectId}")
	   public ResponseEntity<List<Mcq>> getReviewTestDetails(@PathVariable int subjectId) {
	        System.out.println(" getting mcqs ids  to return ans----"+subjectId);

	    	List<Mcq> mcqs = mcqImpl.getMcqsByIds(subjectId);
	        
	        System.out.println(" returring que and  corret and-----"+mcqs);
	        return ResponseEntity.ok(mcqs);
	    }


	    
	   
}
