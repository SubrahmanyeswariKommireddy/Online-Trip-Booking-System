import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomepageComponent } from './home/admin-homepage/admin-homepage.component';
import { BusViewComponent } from './bus-view/bus-view.component';
import { BusListComponent } from './bus/bus-list/bus-list.component';
import { SearchBusesComponent } from './bus/search-buses/search-buses.component';
import { DefaultHomepageComponent } from './home/default-homepage/default-homepage.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AddBusComponent } from './bus/add-bus/add-bus.component';
import { BusComponentComponent } from './bus/bus-component/bus-component.component';
import { AddRouteComponent } from './route/add-route/add-route.component';
import { UpdateBusComponent } from './bus/update-bus/update-bus.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { AddTravelComponent } from './travel/add-travel/add-travel.component';
import { AddBookingComponent } from './booking/add-booking/add-booking.component';

const routes: Routes = [
  {path:'',component:DefaultHomepageComponent},
  {path:'admin',component:AdminHomepageComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'search',component:SearchBusesComponent},
  {path:'viewSeats',component:BusViewComponent},
  {path:'busList',component:BusListComponent},
  {path:'getBus',component:BusComponentComponent},
  {path:'addBus',component:AddBusComponent},
  {path:'addRoute',component:AddRouteComponent},
  {path:'updateCustomer',component:UpdateCustomerComponent},
  {path:'addTravel',component:AddTravelComponent},
  {path:'updateBus/:id',component:UpdateBusComponent},
  {path:'booking',component:AddBookingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

