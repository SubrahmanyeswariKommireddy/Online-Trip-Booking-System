import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  public isAdmin: boolean=false;
  public isCustomer: boolean=false;

  constructor(private router:Router) { }

  ngOnInit(): void {
    
    var userType = sessionStorage.getItem('userType')
    if(userType=="ADMIN")
    {
      this.isAdmin=true;
    }
    else if(userType=="CUSTOMER")
    {
      this.isCustomer=true;
    }
  }  

  btnClick(){
    console.log("printing");
    this.router.navigateByUrl('login');
  }

}
