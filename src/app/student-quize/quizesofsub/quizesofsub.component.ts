import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { TeacherdashComponent } from 'src/app/teacherdash/teacherdash.component';
import { StudentQuizeComponent } from '../student-quize.component';

@Component({
  selector: 'app-quizesofsub',
  templateUrl: './quizesofsub.component.html',
  styleUrls: ['./quizesofsub.component.css']
})
export class QuizesofsubComponent {


  constructor(public http:HttpClient,public stdQuiz:StudentQuizeComponent,public app:AppComponent){
  }

  mcqs:any[] = [];
 
  ngOnInit()
  {
    this.loadMcq();
  }

  loadMcq() {
    const url = this.app.url + 'getAllMcqs'+'/' +this.stdQuiz.subjectId;
    this.http.get<any[]>(url).subscribe((data) => {
      console.log(data," in loding,cqs")
      this.mcqs = data;
    });
  }
   
    question:string='';
    optionA:string='';


  optionB:string='';
    optionC:string='';
    optionD:string='';
    correctAnswer:string='';

    selectedAnswers: { [questionId: number]: string } = {}; // Store selected answers by question ID

  //   submitAnswers() {
  //     const answers = this.mcqs.map((mcq) => ({
  //       questionId: mcq.id,
  //       selectedAnswer: this.selectedAnswers[mcq.id] || '' // Default to empty if not selected
  //     }));
  // console.log(answers);
  // let url=this.app.url + 'submitAnswers'
  //     this.http.post(url, answers).subscribe((response) => {
  //       console.log('Answers submitted:', response);
  //     });
  //   }


  public attempts: any[] = [];
  public numberOfAttempts: number = 0;
  public totalMcqQuestions: number = 0;
  public yourScore: number = 0;
      showViewScore:number=0;
  viewScore() {

this.showViewScore=1;
    let url = this.app.url + 'viewScore/' + this.app.userId + '/' + this.stdQuiz.subjectId;
    this.http.get<any[]>(url).subscribe((response) => {
      if (response && response.length > 0) {
   
  
        // Total number of attempts
        this.numberOfAttempts = response.length;
  
        // Display the total questions and correct answers from the first attempt
        this.totalMcqQuestions = response[0].totalMcqQuestions;
        this.yourScore = response[0].totalCorrectAnswers;
      } else {
        console.log('No attempts found.');
      }
    });
  }
  

    reviewTest()
    {
      let url=this.app.url + 'reviewTest'+'/'+this.stdQuiz.subjectId+'/'+this.app.userId
      this.http.get(url).subscribe((response) => {
        console.log('your score:', response);
      });
    }



    submitAnswers() {
      const mcqIds = this.mcqs.map(mcq => mcq.id);
      const userAnswers = mcqIds.map(id => this.selectedAnswers[id] || '');
  
      const submissionRequest = {
        userId: this.app.userId, // assume the logged-in user's ID
        subjectId: +this.stdQuiz.subjectId, // the ID of the subject
        mcqIds,
        userAnswers
      };
      let url=this.app.url + 'submitQuiz';

      this.http.post(url,submissionRequest).subscribe((response) => {
        console.log('Score:', response);
        alert(`your test s  submitted`);
      });
}

}

