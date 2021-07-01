// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup } from '@angular/forms';
// import { ActivatedRoute, Router } from '@angular/router';
// import { User } from '../models/User';
// import { LoginService } from '../shared/login.service';

// export class JwtResponse{
//   jwtToken:string='';
// }
// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })
// export class LoginComponent implements OnInit {

//   email: string = '';
//   password: string = '';
//   userType: string = '';
//   invalidLogin: boolean = false;
//   //response!:JwtResponse

//   user!: User;
//   id: number = 0;
//   loginForm!: FormGroup;

//   constructor(private loginService: LoginService, private router: Router, private formBuilder: FormBuilder,
//     private _ActivatedRoute: ActivatedRoute) { }

//   ngOnInit(): void {
//     this.email = String(this._ActivatedRoute.snapshot.paramMap.get("email"))
//     this.password = String(this._ActivatedRoute.snapshot.paramMap.get("password"))

//         this.loginService.authenticate(this.email, this.password, this.userType).subscribe(
//             (data) => {
//                 console.log(data);
//                 this.user = data;
//                 this.loginForm = this.formBuilder.group({
//                     email: this.user.email,
//                     password: this.user.password
//                 })
//             },
//             (err) => console.log(err)
//         );
//   }

  // checkLogin() {
  //   (this.loginService.authenticate(this.email, this.password, this.userType).subscribe(
  //     data => {
  //       console.log(data)
  //       /* this.response=data.jwtToken;
  //       console.log("Rseponse" ,this.response,"response ") */
  //       //this.setValues(data);
  //       this.router.navigate(['/login'])
  //       this.invalidLogin = false
  //     },
  //     error => {
  //       this.invalidLogin = true
  //     }
  //   )
  //   );
  // }

  //   onSubmit() {
  //     console.log(this.loginForm.value + "from onSubmit of login component")
  //     this.loginService.authenticate(this.email, this.password, this.userType).subscribe(
  //         (data) => {
  //             this.user = data;
  //             this.router.navigate(['login'])
  //         },
  //         (err) => console.log(err)
  //     )
  // }




//   setValues(data: any) {
//     console.log("in set values", data)
//     sessionStorage.setItem('email', this.email);
//     sessionStorage.setItem('token', data.token)
//     console.log('data set')
//   }
// }


import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/shared/login.service';

export class JwtResponse{

  jwtToken!:string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email:string = '';
  password:string = '';
  userType:string = '';
  invalidLogin:boolean = false;
  response!:JwtResponse;
  loginForm!: FormGroup;

  constructor(private router: Router,
    private loginService: LoginService) { }

  ngOnInit() {
    
  }

  checkLogin() {
    (this.loginService.authenticate(this.email, this.password, this.userType).subscribe(
      data => {
        console.log(data)
        this.router.navigate([''])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
      }
    )
    );

  }

  setValues(data:any){
    console.log("in set values",data)
    sessionStorage.setItem('email',this.email);
        sessionStorage.setItem('token',data.token);
      console.log('data set')



  }

}