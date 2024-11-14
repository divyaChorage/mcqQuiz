import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { TeacherdashComponent } from '../teacherdash.component';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-mcadd',
  templateUrl: './mcadd.component.html',
  styleUrls: ['./mcadd.component.css']
})
export class McaddComponent {


  constructor(public http:HttpClient,public tchDash:TeacherdashComponent,public app:AppComponent){
  }

  mcqs:any[] = [];
 
  ngOnInit()
  {
    this.loadMcq();
  }

  loadMcq() {
    const url = this.app.url + 'getAllMcqs'+'/' +this.tchDash.quizId;
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
  addQuizes()
  {
let obj=
{
   question:this.question,
   optionA:this.optionA,


 optionB:this.optionB,
    optionC:this.optionC,
   optionD:this.optionD,
   correctAnswer:this.correctAnswer

}
console.log(" quiz id for  adding mcq= ",this.tchDash.quizId)



let url=this.app.url+'addMcqQuiz'+'/'+this.tchDash.quizId;
this.http.post(url,obj).subscribe((data)=>
{
  console.log("getting all mmcq = ",data)
this.loadMcq();
})



  }



  deleteQuiz(id: number) {
    // Define the URL to send the DELETE request to the backend
    let url = this.app.url + 'deleteQuiz' + '/' + id;
  
    // Make the DELETE request to the backend
    this.http.delete(url).subscribe(
      (data) => {
        // Log the data (optional, for debugging)
        console.log("Quiz deleted, response: ", data);
        
        // After successful deletion, update the UI by removing the quiz from the list
        this.mcqs = this.mcqs.filter(mcq => mcq.id !== id); // Remove the quiz from the array
  
        // Optionally, you can reload the list of quizzes from the server
        // this.loadMcq();
      },
      (error) => {
        console.error("Error deleting quiz: ", error); // Handle error case
      }
    );
  }
  
}
