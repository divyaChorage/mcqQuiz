package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Impl.McqImpl;
import com.example.demo.entity.Mcq;
import com.example.demo.entity.Subjects;
import com.example.demo.repositieries.SubjectRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class McqController {

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    McqImpl mcqImpl;

    @PostMapping("addMcqQuiz/{subjectId}")
    public ResponseEntity<Mcq> addMCQ(@PathVariable int subjectId, @RequestBody Mcq mcq) {
        Mcq savedMCQ = mcqImpl.addMCQToSubject(subjectId, mcq);
        return ResponseEntity.ok(savedMCQ);
    }

    @GetMapping("getAllMcqs/{subjectId}")
    public ResponseEntity<List<Mcq>> getMCQs(@PathVariable int subjectId) {
        List<Mcq> mcqs = mcqImpl.getMCQsBySubjectId(subjectId);
        System.out.println("gettingmcqs-----------"+mcqs);
        return ResponseEntity.ok(mcqs);
    }
    
   
    
    @DeleteMapping("deleteQuiz/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable("id") int id) {
        try {
            int result = mcqImpl.deleteMcq(id); // Call deleteMcq from the service layer
            
            if (result == 1) {
                return ResponseEntity.ok("Quiz deleted successfully"); // Successfully deleted
            } else if (result == -1) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quiz not found"); // Quiz not found
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting quiz"); // Internal error
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting quiz: " + e.getMessage());
        }
    }
    
    
    @GetMapping("getAllSubjects/{userId}")
    public ResponseEntity<List<Subjects>> getAllsub(@PathVariable int userId) {
        List<Subjects> mcqs = mcqImpl.getSubjectsByUserId(userId);
        System.out.println("gettingmcqs-----------"+mcqs);
        return ResponseEntity.ok(mcqs);
    }

    
    

}
