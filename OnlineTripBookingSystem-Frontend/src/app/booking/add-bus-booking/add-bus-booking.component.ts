import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Booking } from 'src/app/models/Booking';
import { Customer } from 'src/app/models/Customer';
import { BookingService } from 'src/app/shared/booking.service';

@Component({
  selector: 'app-add-bus-booking',
  templateUrl: './add-bus-booking.component.html',
  styleUrls: ['./add-bus-booking.component.css']
})
export class AddBusBookingComponent implements OnInit {

 //  teacher!: Teacher;
//   addTeacherForm!: FormGroup;
booking!:Customer;
addBookingForm!: FormGroup;
submitted:boolean=false;
  constructor(private service:BookingService,private router:Router) { }

  ngOnInit(): void {

    // var id = sessionStorage.getItem('id');
    this.addBookingForm=new FormGroup({
      name:new FormControl('',Validators.required),
      email:new FormControl('', Validators.required),
      mobileNumber:new FormControl('',Validators.required),
      source:new FormControl('',Validators.required),
      destination:new FormControl('',Validators.required)
  });

  }

  
  get f() { return this.addBookingForm.controls; }

    onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.addBookingForm.invalid) {
          return;
      }

       let id=sessionStorage.getItem('id');
    console.log(this.addBookingForm.value + "from onSubmit of add booking component");
    console.log(id);
    if(id!=null){
    this.service.addBooking(id,this.addBookingForm.value).
      subscribe(
        (data) => {
          this.booking = data;
          console.log(data);
          this.router.navigate(['/payment']);
        },
        (err) => { }
      )
  }
    }
}


// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
// import { Router } from '@angular/router';
// import { Teacher } from 'src/shared/classes/teacher';
// import { TeacherService } from 'src/shared/services/teacher.service';

// @Component({
//   selector: 'app-add-teacher',
//   templateUrl: './add-teacher.component.html',
//   styleUrls: ['./add-teacher.component.css']
// })
// export class AddTeacherComponent implements OnInit {

//   teacher!: Teacher;
//   addTeacherForm!: FormGroup;

//   constructor(private formBuilder: FormBuilder, private router: Router,
//     private service: TeacherService) { }

//   ngOnInit(): void {
//     this.addTeacherForm = new FormGroup({
//       name: new FormControl(''),
//       password: new FormControl(''),
//       phoneNumber: new FormControl(''),
//       emailId: new FormControl(''),
//       role: new FormControl('')
//     });
//   }

//   onSubmit() {
//     console.log(this.addTeacherForm.value + "from onSubmit of add teacher component");
//     this.service.addTeacher(this.addTeacherForm.value).
//       subscribe(
//         (data) => {
//           this.teacher = data;
//           this.router.navigate(['admin/list-teachers'])
//         },
//         (err) => { }
//       )
//   }
// }
