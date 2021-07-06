import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {

  seatsCount!:number;
  constructor(private route:ActivatedRoute) { }

  ngOnInit():void {
// console.log(parseInt(this.route.snapshot.paramMap.get('count')!));
    this.seatsCount=parseInt(this.route.snapshot.paramMap.get('count')!)
  }

@Input()
countNum!:number;

}
