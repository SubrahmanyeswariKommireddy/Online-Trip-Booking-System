// import { Component, OnInit } from '@angular/core';
// import { Router } from '@angular/router';
// import { LoginService } from '../shared/login.service';
// import { ToastrService } from 'ngx-toastr';
// import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import { User } from '../models/User';

// export class JwtResponse {
//   jwtToken!: string;
//   id!: number;
// }

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })

// export class LoginComponent implements OnInit {

//   roleData: any[] = ['ADMIN','CUSTOMER']

//   user: User = {
//     id: 0,
//     userName: '',
//     password: '',
//     userType: '',
//     email: '',
//     mobileNumber: ''
//   }

//   email: string = '';
//   password: string = '';
//   userType: string = '';
//   invalidLogin: boolean = false;
//   response!: JwtResponse;
//   isValidFormSubmitted: boolean = false;

//   constructor(private router: Router,
//     private loginservice: LoginService, private toastr: ToastrService, private formBuilder: FormBuilder) { }

//     ngOnInit() {
    
//     }

//   checkLogin(form1: any) {
//     var userType = sessionStorage.getItem('userType');
//     this.isValidFormSubmitted = false;
//   if (form1.valid) {
//     this.isValidFormSubmitted = true;
//   } else {
//     return;
//   }

//     (this.loginservice.authenticate(this.email, this.password, this.userType).subscribe(
//       data => {
//         this.toastr.success('Login Successful');
//         if (userType == "ADMIN") {
//           this.router.navigate(['/admin'])
//         }
//         else if (userType == "CUSTOMER") {
//           this.router.navigate([''])
//         }
//         this.invalidLogin = false
//       },
//       error => {
//         if (this.email == "") {
//           this.toastr.warning('Login Failed: Email is required');
//         }
//         else if (this.password == "") {
//           this.toastr.warning('Login Failed: Password is required');
//         }
//         else if (this.userType == "") {
//           this.toastr.warning('Login Failed: Usertype is required');
//         }
//         else {
//           this.toastr.error('Login Failed: Invalid Credentials');
//         }
//         this.invalidLogin = true
//       }
//     )
//     );
//   }

//   setValues(data: any) {
//     console.log("in set values", data)
//     sessionStorage.setItem('email', this.email);
//     sessionStorage.setItem('token', data.token);
//     sessionStorage.setItem('userType', this.userType);
//     sessionStorage.setItem('id', data.id)
//     console.log('data set')
//   }
// }


import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from '../models/User';
import { LoginService } from '../shared/login.service';

export class JwtResponse {

  jwtToken!: string;
  id!: number;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  roleData: any[] = ['ADMIN', 'CUSTOMER']

  user: User = {
    id:0,
    userName: '',
    password: '',
    userType: '',
    email: '',
    mobileNumber: ''
  }

  emailId: string = '';
  password: string = '';
  userType: string = '';
  isValidFormSubmitted: boolean = false;
  
  invalidLogin: boolean = false;
  response!: JwtResponse

  constructor(private router: Router,private toastr: ToastrService,
    private loginservice: LoginService) { }

  ngOnInit() {

  }

  checkLogin(form1:any) {
    var userType = sessionStorage.getItem('userType');
    this.isValidFormSubmitted = false;
  if (form1.valid) {
    this.isValidFormSubmitted = true;
  } else {
    return;
  }

    (this.loginservice.authenticate(this.user.email, this.user.password, this.user.userType).subscribe(
      (data: any) => {
        this.toastr.success('Login Successful');
                if (this.user.userType == "ADMIN") {
                  this.router.navigate(['/admin'])
                }
                else if (this.user.userType == "CUSTOMER") {
                  this.router.navigate([''])
                }
                this.invalidLogin = false
              },
      (error: any) => {
        this.toastr.error('Login Failed: Invalid Credentials');
        this.invalidLogin = true
      }
    )
    );

  }

  setValues(data: any) {
    console.log("in set values", data)
    sessionStorage.setItem('email', this.emailId);
    sessionStorage.setItem('token', data.token)
    sessionStorage.setItem('id', data.id)
    console.log('data set')
  }

}












