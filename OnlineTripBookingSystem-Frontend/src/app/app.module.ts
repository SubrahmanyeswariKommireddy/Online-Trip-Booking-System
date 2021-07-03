import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UpdateAdminComponent } from './admin/update-admin/update-admin.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { AddBookingComponent } from './booking/add-booking/add-booking.component';
import { AddPaymentComponent } from './payment/add-payment/add-payment.component';
import { DeleteCustomerComponent } from './customer/delete-customer/delete-customer.component';
import { DeletePaymentComponent } from './payment/delete-payment/delete-payment.component';
import { DeleteBookingComponent } from './booking/delete-booking/delete-booking.component';
import { DeleteAdminComponent } from './admin/delete-admin/delete-admin.component';
import { BookingListComponent } from './booking/booking-list/booking-list.component';
import { SignupComponent } from './signup/signup.component';
import { AddTravelComponent } from './travel/add-travel/add-travel.component';
import { TravelListComponent } from './travel/travel-list/travel-list.component';
import { UpdateTravelComponent } from './travel/update-travel/update-travel.component';
import { DeleteTravelComponent } from './travel/delete-travel/delete-travel.component';
import { AdminHomepageComponent } from './home/admin-homepage/admin-homepage.component';
import { DefaultHomepageComponent } from './home/default-homepage/default-homepage.component'
import { BusListComponent } from './bus/bus-list/bus-list.component';
import { AddBusComponent } from './bus/add-bus/add-bus.component';
import { UpdateBusComponent } from './bus/update-bus/update-bus.component';
import { LogoutComponent } from './logout/logout.component';
import { AddRouteComponent } from './route/add-route/add-route.component';
import { UpdateRouteComponent } from './route/update-route/update-route.component';
import { RouteListComponent } from './route/route-list/route-list.component';
import { BusViewComponent } from './bus-view/bus-view.component';
import { AdminDetailsComponent } from './admin/admin-details/admin-details.component';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './shared/auth-interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SearchBusesComponent } from './bus/search-buses/search-buses.component';
import { SearchRouteComponent } from './route/search-route/search-route.component';
import { BusComponentComponent } from './bus/bus-component/bus-component.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    UpdateAdminComponent,
    CustomerListComponent,
    UpdateCustomerComponent,
    AddBookingComponent,
    AddPaymentComponent,
    DeleteCustomerComponent,
    DeletePaymentComponent,
    DeleteBookingComponent,
    BusListComponent,
    AddBusComponent,
   
    UpdateBusComponent,
    DeleteAdminComponent,
    BookingListComponent,
    SignupComponent,
    AddTravelComponent,
    TravelListComponent,
    UpdateTravelComponent,
    DeleteTravelComponent,
    AdminHomepageComponent,
    DefaultHomepageComponent,
    LogoutComponent,
    AddRouteComponent,
  
    UpdateRouteComponent,
    RouteListComponent,
    BusViewComponent,
    AdminDetailsComponent,
    ProfileComponent,
    SearchBusesComponent,
    SearchRouteComponent,
    BusComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
