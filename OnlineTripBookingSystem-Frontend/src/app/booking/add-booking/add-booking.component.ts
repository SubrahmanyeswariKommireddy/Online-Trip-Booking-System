import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {

  seatsCount!: number;
  amount!: number;
  addBookingForm!: FormGroup;
  name!: string;
  phoneNumber: string = '';
  emailId: string = '';
  dateAndTime: string = '';
  fare!: number;
  
  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.seatsCount = parseInt(this.route.snapshot.paramMap.get('count')!)
    this.amount = parseInt(this.route.snapshot.paramMap.get('amount')!)
    this.addBookingForm = new FormGroup({
      userName: new FormControl(''),
      mobileNumber: new FormControl(''),
      email: new FormControl(''),
      dateTime: new FormControl('')
    });
  }

  myFunc() {
    this.router.navigate(['/payment']);
  }

  onSubmit() {
    this.name = this.addBookingForm.get('userName')?.value;
    this.phoneNumber = this.addBookingForm.get('mobileNumber')?.value;
    this.emailId = this.addBookingForm.get('email')?.value;
    this.dateAndTime = this.addBookingForm.get('dateTime')?.value;
  }

  @Input()
  countNum!: number;

}
