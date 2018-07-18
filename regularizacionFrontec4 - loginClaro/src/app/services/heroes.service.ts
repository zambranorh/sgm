import { Injectable } from '@angular/core';
import { Http, Headers } from "@angular/http";
import { Heroe } from "../interfaces/heroe.interface";
import 'rxjs/Rx';

@Injectable()
export class HeroesService {

  //heroesURL:string = "http://localhost:8082/v1/item";
  heroesURL:string = "http://localhost:8083/regula/sale";
  heroeURL:string = "http://localhost:8083/regula/sale";
  saleURL:string = "http://localhost:8083/regula/sale";

  flagDelete:boolean = true;

  constructor( private http:Http ) { }

  nuevoHeroe( heroe:Heroe ){


 //   this.http._defaultOptions.headers.append('Authorization', 'token');
   // this.http.headers.common = {};
    let body = JSON.stringify( heroe );
    let headers = new Headers({
      'Accept':'application/json',
      'Content-Type':'application/json',
      'Access-Control-Allow-Origin':'*'      
    });

/*    Access-Control-Allow-Origin','*');
    res.header('Access-Control-Allow-Headers','Content-Type');
    res.header('Access-Control-Allow-Methods','GET','POST','PUT','DELETE','OPTIONS' */

   // let htmls = this.http;    

    console.log("URL ANTES POST: " + this.heroesURL);
    console.log("body ANTES POST: " + body);
    return this.http.post(  this.heroesURL, body, { headers }  )
          .map( res=>{
            console.log(res.json());
            //return res.json();
          });
  }

  actualizarHeroe( heroe:Heroe, key:string ){

    let body = JSON.stringify( heroe );
    let headers = new Headers({
      'Content-Type':'application/json'
    });

    let url = `${ this.heroeURL }/${ key }`;

    return this.http.put(  url , body, { headers }  )
          .map( res=>{
            console.log(res.json());
            return res.json();
          })
  }

  getHeroe( key$:string ){

    let url = `${ this.heroeURL }/${ key$ }`;
    return this.http.get( url )
      .map( res=>res.json() );

  }

  getHeroes( ){

    /*return this.http.get( this.heroesURL + "/all")
      .map( res=>res.json() ); */
      return this.http.get( this.heroesURL + "/all")
      .map( res=>res.json() );

  }

  borrarHeroe( key:string){

    let url = `${  this.heroeURL  }/${ key }`;
    return this.http.delete( url )
        .map( res =>{res;
           // console.log(res);
        });

  }

  getSales( ){
      return this.http.get( this.saleURL + "/all")
      .map( res=>res.json() );

  }


}
