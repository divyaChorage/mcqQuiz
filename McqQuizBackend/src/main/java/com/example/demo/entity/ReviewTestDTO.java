package com.example.demo.entity;



public class ReviewTestDTO {
    private String question;
    private String correctAnswer;
    private String userAnswer;

    public ReviewTestDTO(String question, String correctAnswer, String userAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
    }

    // Getters and setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

	@Override
	public String toString() {
		return "ReviewTestDTO [question=" + question + ", correctAnswer=" + correctAnswer + ", userAnswer=" + userAnswer
				+ "]";
	}
}
