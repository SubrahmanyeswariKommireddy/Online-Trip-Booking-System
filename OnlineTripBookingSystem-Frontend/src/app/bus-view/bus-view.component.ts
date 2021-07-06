import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { StringLiteral } from 'typescript';
import { Route } from '../models/Route';

@Component({
  selector: 'app-seat',
  templateUrl: './bus-view.component.html',
  styleUrls: ['./bus-view.component.css']
})
export class BusViewComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
      
  }

     //variable declarations
    //  movieTitle:string = "Captain America: The Winter Soldier";
    //  screen: string = "LUXE CINEMAS";
    //  time: string = "FRI, 6:45PM"
 
    //  rows: string[] = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'];
    //  cols: number[]  = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
 
     reserved: string[] = [];
     selected: string[] = [];
     
    //  ticketPrice: number = 120;
    //  convFee: number = 30;
    //  totalPrice: number = 0;
    //  currency: string = "Rs";
 

    // @Input()
     countSeats:number=0;

    //  @Output()
    //  sendCountMsg = new EventEmitter<number>();
     
     status:boolean=false;
       flag!:number;
     //return status of each seat

    //  getStatus(seatPos: string)  {
    //      if(this.reserved.indexOf(seatPos) !== -1) {
    //          return 'reserved';
    //      } else  {
    //          return 'selected';
    //      }
         
    //  }

    // sendCount(){
    //     this.sendCountMsg.emit(this.countSeats);
    //     // this.router.navigate(['/booking']);
    // }


    getStatus(seatPos:string){
        if(this.selected.indexOf(seatPos)===1){
            this.status=!this.status;
            return this.status;
        }
        return this.status;
    }
     //clear handler
     clearSelected() {
         
         this.selected = [];
     }
     //click handler
     seatClicked (seatPos: string) {
         
         var index = this.selected.indexOf(seatPos);
         console.log(index);
         
         if(index !== -1) {
             // seat already selected, remove
             this.selected.splice(index, 1)
             this.countSeats--;
             console.log("deslected");
         } else {
             //push to selected array only if it is not reserved
             if(this.reserved.indexOf(seatPos) === -1)
            
                 this.selected.push(seatPos);
                 this.countSeats++;
                if(this.selected.indexOf(seatPos)){
                    this.status=this.getStatus(seatPos);
                    this.flag=1;
                }
                 console.log("selected");
         }
     }
     //Buy button handler
    //  showSelected() {
    //      if(this.selected.length > 0) {
    //          alert("Selected Seats: " + this.selected + "\nTotal: "+(this.ticketPrice * this.selected.length + this.convFee));
    //      } else {
    //          alert("No seats selected!");
    //      }
    //  }

    bgColor : string = 'grey';

    changeColor(){
        console.log("printing")
        this.bgColor = '#'+(Math.random()*0xFFFFFF<<0).toString(16);
    }

    myFunc(){
        
        this.router.navigate(['/booking',{count:this.countSeats}]);
    }

 }




    //  showSelected() {
    //      if(this.selected.length > 0) {
    //          alert("Selected Seats: " + this.selected + "\nTotal: "+(this.ticketPrice * this.selected.length + this.convFee));
    //      } else {
    //          alert("No seats selected!");
    //      }
    //  }

