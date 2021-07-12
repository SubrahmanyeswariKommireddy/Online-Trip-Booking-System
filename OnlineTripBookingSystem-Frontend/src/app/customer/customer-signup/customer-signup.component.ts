import { Component, OnInit } from '@angular/core';
import { SignupService } from 'src/app/shared/signup.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-customer-signup',
  templateUrl: './customer-signup.component.html',
  styleUrls: ['./customer-signup.component.css']
})
export class CustomerSignupComponent implements OnInit {

  roleData: any[] = ['ADMIN','CUSTOMER'];
  emailPattern= "^[a-z0-9._%+-]+@gmail.com"; 

  user: User = {
    id: 0,
    userName: '',
    password: '',
    userType: 'Select',
    email: '',
    mobileNumber: ''
  }

  isValidFormSubmitted: boolean = false;

  constructor(
    private signupService: SignupService,
    private router: Router, private toastr: ToastrService
  ) { }

  ngOnInit() {
   
  }

  createUser(form1: any): void {
    console.log("in create user", form1.value)
    this.isValidFormSubmitted = false;
    
    if (form1.valid) {
      this.isValidFormSubmitted = true;
    } else {
      return;
    }
    this.signupService.createUser(this.user)
      .subscribe(
        data => {
          this.toastr.success('Registered Successfully');
          this.router.navigate(['login'])
        });
  };
}
