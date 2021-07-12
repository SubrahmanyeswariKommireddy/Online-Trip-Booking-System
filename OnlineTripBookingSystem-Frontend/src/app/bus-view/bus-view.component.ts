import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StringLiteral } from 'typescript';
import { Route } from '../models/Route';
import { SeatData } from '../models/seat-data';

@Component({
    selector: 'app-seat',
    templateUrl: './bus-view.component.html',
    styleUrls: ['./bus-view.component.css']
})
export class BusViewComponent implements OnInit {
    // seatSelected:boolean=false;
    numberOfSeats: number = 0;
    seats: number = 0;



    getFare!: any;
    id: any = '';
    count: any;
    isFirstSeatDisabled: boolean = false;
    isSecondSeatDisabled: boolean = false;
    isThirdSeatDisabled: boolean = false;
    isFourthSeatDisabled: boolean = false;
    isFifthSeatDisabled: boolean = false;
    isSixthSeatDisabled: boolean = false;
    isSeventhSeatDisabled: boolean = false;
    isEightSeatDisabled: boolean = false;
    isNineSeatDisabled: boolean = false;
    isTenSeatDisabled: boolean = false;

    isElevenSeatDisabled: boolean = false;
    isTwelveSeatDisabled: boolean = false;
    isThirteenSeatDisabled: boolean = false;
    isFourteenSeatDisabled: boolean = false;
    isFifteenSeatDisabled: boolean = false;
    isSixteenSeatDisabled: boolean = false;
    isSeventeenSeatDisabled: boolean = false;
    isEighteenDisabled: boolean = false;
    isNinteenDisabled: boolean = false;
    isTwentySeatDisabled: boolean = false;

    isTwentyOneSeatDisabled: boolean = false;
    isTwentyTwoSeatDisabled: boolean = false;
    isTwentyThreeSeatDisabled: boolean = false;
    isTwentyFourSeatDisabled: boolean = false;
    isTwentyFiveSeatDisabled: boolean = false;
    isTwentySixSeatDisabled: boolean = false;
    isTwentySevenSeatDisabled: boolean = false;
    isTwentyEightSeatDisabled: boolean = false;
    isTwentyNineSeatDisabled: boolean = false;
    isThirtySeatDisabled: boolean = false;

    isThirtyOneSeatDisabled: boolean = false;
    isThirtyTwoSeatDisabled: boolean = false;


    seatArray!: any[];
    busSeat: number = 0;
    isDisabled: boolean = false;


    constructor(private router: Router, private _ActivatedRoute: ActivatedRoute, private seatData: SeatData) { }

    ngOnInit(): void {
        this.getFare = this._ActivatedRoute.snapshot.paramMap.get('fare');
        this.id = this._ActivatedRoute.snapshot.paramMap.get('id');
        this.seatArray = this.seatData.seatArr;
        this.count = sessionStorage.getItem(this.id);
        console.log(this.count);
        console.log(this.seatArray);
        if (this.count >= 1) {
            this.isFirstSeatDisabled = true;
        }
        if (this.count >= 2) {
            this.isSecondSeatDisabled = true;
        }
        if (this.count >= 3) {
            this.isThirdSeatDisabled = true;
        }
        if (this.count >= 4) {
            this.isFourthSeatDisabled = true;
        }
        if (this.count >= 5) {
            this.isFifthSeatDisabled = true;
        }
        if (this.count >= 6) {
            this.isSixthSeatDisabled = true;
        }
        if (this.count >= 7) {
            this.isSeventhSeatDisabled = true;
        }
        if (this.count >= 8) {
            this.isEightSeatDisabled = true;
        }
        if (this.count >= 9) {
            this.isNineSeatDisabled = true;
        }
        if (this.count >= 10) {
            this.isTenSeatDisabled = true;
        }



        if (this.count >= 11) {
            this.isElevenSeatDisabled = true;
        }
        if (this.count >= 12) {
            this.isTwelveSeatDisabled = true;
        }
        if (this.count >= 13) {
            this.isThirteenSeatDisabled = true;
        }
        if (this.count >= 14) {
            this.isFourteenSeatDisabled = true;
        }
        if (this.count >= 15) {
            this.isFifteenSeatDisabled = true;
        }
        if (this.count >= 16) {
            this.isSixteenSeatDisabled = true;
        }
        if (this.count >= 17) {
            this.isSeventeenSeatDisabled = true;
        }
        if (this.count >= 18) {
            this.isEighteenDisabled = true;
        }
        if (this.count >= 19) {
            this.isNinteenDisabled = true;
        }
        if (this.count >= 20) {
            this.isTwentySeatDisabled = true;
        }


        if (this.count >= 21) {
            this.isTwentyOneSeatDisabled = true;
        }
        if (this.count >= 22) {
            this.isTwentyTwoSeatDisabled = true;
        }
        if (this.count >= 23) {
            this.isTwentyThreeSeatDisabled = true;
        }
        if (this.count >= 24) {
            this.isTwentyFourSeatDisabled = true;
        }
        if (this.count >= 25) {
            this.isTwentyFiveSeatDisabled = true;
        }
        if (this.count >= 26) {
            this.isTwentySixSeatDisabled = true;
        }
        if (this.count >= 27) {
            this.isTwentySevenSeatDisabled = true;
        }
        if (this.count >= 28) {
            this.isTwentyEightSeatDisabled = true;
        }
        if (this.count >= 29) {
            this.isTwentyNineSeatDisabled = true;
        }
        if (this.count >= 30) {
            this.isThirtySeatDisabled = true;
        }

        if (this.count >= 31) {
            this.isThirtyOneSeatDisabled = true;
        }
        if (this.count >= 32) {
            this.isThirtyTwoSeatDisabled = true;
        }
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
        var busSeatCount = sessionStorage.getItem((this.id).toString());
        if (index !== -1) {
            // seat already selected, remove
            this.selected.splice(index, 1)
            this.seats--;
            this.countSeats = this.seats;
            this.numberOfSeats--;

            if (busSeatCount != null) {
                this.busSeat = parseInt(busSeatCount);
            }
            if (this.busSeat > 0) {
                this.busSeat--;
                this.countSeats = this.seats;
                sessionStorage.setItem(this.id, this.busSeat.toString())

            }
            else {
                sessionStorage.setItem((this.id).toString(), this.countSeats.toString())
            }

            sessionStorage.setItem(this.id, this.seats.toString())
            console.log(this.selected);
            console.log(this.reserved);
            console.log("deslected");
        } else {
            //push to selected array only if it is not reserved
            if (this.reserved.indexOf(seatPos) === -1)
                this.selected.push(seatPos);
            let seatPosNo = parseInt(seatPos);
            this.seatArray[seatPosNo] = 0
            this.seats++;
            this.countSeats = this.seats;

            if (busSeatCount != null) {
                this.busSeat = parseInt(busSeatCount);
            }
            if (this.busSeat > 0) {
                console.log(this.busSeat)
                this.busSeat++;
                sessionStorage.setItem(this.id, this.busSeat.toString())

            }
            else {
                sessionStorage.setItem((this.id).toString(), this.countSeats.toString())
            }

            console.log(this.selected);
            console.log(this.reserved);
            console.log("selected");
        }
    }

    seatsSelected() {

        console.log(this.seatData.seatArr = this.seatArray);
        this.router.navigate(['/busBooking', { count: this.countSeats, amount: this.getFare * this.countSeats }]);
        this.seats = 0;
    }

    disabled(seatIndex: string) {

        if (this.seatArray.indexOf(seatIndex) == 0) {
            this.isDisabled = true;
            return this.isDisabled;
        }
        else {
            this.isDisabled = false;
            return this.isDisabled;
        }

    }

}