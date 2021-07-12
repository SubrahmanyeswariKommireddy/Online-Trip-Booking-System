import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

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

