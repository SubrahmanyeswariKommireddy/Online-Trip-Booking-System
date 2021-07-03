import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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

  ngOnInit(): void {
    this.id = Number(this._ActivatedRoute.snapshot.paramMap.get("id"))
  }
  onSubmit() {
   
    console.log(this.updateBusForm.value + "from onSubmit of edit bus component")
    this.busService.updateBus(this.id, this.updateBusForm.value).subscribe(
        data => {this.bus = data;
            this.router.navigate(['busList'])},
        err => console.log(err)
    )
}

}
