import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-teacherdash',
  templateUrl: './teacherdash.component.html',
  styleUrls: ['./teacherdash.component.css']
})
export class TeacherdashComponent {

  constructor(public http:HttpClient,public app:AppComponent){
    console.log(this.app.userId,"gettimng userId")
    if (this.app.userId) {
    let url = this.app.url + 'getOneUserById/' + this.app.userId;
      this.http.get(url).subscribe((data) => {
        console.log(data);
        this.app.user = data;
        
        console.log(this.app.user,"this user")
      }, (error) => {
        console.error("Error fetching user data:", error);
      });
    } else {
      console.error("No userId found. User not logged in.");
    }
  
  }

  ngOnInit(): void {
    this.loadSubjects();
  }
  
  quizzes: any[] = [];  // Array to store subjects
  subject: string = '';
  

  // Method to load existing subjects
  loadSubjects() {
    const url = this.app.url + 'getAllSubjects/' + this.app.userId;
    this.http.get<any[]>(url).subscribe((data) => {
      this.quizzes = data;
      console.log("-----subjects for quiz-------",data);
   
    });
  }


addSub() {
  const obj = { subject: this.subject };
  const url = this.app.url + 'addSub/' + this.app.userId;
  this.http.post(url, obj).subscribe(
    (data) => {
      this.loadSubjects();  // Reload the subjects after adding
      this.subject = '';    // Clear the input field
    },
    (error) => {
      console.error("Error adding subject:", error);
    }
  );
}

 
  deleteQuiz(id: number) {
    console.log("Deleting quiz with ID:", id);
 
  }



  showMcqAddForm:number=0;
  quizId:number=0;
  addQuize(quizId:number) {
    this.showMcqAddForm=1;
    this.quizId=quizId;
    console.log("Editing quiz:", quizId);
    // Implement logic for editing the quiz
  }



  deleteSubject(id:number)
{
  const url = this.app.url + 'deleteSubjById/' + id;
  this.http.delete(url).subscribe((data) => {
    console.log("-----subjects for quiz-------",data);

    if(data==1)
    {
      this.quizzes = this.quizzes.filter((data)=>data.id!=id);
      window.alert("delete subject")
    }
    else{
      window.alert("subject has  quizes  so can no t be deleeted")
    }
    
 
  });
}

}
