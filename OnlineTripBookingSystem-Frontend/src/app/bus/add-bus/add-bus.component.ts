import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { BusService } from 'src/app/shared/bus.service';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'app-add-bus',
    templateUrl: './add-bus.component.html',
    styleUrls: ['./add-bus.component.css']
})
export class AddBusComponent implements OnInit {
    bus: any = Bus;
    id: number = 0;
    addBusForm!: FormGroup;

    constructor(private formBuilder: FormBuilder, private router: Router, private busService: BusService,
        private toastr: ToastrService) {

    }

    ngOnInit(): void {

        this.addBusForm = new FormGroup({
            fare: new FormControl(''),
            busType: new FormControl(''),
            totalCapacity: new FormControl('')
        });
    }

    onSubmit() {
        console.log(this.addBusForm.value + "from onSubmit of add bus component")
        this.busService.addBus(this.addBusForm.value).subscribe(

            data => {
                this.toastr.success('Bus Added');
                this.bus = data;
                this.router.navigate(['adminBusList'])
                console.log(data)
            },
            err => console.log(err)
        )
    }

}