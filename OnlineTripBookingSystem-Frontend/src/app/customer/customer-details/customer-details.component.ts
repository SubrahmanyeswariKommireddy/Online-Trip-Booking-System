import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/models/Customer';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  customer!: Customer;
  id: number = 0;

  constructor(
    private userService: UserService,
    private router: Router, private _ActivatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {

    var id = sessionStorage.getItem('id');

    this.userService.getCustomerById(Number(id)).subscribe(
      (data) => {
        console.log(data);
        this.customer = data
      },
      (err) => console.log(err)
    );
  }

  onEdit(customer:Customer) {
    this.router.navigate(['updateCustomer',customer.id]);
  }

  onBack() {
    this.router.navigate(['']);
  }

}
