import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrls: ['./add-payment.component.css']
})

export class AddPaymentComponent implements OnInit {

  addPaymentForm!: FormGroup;
  cardNumber: string = '';
  expMonth!: number;
  expYear!: number;
  cvv!: number;

  constructor(private toastr: ToastrService) { }

  ngOnInit(): void {
    this.addPaymentForm = new FormGroup({
      cardNumber: new FormControl(''),
      expMonth: new FormControl(''),
      expYear: new FormControl(''),
      cvv: new FormControl('')
    });
  }

  pay() {
    this.cardNumber = this.addPaymentForm.get('cardNumber')?.value;
    this.expMonth = this.addPaymentForm.get('expMonth')?.value;
    this.expYear = this.addPaymentForm.get('expYear')?.value;
    this.cvv = this.addPaymentForm.get('cvv')?.value;
  }

  onSubmit() {
    if (this.cardNumber.length == 16) {
      this.toastr.success('Payment Successful');

    }
    else {
      this.toastr.error('Payment Failed: Invalid Credentials');
    }
  }

}