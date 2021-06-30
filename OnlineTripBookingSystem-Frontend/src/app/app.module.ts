import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UpdateAdminComponent } from './admin/update-admin/update-admin.component';
import { AdminListComponent } from './admin/admin-list/admin-list.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { AddBookingComponent } from './booking/add-booking/add-booking.component';
import { AddPaymentComponent } from './payment/add-payment/add-payment.component'

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    UpdateAdminComponent,
    AdminListComponent,
    CustomerListComponent,
    UpdateCustomerComponent,
    AddBookingComponent,
    AddPaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
