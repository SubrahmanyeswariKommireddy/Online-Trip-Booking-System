import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  public isAdmin: boolean=false;
  public isCustomer: boolean=false;

  constructor(private router:Router, public loginService:LoginService) { }

  ngOnInit(): void {
    
    var userType = sessionStorage.getItem('userType')
    if(userType=="ADMIN")
    {
      console.log("printinh");
      this.isAdmin=true;
      
    }
    else if(userType=="CUSTOMER")
    {
      console.log("printinh");
      this.isCustomer=true;
    }
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

