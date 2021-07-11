import { Component, OnInit } from '@angular/core';
import { BusBooking } from 'src/app/models/BusBooking';
import { BookingService } from 'src/app/shared/booking.service';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {

  constructor(private service: BookingService) { }

  bookings!: BusBooking[];

  ngOnInit(): void {
    var id = sessionStorage.getItem('id');
    if (id != null)
      this.service.getBookingByCustomerId(id).subscribe(
        (data) => this.bookings = data,
        (err) => console.log(err)

      )
    console.log(this.bookings);
  }

}