package com.example.demo.entity;

import java.util.List;

public class QuizSubmissionRequest {
	private int userId;
    private int subjectId;
    private List<Integer> mcqIds;
    private List<String> userAnswers;
	public QuizSubmissionRequest(int userId, int subjectId, List<Integer> mcqIds, List<String> userAnswers) {
		super();
		this.userId = userId;
		this.subjectId = subjectId;
		this.mcqIds = mcqIds;
		this.userAnswers = userAnswers;
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
		return "QuizSubmissionRequest [userId=" + userId + ", subjectId=" + subjectId + ", mcqIds=" + mcqIds
				+ ", userAnswers=" + userAnswers + "]";
	}
    
    
    
}
