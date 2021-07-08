import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/shared/login.service';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  constructor(private router:Router, public loginService:LoginService) { }

  ngOnInit(): void {

  }

  btnClick(){
    console.log("printing");
    this.router.navigateByUrl('login');
  }
  
  logOut(){
    console.log("printing");
    this.loginService.logOut();
    this.router.navigateByUrl('login');
  }
  
}
