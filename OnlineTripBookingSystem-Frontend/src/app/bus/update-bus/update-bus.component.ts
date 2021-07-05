import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-update-bus',
  templateUrl: './update-bus.component.html',
  styleUrls: ['./update-bus.component.css']
})
export class UpdateBusComponent implements OnInit {

  updateBusForm!: FormGroup;
  bus!:Bus;
  id: number = 0;

  constructor(private formBuilder: FormBuilder, private router: Router, private busService: BusService, private _ActivatedRoute: ActivatedRoute) { }

  // ngOnInit(): void {
  //   this.updateBusForm=new FormGroup({
  //     fare:new FormControl(''),
  //     busType:new FormControl(''),
  //     totalCapacity:new FormControl('')
  // });
  // }


  // this.id = Number(this._ActivatedRoute.snapshot.paramMap.get("id"))

  //       this.service.getCustomerById(this.id).subscribe(
  //           (data) => {
  //               console.log(data);
  //               this.customer = data;
  //               this.editCustomerForm = this.formBuilder.group({
  //                   id: this.customer.id,
  //                   userName: this.customer.userName,
  //                   password: this.customer.password,
  //                   role: this.customer.role
  //               })
  //           },
  //           (err) => console.log(err)
  //       );

  ngOnInit(): void {
        this.id = Number(this._ActivatedRoute.snapshot.paramMap.get("id"));
    
        this.busService.getBusById(this.id).subscribe(
          (data) => {
            console.log(data);
            this.bus = data;
            this.updateBusForm = this.formBuilder.group({
    
              id: this.bus.busId,
              fare: this.bus.fare,
              busType: this.bus.busType,
    
            })
          },
          (err) => console.log(err)
        );
      }

  
      onSubmit() {
        console.log(this.updateBusForm.value + "from onSubmit of edit customer component")
        this.busService.updateBus(this.id, this.updateBusForm.value).subscribe(
            (data) => {
                this.bus = data;
                this.router.navigate(['busList'])
            },
            (err) => console.log(err)
        )
    }

}
