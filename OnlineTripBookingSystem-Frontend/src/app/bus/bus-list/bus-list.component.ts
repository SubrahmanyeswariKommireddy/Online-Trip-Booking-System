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
  sourceData!: any;
  destinationData!:any;
  busSeat:number=0;

  constructor(private _ActivatedRoute: ActivatedRoute, private formBuilder: FormBuilder, private router: Router, private busService: BusService) {

  }

  ngOnInit(): void {

    this.sourceData = this._ActivatedRoute.snapshot.paramMap.get('sourcePlace');
    this.destinationData=this._ActivatedRoute.snapshot.paramMap.get('destinationPlace')
    console.log(this.sourceData);
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

  // addBus() {
  //   this.router.navigate(['app-add-bus'])
  // }

  checkAvailability(bus:Bus) {

   var busSeatCount = sessionStorage.getItem((bus.busId).toString());
  //  let busSeat = parseInt(busSeatCount?.toString())
  if(busSeatCount!=null){
    this.busSeat= parseInt(busSeatCount);
  }
  if(this.busSeat>0){

  }
  else{
    sessionStorage.setItem((bus.busId).toString(),"0")
  }
   
    this.router.navigate(['viewSeats',{fare:bus.fare,id:bus.busId}]);
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