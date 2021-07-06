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
  customer!:Customer;
  id!:number;
   
  constructor(
    private userService: UserService,
    private router:Router
  ) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.customer.mobileNumber + "from onSubmit of add bus component")
    this.userService.updateMobileNumber(this.customer.id, this.customer).subscribe(
        data => {this.customer = data;
            this.router.navigate([''])},
        err => console.log(err)
    )
}
}




// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup } from '@angular/forms';
// import { ActivatedRoute, Router } from '@angular/router';
// import { SecurityAlertService } from '../shared/securityalertservice';
// import { SecurityAlert } from './securityalert';

// @Component({
//   selector: 'app-edit-securityalert',
//   templateUrl: './edit-securityalert.component.html',
//   styleUrls: ['./edit-securityalert.component.css']
// })
// export class EditSecurityalertComponent implements OnInit {


//   securityalert!: SecurityAlert;
//   editForm!: FormGroup;
//   id: number = 0;

//   constructor(private _ActivatedRoute: ActivatedRoute,
//     private formBuilder: FormBuilder,
//     private router: Router,
//     private service: SecurityAlertService) { }


//   ngOnInit(): void {
//     this.id = Number(this._ActivatedRoute.snapshot.paramMap.get("id"));

//     this.service.getSecurityAlertById(this.id).subscribe(
//       (data) => {
//         console.log(data);
//         this.securityalert = data;
//         this.editForm = this.formBuilder.group({

//           id: this.securityalert.id,
//           alert: this.securityalert.alert,
//           message: this.securityalert.message,

//         })
//       },
//       (err) => console.log(err)
//     );
//   }

//   onSubmit() {

//     console.log('form onSubmit of edit securityalert' + this.editForm.value);
//     this.service.updateSecurityAlert(this.id, this.editForm.value).
//       subscribe(
//         (data) => {
//           this.securityalert = data;
//           this.router.navigate(['securityalerts'])
//         },
//         (err) => { console.log(err) }
//       )
//   }
// }


