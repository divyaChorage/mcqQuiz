package com.example.demo.repositieries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Subjects;

public interface SubjectRepo  extends JpaRepository<Subjects, Integer>{

    List<Subjects> findByLoginId(int loginId);
    
    @Query("SELECT s FROM Subjects s")
    List<Subjects> getAllSubjects();

   

}
