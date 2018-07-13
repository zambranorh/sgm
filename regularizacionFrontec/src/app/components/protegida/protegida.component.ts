import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';


@Component({
  selector: 'app-protegida',
  templateUrl: './protegida.component.html',
  styles: []
})
export class ProtegidaComponent implements OnInit {

  profile: any;
  constructor( private auth:AuthService ) {
  }

/*  constructor( private auth:AuthService ) {
    this.perfil = this.auth.getProfile();
    console.log( this.perfil );
  }
  */

  ngOnInit() {
      if (this.auth.userProfile) {
        this.profile = this.auth.userProfile;
        console.log(this.profile);
      } else {
        this.auth.getProfile((err, profile) => {
          this.profile = profile;
        });
        console.log(this.profile);
      }
  }

}
