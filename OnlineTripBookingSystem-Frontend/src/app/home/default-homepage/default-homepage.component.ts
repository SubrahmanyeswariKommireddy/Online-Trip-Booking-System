import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-default-homepage',
  templateUrl: './default-homepage.component.html',
  styleUrls: ['./default-homepage.component.css']
})
export class DefaultHomepageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
 

}
