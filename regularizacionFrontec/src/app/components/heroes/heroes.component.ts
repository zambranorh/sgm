import { Component, OnInit } from '@angular/core';
import { HeroesService } from "../../services/heroes.service";
import { Router, ActivatedRoute } from "@angular/router";


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
              private route:ActivatedRoute) {


    this._heroesService.getHeroes()
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
