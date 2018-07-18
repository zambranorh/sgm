import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {

    heroeURL:string = "http://localhost:8082/v1/login";
    constructor(private http: Http) { }

    login(username: string, password: string) {

        let url = `${ this.heroeURL }/${ username }`;
        console.log('ES SERVIDOR:' + username);
        console.log('ES SERVIDOR:' + password);
           
        return this.http.get( url )
              .map( res=>{ 
              console.log(res.json());
              return res.json();
               });

        

       /* return this.http.post<any>('/api/authenticate', { username: username, password: password })
            .map(user => {
                // login successful if there's a jwt token in the response
                if (user) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                return user;
            }); */
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}