import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StringLiteral } from 'typescript';
import { Route } from '../models/Route';

@Component({
    selector: 'app-seat',
    templateUrl: './bus-view.component.html',
    styleUrls: ['./bus-view.component.css']
})
export class BusViewComponent implements OnInit {

    getFare!: any;

    constructor(private router: Router, private _ActivatedRoute: ActivatedRoute) { }

    ngOnInit(): void {
        this.getFare = this._ActivatedRoute.snapshot.paramMap.get('fare');
    }

    reserved: string[] = [];
    selected: string[] = [];

    countSeats: number = 0;

    status: boolean = false;
    flag!: number;


    //return status of each seat
    getStatus(seatPos: string) {
        if (this.selected.indexOf(seatPos) === 1) {
            this.status = !this.status;
            return this.status;
        }
        return this.status;
    }

    //clear handler
    clearSelected() {
        this.selected = [];
    }

    //click handler
    seatClicked(seatPos: string) {
        var index = this.selected.indexOf(seatPos);
        console.log(index);

        if (index !== -1) {
            // seat already selected, remove
            this.selected.splice(index, 1)
            this.countSeats--;
            console.log("deslected");
        } else {
            //push to selected array only if it is not reserved
            if (this.reserved.indexOf(seatPos) === -1)
                this.selected.push(seatPos);
            this.countSeats++;
            if (this.selected.indexOf(seatPos)) {
                this.status = this.getStatus(seatPos);
                this.flag = 1;
            }
            console.log("selected");
        }
    }




    seatsSelected() {
        this.router.navigate(['/booking', { count: this.countSeats, amount: this.getFare * this.countSeats }]);

    }




}