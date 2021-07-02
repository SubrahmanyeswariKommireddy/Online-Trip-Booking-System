import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-add-bus',
  templateUrl: './add-bus.component.html',
  styleUrls: ['./add-bus.component.css']
})
export class AddBusComponent implements OnInit {
    bus: any = Bus;
    id: number = 0;
    addBusForm!: FormGroup;

    constructor(private formBuilder: FormBuilder, private router: Router, private busService: BusService) {

    }

    ngOnInit(): void {
        this.addBusForm = this.formBuilder.group({
            fare: ['', Validators.required],
            busType: ['', Validators.required],
            Travel: ['', Validators.required]
        })
    }

    onSubmit() {
        console.log(this.addBusForm.value + "from onSubmit of add bus component")
        this.busService.addBus(this.addBusForm.value).subscribe(
            data => {this.bus = data;
                this.router.navigate(['buses'])},
            err => console.log(err)
        )
    }
    
}