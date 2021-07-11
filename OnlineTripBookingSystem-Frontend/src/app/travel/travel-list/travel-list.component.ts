import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Travel } from 'src/app/models/Travel';
import { ToastrService } from 'ngx-toastr';
import { TravelService } from 'src/app/shared/travel.service';

@Component({
  selector: 'app-travel-list',
  templateUrl: './travel-list.component.html',
  styleUrls: ['./travel-list.component.css']
})
export class TravelListComponent implements OnInit {

  travels!: Travel[];
  travelId!:number;
  busId!: number;
  public isAdmin: boolean = false;
  public isCustomer: boolean = false;

  constructor(private router:Router,private travelService:TravelService, private toastr: ToastrService) { }

  ngOnInit(): void {

  this.travelService.getTravels().subscribe(
    (data) => this.travels = data,
    (err) => console.log(err)
 
  )
  console.log(this.travels);
  var userType = sessionStorage.getItem('userType')
  if (userType == "ADMIN") {
    this.isAdmin = true;
  }
  else if (userType == "CUSTOMER") {
    this.isCustomer = true;
  }
  }

  addBus() {
    this.router.navigate(['addBus'])
  }


deleteTravel(travel:Travel){
  this.travelService.deleteTravelById(travel.travelId).subscribe(
    (data) => {
      this.toastr.success('Travel Deleted'),
      this.travels=this.travels.filter(
        t => t !== travel
      )
      console.log(data);
    }
  )
}

}
