import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomepageComponent } from './home/admin-homepage/admin-homepage.component';
import { BusViewComponent } from './bus-view/bus-view.component';
import { BusListComponent } from './bus/bus-list/bus-list.component';
import { SearchBusesComponent } from './bus/search-buses/search-buses.component';
import { DefaultHomepageComponent } from './home/default-homepage/default-homepage.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:'',component:DefaultHomepageComponent},
  {path:'home',component:AdminHomepageComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'search',component:SearchBusesComponent},
  {path:'viewSeats',component:BusViewComponent},
  {path:'busList',component:BusListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
