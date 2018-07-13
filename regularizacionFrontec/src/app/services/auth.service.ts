import { Injectable }      from '@angular/core';
//import { tokenNotExpired } from 'angular2-jwt';
import { Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import * as auth0 from 'auth0-js';


// Avoid name not found warnings
declare var Auth0Lock: any;
(window as any).global = window;

@Injectable()
export class AuthService {

  public userProfile:any;

  auth0 = new auth0.WebAuth({
    clientID: 'BZL7q2zysSb72Twb1OHVe1YX2ky6Uvka',
    domain: 'authregularizacion.auth0.com',
    responseType: 'token id_token',
    audience: 'https://authregularizacion.auth0.com/userinfo',
    redirectUri: 'http://localhost:4200/callback',
    scope: 'openid profile'
  });

  constructor(public router: Router) {}

  public login(): void {
    this.auth0.authorize();
  }

  public handleAuthentication(): void {
    this.auth0.parseHash((err, authResult) => {
      if (authResult && authResult.accessToken && authResult.idToken) {
        window.location.hash = '';
        this.setSession(authResult);
        this.router.navigate(['/heroes']);
      } else if (err) {
        this.router.navigate(['/heroes']);
        console.log(err);
      }
    });
  }

  private setSession(authResult): void {
    // Set the time that the Access Token will expire at
    const expiresAt = JSON.stringify((authResult.expiresIn * 1000) + new Date().getTime());
    localStorage.setItem('access_token', authResult.accessToken);
    localStorage.setItem('id_token', authResult.idToken);
    localStorage.setItem('expires_at', expiresAt);
  }

  public logout(): void {
    // Remove tokens and expiry time from localStorage
    localStorage.removeItem('access_token');
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
    // Go back to the home route
    this.router.navigate(['/']);
  }

  public isAuthenticated(): boolean {
    // Check whether the current time is past the
    // Access Token's expiry time
    const expiresAt = JSON.parse(localStorage.getItem('expires_at') || '{}');
    return new Date().getTime() < expiresAt;
  }

  public getProfile(cb): void {
    const accessToken = localStorage.getItem('access_token');
    if (!accessToken) {
      throw new Error('Access Token must exist to fetch profile');
    }

    const self = this;
    this.auth0.client.userInfo(accessToken, (err, profile) => {
      if (profile) {
        self.userProfile = profile;
      }
      cb(err, profile);
    });
  }

/*
  opciones:Object = {
    allowedConnections: ["Username-Password-Authentication","facebook","twitter","google-oauth2"],
    rememberLastLogin: false,
    socialButtonStyle: "small",
    theme: {"primaryColor":"#3A99D8"},
    languageDictionary: {"title":"AuthApp"},
    language: "es",
    additionalSignUpFields: [{
          name: "direccion",
          placeholder: "Ingrese su dirección",
          // The following properties are optional
          // icon: "https://example.com/assests/address_icon.png",
          validator: function(direccion) {
            return {
               valid: direccion.length >= 10,
               hint: "La dirección debe de ser mayor a 10 caracteres" // optional
            };
          }
        },
        {
          name: "nombre_completo",
          placeholder: "Ingrese su nombre"
        }]
  }


  // Configure Auth0
  lock = new Auth0Lock('LfPMsB9kyLyj0TDbXNXoSl9jWQR5cfEt', 'klerith.auth0.com',  this.opciones );

  // Perfil del usuario
  userProfile: Object;

  constructor( private router:Router) {
    // Add callback for lock `authenticated` event
    this.lock.on("authenticated", (authResult) => {
      localStorage.setItem('id_token', authResult.idToken);

      // Fetch profile information
      this.lock.getProfile(authResult.idToken, (error, profile) => {
        if (error) {
          // Handle error
          alert(error);
          return;
        }

        localStorage.setItem('profile', JSON.stringify(profile));
        this.userProfile = profile;
      });

    });
  }

  public getProfile(){
    if( this.authenticated() ){
      return JSON.parse(localStorage.getItem('profile'));
    }else{
      return {};
    }
  }

  public login() {
    // Call the show method to display the widget.
    this.lock.show();
  }

  public authenticated() {
    // Check if there's an unexpired JWT
    // This searches for an item in localStorage with key == 'id_token'
    return tokenNotExpired();
  }

  public logout() {
    // Remove token from localStorage
    this.router.navigate(['home']);
    localStorage.removeItem('id_token');
    localStorage.removeItem('profile');
  }
  */
}
