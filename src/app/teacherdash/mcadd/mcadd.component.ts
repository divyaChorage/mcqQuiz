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
    this.http.delete(url).subscribe((data)=>
    {
      if(data===1)
      {
        this.mcqs = this.mcqs.filter(mcq => mcq.id !== id); 
window.alert("delete succfullly")
      }
      else if(data===-1)
      {
window.alert("quiz not  found")
      } else if(data===0)
        {
          window.alert("somethinf is wrong")

        }
        else
        {
          window.alert("somethinf is wrong")
        }

    })
  }



  showUpdateForm:Boolean=false
  currentMcqId:number=-1;

  editQuiz(mcq: any) {
    this.showUpdateForm = true;
    this.currentMcqId = mcq.id;
    this.question = mcq.question;
    this.optionA = mcq.optionA;
    this.optionB = mcq.optionB;
    this.optionC = mcq.optionC;
    this.optionD = mcq.optionD;
    this.correctAnswer = mcq.correctAnswer;
  }

  updateQuiz() {
    const updatedMcq = {
      id: this.currentMcqId,
      question: this.question,
      optionA: this.optionA,
      optionB: this.optionB,
      optionC: this.optionC,
      optionD: this.optionD,
      correctAnswer: this.correctAnswer
    };

    console.log(updatedMcq,"----updayedMcq")
    let url = this.app.url + 'updateQuiz' + '/' +this.currentMcqId;
  
    this.http.put(url, updatedMcq).subscribe((data: any) => {
      const index = this.mcqs.findIndex(mcq => mcq.id === this.currentMcqId);
      if (index > -1) {
        this.mcqs[index] = updatedMcq; // Update the MCQ in the list
      }
      this.resetForm();
    });
  }
  
  cancelUpdate() {
    this.resetForm();
  }
  resetForm() {
    this.question = '';
    this.optionA = '';
    this.optionB = '';
    this.optionC = '';
    this.optionD = '';
    this.correctAnswer = '';
    this.showUpdateForm = false;
    this.currentMcqId = -1;
  }

}
