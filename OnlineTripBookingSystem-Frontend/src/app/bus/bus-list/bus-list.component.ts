import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-bus-list',
  templateUrl: './bus-list.component.html',
  styleUrls: ['./bus-list.component.css']
})
export class BusListComponent implements OnInit {

  buses!: Bus[];
  private error!: string;
  private id!: number ;

  constructor(private formBuilder: FormBuilder, private router: Router, private busService: BusService) {

  }

  ngOnInit(): void {
      this.busService.getBuses().subscribe(
          (data) => this.buses = data,
          (err) => console.log(err)
      )
  }
  

  addBus() {
      this.router.navigate(['app-add-bus'])
  }

  // onEdit(bus: Bus) {
  //     this.router.navigate(['edit-customer', bus.id])
  // }

  // onDelete(bus: Bus) {
  //     this.busService.deleteBusById(bus.id).subscribe(
  //         (data) => {
  //             console.log('Bus deleted'),
  //             this.buses = this.buses.filter(
  //                 b => b !== bus
  //             )
  //         }
  //     )
  // }
}