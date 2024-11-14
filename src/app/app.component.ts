import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Autoplant';
  url:string='http://localhost:9090/';
  

  showDashboard:number=0;
  userId:number=0;

  user:any
  showLoginForm:number=0;

  constructor(public http:HttpClient){
  }


  username:string='';
  email:string=''
  password:number=0;
  showLoginform:number=0;
  register() {
    let url = this.url + 'saveUser';
    let obj = {
      username: this.username,
      email: this.email,
      password: this.password 
    };
  
    console.log(obj);
    this.http.post(url, obj).subscribe((data) => {
      console.log(data);
      if (data == -2) {
        window.alert("Registration done");
      } else if (data == -1) {
        window.alert("Something is wrong in DB");
      } else {
        window.alert("Registration done");
      }
    });
  }

  navigate:number=0;
  login() {
    let url = this.url+'getLoginUser/'+this.email+'/'+this.password
    
    this.http.get(url).subscribe((data: any) => {
      if (data) {
        console.log(data)
        this.navigate = data.password === 1 ? 1 : 2;
        this.showLoginForm=1;
        this.userId=data.id;
        console.log(this.userId)
      } else {
        window.alert("Invalid credentials");
      }
    });
  }


  alreadyLogged()
  {
    this.showLoginForm=2;
  }
  
}
