package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private Long password;

    // Default Constructor
 // In Login entity
    @OneToMany(mappedBy = "login")
    @JsonManagedReference
    private List<Subjects> subjects;
    
    public Login() {
    }


	public Login(int id, String username, String email, Long password, List<Subjects> subjects) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.subjects = subjects;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getPassword() {
		return password;
	}


	public void setPassword(Long password) {
		this.password = password;
	}


	public List<Subjects> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}


	@Override
	public String toString() {
	    return "Login [id=" + id 
	            + ", username=" + username 
	            + ", email=" + email 
	            + ", password=" + password 
	            + ", subjectCount=" + (subjects != null ? subjects.size() : "0") 
	            + "]";
	}

   

 
}
