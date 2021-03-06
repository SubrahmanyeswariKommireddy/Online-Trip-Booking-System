import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { ToastrService } from 'ngx-toastr';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-update-bus',
  templateUrl: './update-bus.component.html',
  styleUrls: ['./update-bus.component.css']
})
export class UpdateBusComponent implements OnInit {

  updateBusForm!: FormGroup;
  bus!: Bus;
  busId: number = 0;

  constructor(private formBuilder: FormBuilder, private router: Router, private busService: BusService,
    private _ActivatedRoute: ActivatedRoute, private toastr: ToastrService) { }

  ngOnInit(): void {

    this.busId = Number(this._ActivatedRoute.snapshot.paramMap.get("id"))

    this.busService.getBusById(this.busId).subscribe(
      (data) => {
        this.bus = data;
        this.updateBusForm = this.formBuilder.group({
          busId: this.bus.busId,

          fare: this.bus.fare
        })
      },
      (err) => console.log(err)
    );
  }

  onSubmit() {
    console.log(this.updateBusForm.value + "from onSubmit of edit bus component")
    this.busService.updateBus(this.updateBusForm.value).subscribe(
      (data) => {
        this.toastr.success('Fare Updated')
        this.bus = data;
        this.router.navigate(['adminBusList'])
      },
      (err) => console.log(err)
    )
  }
}