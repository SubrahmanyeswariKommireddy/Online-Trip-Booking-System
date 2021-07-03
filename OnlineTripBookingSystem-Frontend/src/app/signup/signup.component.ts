// import { Component, OnInit } from '@angular/core';
// import { FormGroup } from '@angular/forms';
// import { Router } from '@angular/router';
// import { User } from '../models/User';
// import { SignupService } from '../shared/signup.service';

// @Component({
//   selector: 'app-signup',
//   templateUrl: './signup.component.html',
//   styleUrls: ['./signup.component.css']
// })

// export class SignupComponent implements OnInit {

//   user!:User
//   signupForm!:FormGroup
   
//   constructor(
//     private signupService: SignupService,
//     private router:Router
//   ) { }

//   ngOnInit() {
//    // this.signupForm.controls.proof.patchValue(this.signupForm);
//   }

//   createUser() {
//     console.log("in create user",this.signupForm.value)
    
//     this.signupService.createUser(this.user)
//         .subscribe( data => {
//           console.log(data);
//           this.router.navigate([''])
//         });
//   };
// }



import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/User';
import { SignupService } from '../shared/signup.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user:User= {
    userName: '',
    password:'',
    userType:'',
    email:'',
    mobileNumber: ''
  }
   
  constructor(
    private signupService: SignupService,
    private router:Router
  ) { }

  ngOnInit() {
  }

  createUser(form1: any): void {
    console.log("in create user",form1.value)
    
    this.signupService.createUser(this.user)
        .subscribe( data => {
          console.log(data);
          this.router.navigate(['/default'])
        });
  };
}