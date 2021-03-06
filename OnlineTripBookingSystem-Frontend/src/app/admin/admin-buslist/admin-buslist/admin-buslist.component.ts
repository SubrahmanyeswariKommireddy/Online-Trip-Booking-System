import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-admin-buslist',
  templateUrl: './admin-buslist.component.html',
  styleUrls: ['./admin-buslist.component.css']
})
export class AdminBuslistComponent implements OnInit {

  public isAdmin: boolean = false;
  public isCustomer: boolean = false;

  buses!: Bus[];
  busId!: number;
  sourceData!: any;
  destinationData!: any;
  busSeat: number = 0;

  constructor(private _ActivatedRoute: ActivatedRoute, private formBuilder: FormBuilder, private router: Router, private busService: BusService) {

  }

  ngOnInit(): void {
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

  checkAvailability(bus: Bus) {

    var busSeatCount = sessionStorage.getItem((bus.busId).toString());
    if (busSeatCount != null) {
      this.busSeat = parseInt(busSeatCount);
    }
    if (this.busSeat > 0) {

    }
    else {
      sessionStorage.setItem((bus.busId).toString(), "0")
    }

    this.router.navigate(['viewSeats', { fare: bus.fare, id: bus.busId }]);
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
        console.log(data)
      }
    )
  }

}