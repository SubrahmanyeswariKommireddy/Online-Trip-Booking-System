import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from 'src/app/models/Booking';
import { Customer } from 'src/app/models/Customer';
import { BookingService } from 'src/app/shared/booking.service';

@Component({
  selector: 'app-add-bus-booking',
  templateUrl: './add-bus-booking.component.html',
  styleUrls: ['./add-bus-booking.component.css']
})
export class AddBusBookingComponent implements OnInit {

  booking!: Customer;
  addBookingForm!: FormGroup;
  submitted: boolean = false;
  username: any;
  emailId: any;
  phoneNumber: any;
  sourceplace: any;
  destinationPlace: any;
  dateTime: any;

  seatsCount: any;
  amount: any;

  constructor(private service: BookingService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.seatsCount = parseInt(this.route.snapshot.paramMap.get('count')!)
    this.amount = parseInt(this.route.snapshot.paramMap.get('amount')!)
    this.addBookingForm = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      mobileNumber: new FormControl('', Validators.required),
      source: new FormControl('', Validators.required),
      destination: new FormControl('', Validators.required),
      date:new FormControl('',Validators.required)
    });

  }

  get f() { return this.addBookingForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.addBookingForm.invalid) {
      return;
    }

    this.username = this.addBookingForm.get('name')?.value;
    this.phoneNumber = this.addBookingForm.get('mobileNumber')?.value;
    this.emailId = this.addBookingForm.get('email')?.value;
    this.sourceplace = this.addBookingForm.get('source')?.value;
    this.destinationPlace = this.addBookingForm.get('destination')?.value;
    this.dateTime = this.addBookingForm.get('date')?.value;

    let id = sessionStorage.getItem('id');
    console.log(this.addBookingForm.value + "from onSubmit of add booking component");
    console.log(id);
    if (id != null) {
      this.service.addBooking(id, this.addBookingForm.value).
        subscribe(
          (data) => {
            this.booking = data;
            console.log(data);
          },
          (err) => { }
        )
    }
  }

  myFunc() {
    this.router.navigate(['/payment']);
  }
}