import { Component, OnInit} from '@angular/core';
import { NgForm } from '@angular/forms';
import {Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { AlertService } from '../../services/alert.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  class:string = '';
 
  constructor(private router: Router,
              private authService:AuthService,
              private alertService:AlertService) { }

  ngOnInit() {
    console.log(localStorage.getItem("username"));
  }

  login(formulario:NgForm){
    console.log(formulario);
    
    console.log(formulario.value);
   if(formulario.status=="INVALID"){
      this.class='was-validated';
    }else{
      console.log(formulario.value.username);

      this.authService.login(formulario.value.username,formulario.value.password)
      .subscribe(response=>{
          if(response){
            console.log(response);
            //localStorage.setItem("username",formulario.value.username);
            this.router.navigate(['/heroes']);
          }
          else{
            console.log("fracaso");
              
          } 
      },
      error=> this.alertService.success('USUARIO NO VALIDO!',true));
    }
  }
}
