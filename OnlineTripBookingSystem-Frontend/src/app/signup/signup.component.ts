import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/User';
import { SignupService } from '../shared/signup.service';
import { ToastrService } from 'ngx-toastr';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User = {
    id: 0,
    userName: '',
    password: '',
    userType: '',
    email: '',
    mobileNumber: ''
  }

  userName: string = '';
  email: string = '';
  password: string = '';
  userType: string = '';
  mobileNumber: string = '';
  isValidFormSubmitted: boolean=false;

  constructor(
    private signupService: SignupService,
    private router: Router, private toastr: ToastrService
  ) { }

  ngOnInit() {
  }

  createUser(form1: any): void {
    console.log("in create user", form1.value)
  //   this.isValidFormSubmitted = false;
  // if (form1.valid) {
  //   this.isValidFormSubmitted = true;
  // } else {
  //   return;
  // }
    this.signupService.createUser(this.user)
      .subscribe(
        data => {
          this.toastr.success('Registered Successfully');
          this.router.navigate([''])
        });
  };
}




// onFormSubmit(form: NgForm) {
//   this.isValidFormSubmitted = false;
//   if (form.valid) {
//     this.isValidFormSubmitted = true;
//   } else {
//     return;
//   }
//   let newUser: User = form.value;
//   this.userService.createUser(newUser);
//   this.resetUserForm(form);
// }