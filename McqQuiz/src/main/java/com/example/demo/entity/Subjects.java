package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Subjects {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

	String subject;
	
	@ManyToOne
	@JoinColumn(name = "login_id")
	@JsonBackReference
	private Login login;

	    public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	    
	    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Mcq> mcqList;

		public Subjects(Long id, String subject, Login login, List<Mcq> mcqList) {
			super();
			this.id = id;
			this.subject = subject;
			this.login = login;
			this.mcqList = mcqList;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public Login getLogin() {
			return login;
		}

		public void setLogin(Login login) {
			this.login = login;
		}

		public List<Mcq> getMcqList() {
			return mcqList;
		}

		public void setMcqList(List<Mcq> mcqList) {
			this.mcqList = mcqList;
		}

		@Override
		public String toString() {
		    return "Subjects [id=" + id 
		            + ", subject=" + subject 
		            + ", loginId=" + (login != null ? login.getId() : "null") 
		            + ", mcqCount=" + (mcqList != null ? mcqList.size() : "0") 
		            + "]";
		}



  
		
		
	
}
