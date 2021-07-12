import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from 'src/app/shared/bus.service';
import { RouteService } from 'src/app/shared/route.service';
import { FormsModule, NgForm } from '@angular/forms'
import { DatePipe } from '@angular/common';
import { SeatData } from 'src/app/models/seat-data';

@Component({
  selector: 'app-search-route',
  templateUrl: './search-route.component.html',
  styleUrls: ['./search-route.component.css']
})
export class SearchRouteComponent implements OnInit {

  searchData:any={
    source:'',
    destination:'',
    date:''
  }

  constructor(private route:ActivatedRoute,private router: Router,private busService: BusService, private routeService:RouteService, 
    private datePipe:DatePipe,private seatData:SeatData) { }

   
    
  ngOnInit():void {
   
  }

  onSubmit(form:any){
    console.log(form.value);
    this.searchData.source=form.value.source;
    this.searchData.destination=form.value.destination;
   console.log(form.value.date);
   let date = form.value.date;
   
   let dataStore=this.datePipe.transform(date,"yyyy-MM-dd")
   console.log(this.searchData.date=dataStore);
   this.seatData.bookingDate.push(dataStore!);
   console.log(this.seatData);
     this.router.navigate(['/busList',{sourcePlace:this.searchData.source,destinationPlace:this.searchData.destination}]);
  
  }


}
