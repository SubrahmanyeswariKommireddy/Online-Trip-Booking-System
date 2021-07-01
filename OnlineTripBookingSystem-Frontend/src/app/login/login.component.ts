import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';

// export class JwtResponse{
//   jwtToken:string='';
// }
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email:string = '';
  password:string = '';
  userType:string ='';
  invalidLogin:boolean = false;
  //response!:JwtResponse

  constructor(private loginService : LoginService, private router:Router) { }

  ngOnInit(): void {
  }

  // checkLogin() {
  //   (this.loginService.authenticate(this.email, this.password,this.userType).subscribe(
  //     data => {
  //       console.log(data)
  //       /* this.response=data.jwtToken;
  //       console.log("Rseponse" ,this.response,"response ") */
  //       //this.setValues(data);
  //       this.router.navigate([''])
  //       this.invalidLogin = false
  //     },
  //     error => {
  //       this.invalidLogin = true

  //     }
  //   )
  //   );

  // }
}