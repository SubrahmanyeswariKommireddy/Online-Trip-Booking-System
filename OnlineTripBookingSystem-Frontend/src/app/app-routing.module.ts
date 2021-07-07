import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomepageComponent } from './home/admin-homepage/admin-homepage.component';
import { BusViewComponent } from './bus-view/bus-view.component';
import { BusListComponent } from './bus/bus-list/bus-list.component';
import { DefaultHomepageComponent } from './home/default-homepage/default-homepage.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AddBusComponent } from './bus/add-bus/add-bus.component';
import { AddRouteComponent } from './route/add-route/add-route.component';
import { UpdateBusComponent } from './bus/update-bus/update-bus.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { AddTravelComponent } from './travel/add-travel/add-travel.component';
import { AddBookingComponent } from './booking/add-booking/add-booking.component';
import { UpdateAdminComponent } from './admin/update-admin/update-admin.component';
import { ProfileComponent } from './profile/profile.component';
import { Payment } from './models/Payment';
import { AddPaymentComponent } from './payment/add-payment/add-payment.component';

const routes: Routes = [
  {path:'',component:DefaultHomepageComponent},
  {path:'admin',component:AdminHomepageComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'viewSeats',component:BusViewComponent},
  {path:'busList',component:BusListComponent},
  {path:'addBus',component:AddBusComponent},
  {path:'addRoute',component:AddRouteComponent},
  {path:'updateCustomer/:id',component:UpdateCustomerComponent},
  {path:'updateAdmin/:id',component:UpdateAdminComponent},
  {path:'addTravel',component:AddTravelComponent},
  {path:'updateBus/:id',component:UpdateBusComponent},
  {path:'booking',component:AddBookingComponent},
  {path:'profile',component:ProfileComponent},
  {path:'payment',component:AddPaymentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

