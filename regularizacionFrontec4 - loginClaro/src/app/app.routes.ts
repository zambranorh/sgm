import { RouterModule, Routes } from '@angular/router';
import { HeroesComponent } from "./components/heroes/heroes.component";
import { HeroeComponent } from "./components/heroes/heroe.component";
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from "./components/login/login.component";
import { SalesComponent } from "./components/sales/sales.component";
//import { PreciosComponent } from "./components/precios/precios.component";
//import { ProtegidaComponent } from "./components/protegida/protegida.component";
//import { AuthGuardService } from './services/auth-guard.service';


const APP_ROUTES: Routes = [
  { path: 'heroes', component: HeroesComponent },
  { path: 'heroe/:id', component: HeroeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'sales', component: SalesComponent },
 /* { path: 'precios', component: PreciosComponent },
  { 
  	path: 'protegida', 
  	component: ProtegidaComponent,
  	canActivate: [ AuthGuardService ]
  }, */
  { path: '**', pathMatch: 'full', redirectTo: 'login' }
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
