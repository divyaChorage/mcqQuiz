import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { StudentQuizeComponent } from './student-quize/student-quize.component';
import { TeacherdashComponent } from './teacherdash/teacherdash.component';
import { McaddComponent } from './teacherdash/mcadd/mcadd.component';
import { QuizesofsubComponent } from './student-quize/quizesofsub/quizesofsub.component';
import { Routes } from '@angular/router';


const routes: Routes = [
  { path: 'student-quiz', component: StudentQuizeComponent },
  { path: 'app-teacherdash', component: TeacherdashComponent },
  { path: 'app-mcadd', component: McaddComponent },
  { path: 'app-quizesofsub', component: QuizesofsubComponent },
  { path: '', redirectTo: '/student-quiz', pathMatch: 'full' }, // Default route
  { path: '**', redirectTo: '/student-quiz' } // Wildcard route for invalid paths
];
@NgModule({
  declarations: [
    AppComponent,
    StudentQuizeComponent,
    TeacherdashComponent,
    McaddComponent,
    QuizesofsubComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
