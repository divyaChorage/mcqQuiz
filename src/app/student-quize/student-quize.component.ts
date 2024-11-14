import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-student-quize',
  templateUrl: './student-quize.component.html',
  styleUrls: ['./student-quize.component.css']
})
export class StudentQuizeComponent {

  constructor(public http:HttpClient,public app:AppComponent){
    console.log(this.app.userId,"gettimng userId")
   
  
  }


  ngOnInit(): void {
    this.loadSubjects();
  }
  
  quizzes: any[] = [];  // Array to store subjects
  subject: string = '';
  

  // Method to load existing subjects
  loadSubjects() {
    const url = this.app.url + 'getAllSub';
    this.http.get<any[]>(url).subscribe((data) => {
      this.quizzes = data;
      console.log("-----subjects for quiz-------",data);
   
    });
  }


  opneQuizes:number=0;
  subjectId:number=0;
  gettingQuizForThisSub(id:number)
  {
    this.subjectId=id
    console.log("id fro getting quisz sub----",id)
this.opneQuizes=1;
  }

}
