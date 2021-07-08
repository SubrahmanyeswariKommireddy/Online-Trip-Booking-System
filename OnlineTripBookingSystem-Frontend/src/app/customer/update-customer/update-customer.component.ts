import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/models/Customer';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})

export class UpdateCustomerComponent implements OnInit {

  updateCustomerForm!: FormGroup;
  customer!: Customer;
  id: number = 0;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router, private _ActivatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {

    this.id = Number(this._ActivatedRoute.snapshot.paramMap.get("id"))

    this.userService.getCustomerById(this.id).subscribe(
      (data) => {
        console.log(data);
        this.customer = data;
        this.updateCustomerForm = this.formBuilder.group({
          id: this.customer.id,
          mobileNumber: this.customer.mobileNumber
        })
      },
      (err) => console.log(err)
    );
  }

  onSubmit() {
    console.log(this.updateCustomerForm.value + "from onSubmit of edit customer component")
    this.userService.updateCustomer(this.updateCustomerForm.value).subscribe(
      (data) => {
        this.customer = data;
        console.log(data);
        console.log('Mobile number updated successfully!')
        this.router.navigate(['customerProfile'])
      },
      (err) => console.log(err)
    )
  }

}