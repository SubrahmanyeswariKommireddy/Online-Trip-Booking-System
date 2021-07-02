import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusViewComponent } from './bus-view/bus-view.component';
import { SearchBusesComponent } from './bus/search-buses/search-buses.component';
import { DefaultHomepageComponent } from './home/default-homepage/default-homepage.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:'',component:DefaultHomepageComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'search',component:SearchBusesComponent},
  {path:'viewSeats',component:BusViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
