package com.example.demo.Service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Impl.McqImpl;

import com.example.demo.entity.Mcq;
import com.example.demo.entity.ReviewTestDTO;
import com.example.demo.entity.Subjects;
import com.example.demo.entity.SubmittedAns;

import com.example.demo.repositieries.LoginRepo;
import com.example.demo.repositieries.McqRepo;
import com.example.demo.repositieries.SubjectRepo;
import com.example.demo.repositieries.SubmittedAnsRepo;


@Service
public class McqService implements McqImpl{
	@Autowired
    private LoginRepo loginRepo;
    
    
	@Autowired
	SubmittedAnsRepo submittedAnsRepo;
    
    @Autowired 
    SubjectRepo subjectRepo;
    
    @Autowired
    McqRepo mcqRepo;

	
	@Override
	public Mcq addMCQToSubject(int subjectId, Mcq mcq) {
		Subjects subject = subjectRepo.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        mcq.setSubject(subject);
        return mcqRepo.save(mcq);
	}

	@Override
	public List<Mcq> getMCQsBySubjectId(int subjectId) {
		System.out.println("getting subj id  fro  getting all mcqs---"+subjectId);
		 List<Mcq>  list=mcqRepo.findBySubjectId(subjectId);
		 System.out.println("getting list  of mcqs fromdata-----"+list);
		 return list;
	}

	@Override
	public int deleteMcq(int mcqId) {
	    // Attempt to find the MCQ by its ID
	    Optional<Mcq> optionalMcq = mcqRepo.findById(mcqId);
	    
	    // Check if the MCQ exists
	    if (optionalMcq.isPresent()) {
	        mcqRepo.deleteById(mcqId);  // Delete the MCQ from the database
	        return 1;  // Return 1 to indicate that the MCQ was successfully deleted
	    } else {
	        return -1;  // Return -1 if the MCQ with the given ID was not found
	    }
	}

	@Override
	public List<Subjects> getAllSubjects() {
	List<Subjects>  list=subjectRepo.getAllSubjects();
	 System.out.println("getting sub  of  fromdata-----"+list);

	return list;
	}

	
	
	@Override
	 public SubmittedAns submitQuiz(int userId, int subjectId, List<Integer> mcqIds, List<String> userAnswers) {
	        int totalCorrectAnswers = 0;

	        for (int i = 0; i < mcqIds.size(); i++) {
	            Mcq mcq = mcqRepo.findById(mcqIds.get(i)).orElse(null);
	            if (mcq != null && mcq.getCorrectAnswer().equals(userAnswers.get(i))) {
	                totalCorrectAnswers++;
	            }
	        }

	        SubmittedAns submittedAns = new SubmittedAns(userId, subjectId, mcqIds, userAnswers, mcqIds.size(), totalCorrectAnswers);
	        return submittedAnsRepo.save(submittedAns);
	    }

	@Override
	public List<SubmittedAns> getViewScore(int userId, int subjectId) {
	    return submittedAnsRepo.findByUserIdAndSubjectId(userId, subjectId);
	}

	@Override
	public List<Subjects> getSubjectsByUserId(int loginId) {
		 List<Subjects> sub=subjectRepo.findByLoginId(loginId);
  
  return sub;
	}
	
	@Override
	public List<SubmittedAns> getReviewTest(int subjectId, int userId) {
	    // Logic to retrieve submitted answers along with the question and correct answers
	    return submittedAnsRepo.findByUserIdAndSubjectId(userId, subjectId);
	}

	
	
	@Override
	public List<Mcq> getMcqsByIds(int subjectId) {
        System.out.println(" getting mcqs ids  to return ans in servce----"+subjectId);


	    return mcqRepo.getAllMcqBySubjectId(subjectId);
	}
	
	

	@Override
	public Mcq updateMcqBycqId(Mcq mcq,int mcqId) {
		System.out.println("for updating mcq is ----"+mcq+"---id s --"+mcqId);
	Mcq mcqs=mcqRepo.findById(mcqId).get();
	System.out.println("for updating mcq is fro db ----"+mcqs);

	 mcqs.setQuestion(mcq.getQuestion());
	 mcqs.setOptionA(mcq.getOptionA());
	 mcqs.setOptionB(mcq.getOptionB());
	 mcqs.setOptionC(mcq.getOptionC());
	 mcqs.setOptionD(mcq.getOptionD());

  mcqs.setCorrectAnswer(mcq.getCorrectAnswer());
  mcqRepo.save(mcqs);
	 
		return null;
	}

	@Override
	public int deleteSubject(int subjectId) {
		 int count= mcqRepo.countBySubject_id(subjectId);
		 System.out.println("count for delet sub---"+count+"---subjectID---"+subjectId);
		 if(count==0)
		 {
			 subjectRepo.deleteById(subjectId);
			 return 1;
		 }
		 else
		 {
			 return -1;
		 }
	}

	



	

	
	

}
