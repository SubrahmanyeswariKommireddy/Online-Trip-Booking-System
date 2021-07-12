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
import { AddPaymentComponent } from './payment/add-payment/add-payment.component';
import { AdminDetailsComponent } from './admin/admin-details/admin-details.component';
import { CustomerDetailsComponent } from './customer/customer-details/customer-details.component';
import { UpdatePasswordComponent } from './password/update-password/update-password.component';
import { TravelListComponent } from './travel/travel-list/travel-list.component';
import { AddFeedbackComponent } from './feedback/add-feedback/add-feedback.component';
import { AddBusBookingComponent } from './booking/add-bus-booking/add-bus-booking.component';
import { BookingListComponent } from './booking/booking-list/booking-list.component';
import { AdminBuslistComponent } from './admin/admin-buslist/admin-buslist/admin-buslist.component';
import { AuthGaurdService } from './shared/auth-gaurd.service';
import { NotFoundComponent } from './notFound/not-found/not-found.component';

const routes: Routes = [
  {path:'',component:DefaultHomepageComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},

  {path:'viewSeats',component:BusViewComponent,canActivate:[AuthGaurdService]},
  {path:'busList',component:BusListComponent,canActivate:[AuthGaurdService]},
  {path:'addBus',component:AddBusComponent,canActivate:[AuthGaurdService]},
  {path:'addRoute',component:AddRouteComponent,canActivate:[AuthGaurdService]},
  {path:'updateCustomer/:id',component:UpdateCustomerComponent,canActivate:[AuthGaurdService]},
  {path:'updateAdmin/:id',component:UpdateAdminComponent,canActivate:[AuthGaurdService]},
  {path:'addTravel',component:AddTravelComponent,canActivate:[AuthGaurdService]},
  {path:'updateBus/:id',component:UpdateBusComponent,canActivate:[AuthGaurdService]},
  {path:'booking',component:AddBookingComponent,canActivate:[AuthGaurdService]},
  {path:'adminProfile',component:AdminDetailsComponent,canActivate:[AuthGaurdService]},
  {path:'customerProfile',component:CustomerDetailsComponent,canActivate:[AuthGaurdService]},
  {path:'payment',component:AddPaymentComponent,canActivate:[AuthGaurdService]},
  {path:'travellist',component:TravelListComponent,canActivate:[AuthGaurdService]},
  {path:'feedback',component:AddFeedbackComponent,canActivate:[AuthGaurdService]},
  {path:'busBooking',component:AddBusBookingComponent,canActivate:[AuthGaurdService]},
  {path:'bookinglist',component:BookingListComponent,canActivate:[AuthGaurdService]},
  {path:'adminBusList',component:AdminBuslistComponent,canActivate:[AuthGaurdService]},

  {path:'admin',component:AdminHomepageComponent,canActivate:[AuthGaurdService],data:{userType:'ADMIN'}},
  // {path:'',component:DefaultHomepageComponent,canActivate:[AuthGaurdService],data:{role:'CUSTOMER'}},
  {path:'passwordUpdate',component:UpdatePasswordComponent,canActivate:[AuthGaurdService]},
  {path:'401',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

