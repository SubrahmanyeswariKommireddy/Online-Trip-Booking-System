import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-homepage',
  templateUrl: './admin-homepage.component.html',
  styleUrls: ['./admin-homepage.component.css']
})
export class AdminHomepageComponent implements OnInit {

  public isAdmin: boolean=false;
  public isCustomer: boolean=false;

  constructor() { }

  ngOnInit(): void {
    
  }

}
