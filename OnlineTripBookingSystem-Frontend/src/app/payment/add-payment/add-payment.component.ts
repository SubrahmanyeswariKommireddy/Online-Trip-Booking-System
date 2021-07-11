import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';

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
  status!: string;
  getAmount:number=0;
  cardHolder:number=0;

  constructor(private route:ActivatedRoute,private router:Router,private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getAmount = parseInt(this.route.snapshot.paramMap.get('am')!)
    this.addPaymentForm = new FormGroup({
      cardNumber: new FormControl(''),
      expMonth: new FormControl(''),
      expYear: new FormControl(''),
      cvv: new FormControl(''),
      cardHolder: new FormControl('')
    });
  }

  pay() {
    this.cardNumber = this.addPaymentForm.get('cardNumber')?.value;
    this.expMonth = this.addPaymentForm.get('expMonth')?.value;
    this.expYear = this.addPaymentForm.get('expYear')?.value;
    this.cvv = this.addPaymentForm.get('cvv')?.value;
    this.cardHolder = this.addPaymentForm.get('cardHolder')?.value;
  }

  onSubmit() {
    if (this.cardNumber.length == 16) {
     
      this.toastr.success('Payment Successful');
      this.router.navigate(['/feedback']);
    }
    else {
      this.toastr.error('Payment Failed: Invalid Credentials');
      this.router.navigate(['']);
    }
  }

}