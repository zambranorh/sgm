import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { APP_ROUTING } from "./app.routes";

// servicios
import { HeroesService } from "./services/heroes.service";
import { AuthenticationService } from './services/authentication.service';
import { AlertService } from './services/alert.service';
import { AuthService } from "./services/auth.service";
//import { AuthGuardService } from "./services/auth-guard.service";

// Pipes
//import { KeysPipe } from './pipes/keys.pipe';

import { AppComponent } from './app.component';
import { HeroesComponent } from './components/heroes/heroes.component';
import { HeroeComponent } from './components/heroes/heroe.component';
//import { NavbarComponent } from './components/navbar/navbar.component';
//import { HomeComponent } from './components/home/home.component';
//import { PreciosComponent } from './components/precios/precios.component';
//import { ProtegidaComponent } from './components/protegida/protegida.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SalesComponent } from './components/sales/sales.component';

@NgModule({
  declarations: [
    AppComponent,
    HeroesComponent,
    HeroeComponent,
    HomeComponent,
    LoginComponent,
    SalesComponent
/*    NavbarComponent,
    HomeComponent,
    PreciosComponent,
    ProtegidaComponent*/
 //   KeysPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    APP_ROUTING
  ],
  providers: [
    HeroesService,
    AuthenticationService,
    AlertService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
