import { Component, OnInit } from '@angular/core';
import { HeroesService } from "../../services/heroes.service";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthService } from "../../services/auth.service";


@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styles: []
})
export class HeroesComponent implements OnInit {

  heroes:any[] = [];
  loading:boolean = true;

  constructor(private _heroesService:HeroesService,
              private router:Router,
              private route:ActivatedRoute,
              private authService:AuthService) {

  /*  if(!(this._authService.isAuthenticated()))
      this._authService.login();*/

    this._heroesService.getHeroes()
        .subscribe( data =>{
          this.heroes = data;
          console.log(data);
          this.loading = false;
        })
    
  }

  ngOnInit() {
  }

  borraHeroe( key:string){

    this._heroesService.borrarHeroe(key)
        .subscribe( respuesta=>{
          if( respuesta ){
            console.error(respuesta);
          }else{
            //todo bien
            this.router.navigate(['/heroe'])
          }
        })

  }

  logout(){
    this.authService.logout();
  }

}
