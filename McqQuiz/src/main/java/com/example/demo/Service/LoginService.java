// LoginService.java
package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Impl.LoginImpl;

import com.example.demo.entity.Login;
import com.example.demo.entity.Subjects;
import com.example.demo.repositieries.LoginRepo;
import com.example.demo.repositieries.SubjectRepo;

@Service
public class LoginService implements LoginImpl {

    @Autowired
    private LoginRepo loginRepo;
    
    
    
    @Autowired 
    SubjectRepo subjectRepo;

    @Override
    public int saveUser(Login data) {
        System.out.println(data);
        Login savedUser = loginRepo.save(data);
        return (savedUser != null) ? 0 : -1; // Return 0 if saved successfully, -1 otherwise
    }

    
    @Override
    public Login getOneUser(int id) {
        System.out.println("Fetching user with ID: " + id);
        return loginRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    
    
    @Override
    public Login loginUser(String email, Long password) {
        Login user = loginRepo.findByEmailAndPassword(email, password);
        if (user == null) {
            return null; // Return null if no user found
        }
        
        // Check email domain to determine role
        String emailDomain = email.split("@")[1];
        if (emailDomain.endsWith(".in") || emailDomain.equals("someprofessional.com")) {
            user.setPassword(1L); // Return 1 to indicate a teacher
        } else {
            user.setPassword(2L); // Return 2 to indicate a student
        }
        
        System.out.println(user);
        
        return user;
    }


    @Override
    public List<Subjects> getAllSubjectByUserId(int id) {
        return subjectRepo.findByLoginId(id);
    }
    
    @Override
	public Subjects saveEmp1(Subjects emp,int id) {
	  Subjects empl  =  subjectRepo.save(emp);
		return empl;
	}
}
