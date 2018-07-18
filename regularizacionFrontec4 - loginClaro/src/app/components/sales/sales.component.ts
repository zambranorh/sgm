import { Component, OnInit } from '@angular/core';
import { HeroesService } from "../../services/heroes.service";
import { Router, ActivatedRoute } from "@angular/router";
// import { AuthService } from "../../services/auth.service";


@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styles: []
})
export class SalesComponent implements OnInit {

  heroes:any[] = [];
  loading:boolean = true;

  constructor(private _heroesService:HeroesService,
              private router:Router,
              private route:ActivatedRoute) {

  /*  if(!(this._authService.isAuthenticated()))
      this._authService.login();*/

    this._heroesService.getSales()
        .subscribe( data =>{
          this.heroes = data;
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

}
