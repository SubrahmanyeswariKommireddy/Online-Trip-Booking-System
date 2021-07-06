import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-bus-list',
  templateUrl: './bus-list.component.html',
  styleUrls: ['./bus-list.component.css']
})

export class BusListComponent implements OnInit {

  public isAdmin: boolean = false;
  public isCustomer: boolean = false;

  buses!: Bus[];
  busId!: number;
  busData!: any;

  constructor(private _ActivatedRoute: ActivatedRoute, private formBuilder: FormBuilder, private router: Router, private busService: BusService) {

  }

  ngOnInit(): void {

    this.busData = this._ActivatedRoute.snapshot.paramMap.get('sourcePlace');

    this.busService.getBuses().subscribe(
      (data) => this.buses = data,
      (err) => console.log(err)
    )

    this.busService.getBuses().subscribe(
      (data) => this.buses = data,
      (err) => console.log(err)
    )

    var userType = sessionStorage.getItem('userType')
    if (userType == "ADMIN") {
      this.isAdmin = true;
    }
    else if (userType == "CUSTOMER") {
      this.isCustomer = true;
    }
  }

  addBus() {
    this.router.navigate(['app-add-bus'])
  }

  checkAvailability() {
    this.router.navigate(['viewSeats']);
  }

  onEdit(bus: Bus) {
    this.router.navigate(['updateBus', bus.busId]);
  }

  onDelete(bus: Bus) {
    this.busService.deleteBusById(bus.busId).subscribe(
      (data) => {
        console.log('Bus deleted'),
          this.buses = this.buses.filter(
            b => b !== bus
          )
      }
    )
  }

}