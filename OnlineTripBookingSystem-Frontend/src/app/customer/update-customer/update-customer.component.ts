import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/models/Customer';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  customer!:Customer;
  updateCustomerForm!: FormGroup;
  id: number = 0;
  // oldPassword!:string;
  // newPassword!:string
  // mobileNumber: string='';
  // userName:string='';
  // email:string='';
  // password:string='';
   userService: any;
  // isLoginError : boolean = false;

  constructor(private formBuilder: FormBuilder, userService:UserService, private router: Router, private _ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
  //   this.updateCustomerForm=new FormGroup({
  //     mobileNumber:new FormControl(''),
  //     userName:new FormControl(''),
  //     email:new FormControl('')
  // });

  this.id = Number(this._ActivatedRoute.snapshot.paramMap.get("id"));

    this.userService.getCustomerById(this.id).subscribe(
      (data: Customer) => {
        console.log(data);
        this.customer = data;
        this.updateCustomerForm = this.formBuilder.group({

          id: this.customer.id,
          // alert: this.customer.alert,
          // message: this.customer.message,

        })
      },
      (err: any) => console.log(err)
    );
  }
  onSubmit() {
    
      console.log('form onSubmit of edit securityalert' + this.updateCustomerForm.value);
          this.userService.updateMobileNumber(this.id, this.updateCustomerForm.value).
            subscribe(
              (data: Customer) => {
                this.customer = data;
                this.router.navigate([''])
              },
              (err: any) => { console.log(err) }
            )
   
}

// createUser(form1: any): void {
//   console.log("in create user",form1.value)
  
//   this.userService.createUser(this.customer)
//       .subscribe( (data: any) => {
//         console.log(data);
//         this.router.navigate(['/default'])
//       });
// };
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


