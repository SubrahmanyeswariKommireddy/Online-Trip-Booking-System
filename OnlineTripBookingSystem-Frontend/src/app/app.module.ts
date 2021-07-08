import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UpdateAdminComponent } from './admin/update-admin/update-admin.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { AddBookingComponent } from './booking/add-booking/add-booking.component';
import { AddPaymentComponent } from './payment/add-payment/add-payment.component';
import { SignupComponent } from './signup/signup.component';
import { AddTravelComponent } from './travel/add-travel/add-travel.component';
import { UpdateTravelComponent } from './travel/update-travel/update-travel.component';
import { AdminHomepageComponent } from './home/admin-homepage/admin-homepage.component';
import { DefaultHomepageComponent } from './home/default-homepage/default-homepage.component'
import { BusListComponent } from './bus/bus-list/bus-list.component';
import { AddBusComponent } from './bus/add-bus/add-bus.component';
import { UpdateBusComponent } from './bus/update-bus/update-bus.component';
import { LogoutComponent } from './logout/logout.component';
import { AddRouteComponent } from './route/add-route/add-route.component';
import { RouteListComponent } from './route/route-list/route-list.component';
import { BusViewComponent } from './bus-view/bus-view.component';
import { AdminDetailsComponent } from './admin/admin-details/admin-details.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './shared/auth-interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SearchRouteComponent } from './route/search-route/search-route.component';
import { AdminHeaderComponent } from './header/admin-header/admin-header.component';
import { CustomerDetailsComponent } from './customer/customer-details/customer-details.component';
import { SeatData } from './models/seat-data';
import { DatePipe } from '@angular/common';
import { UpdatePasswordComponent } from './password/update-password/update-password.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    UpdateAdminComponent,
    UpdateCustomerComponent,
    AddBookingComponent,
    AddPaymentComponent,
    BusListComponent,
    AddBusComponent,
   
    UpdateBusComponent,
    SignupComponent,
    AddTravelComponent,
    UpdateTravelComponent,
    AdminHomepageComponent,
    DefaultHomepageComponent,
    LogoutComponent,
    AddRouteComponent,
  
    RouteListComponent,
    BusViewComponent,
    AdminDetailsComponent,
    SearchRouteComponent,
    AdminHeaderComponent,
    CustomerDetailsComponent,
    AdminHeaderComponent,
    UpdatePasswordComponent
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
    multi: true},
    SeatData,
     DatePipe],

  bootstrap: [AppComponent]
})
export class AppModule { }
