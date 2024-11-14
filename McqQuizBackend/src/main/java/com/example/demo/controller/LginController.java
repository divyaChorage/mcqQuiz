package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Impl.LoginImpl;
import com.example.demo.entity.Login;
import com.example.demo.entity.Subjects;
import com.example.demo.repositieries.LoginRepo;
import com.example.demo.repositieries.SubjectRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LginController {

    @Autowired
    private LoginImpl loginImpl;
    
    @Autowired
    SubjectRepo subjectRepo;

@Autowired
LoginRepo loginRepo;


    @PostMapping("saveUser")
    public int saveUsers(@RequestBody Login user) {
    	System.out.println(user);
        int result = loginImpl.saveUser(user);
        return (result == 0) ? 2 : -1; // Return 2 for success, -1 for failure
    }
    
    @GetMapping("getLoginUser/{email}/{password}")
    public Login loggin(@PathVariable String email, @PathVariable Long password) {
    	System.out.println(email+" "+password);
        return loginImpl.loginUser(email, password);
    }
    
    
    @GetMapping("getOneUserById/{id}")
    public Login getOneUserById(@PathVariable int id) {
        return loginImpl.getOneUser(id);
    }
    
    @PostMapping("addSub/{loginId}")
    public ResponseEntity<?> addSubject(@PathVariable int loginId, @RequestBody Subjects subject) {
        Login login = loginRepo.findById(loginId).orElse(null);
        
        if (login == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Set the login for the subject and save it
        subject.setLogin(login);
        Subjects savedSubject = subjectRepo.save(subject);

        return ResponseEntity.ok(savedSubject);
    }

	  
}
