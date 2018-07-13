import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

import { AuthService } from './auth.service';

@Injectable()
export class AuthGuardService implements CanActivate {

  constructor(
    private auth:AuthService,
    private router:Router
  ) { }

  canActivate(){

    if( this.auth.isAuthenticated() ){
      console.log("El guard paso!");
      return true;
    }else{
      console.error("Bloqueado por el Guard");
      this.router.navigate(['/home']);
      return false;
    }

  }

}
