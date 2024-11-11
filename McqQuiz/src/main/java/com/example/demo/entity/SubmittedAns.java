package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubmittedAns {

	
	//userId/
	//subj id
	// list of mcqids
	
	 //totalmcqquestions
	
	//useranwers
	//iscorrector false each mcq 
	
	//total corret ans means  user  score 
	//
	
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	      int id;

	     int userId;
	      int subjectId;
	      int totalMcqQuestions;
	      int totalCorrectAnswers; // user's score

	    @ElementCollection
	      List<Integer> mcqIds;

	    @ElementCollection
	      List<String> userAnswers; // each answer is "correct" or "false"

	    // Getters and setters

	    public SubmittedAns() {}

	    public SubmittedAns(int userId, int subjectId, List<Integer> mcqIds, List<String> userAnswers, int totalMcqQuestions, int totalCorrectAnswers) {
	        this.userId = userId;
	        this.subjectId = subjectId;
	        this.mcqIds = mcqIds;
	        this.userAnswers = userAnswers;
	        this.totalMcqQuestions = totalMcqQuestions;
	        this.totalCorrectAnswers = totalCorrectAnswers;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(int subjectId) {
			this.subjectId = subjectId;
		}

		public int getTotalMcqQuestions() {
			return totalMcqQuestions;
		}

		public void setTotalMcqQuestions(int totalMcqQuestions) {
			this.totalMcqQuestions = totalMcqQuestions;
		}

		public int getTotalCorrectAnswers() {
			return totalCorrectAnswers;
		}

		public void setTotalCorrectAnswers(int totalCorrectAnswers) {
			this.totalCorrectAnswers = totalCorrectAnswers;
		}

		public List<Integer> getMcqIds() {
			return mcqIds;
		}

		public void setMcqIds(List<Integer> mcqIds) {
			this.mcqIds = mcqIds;
		}

		public List<String> getUserAnswers() {
			return userAnswers;
		}

		public void setUserAnswers(List<String> userAnswers) {
			this.userAnswers = userAnswers;
		}

		@Override
		public String toString() {
			return "SubmittedAns [id=" + id + ", userId=" + userId + ", subjectId=" + subjectId + ", totalMcqQuestions="
					+ totalMcqQuestions + ", totalCorrectAnswers=" + totalCorrectAnswers + ", mcqIds=" + mcqIds
					+ ", userAnswers=" + userAnswers + "]";
		}

}
