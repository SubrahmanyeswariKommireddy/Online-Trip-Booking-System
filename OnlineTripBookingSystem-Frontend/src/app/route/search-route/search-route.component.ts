import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from 'src/app/shared/bus.service';
import { RouteService } from 'src/app/shared/route.service';
import { FormsModule, NgForm } from '@angular/forms'

@Component({
  selector: 'app-search-route',
  templateUrl: './search-route.component.html',
  styleUrls: ['./search-route.component.css']
})
export class SearchRouteComponent implements OnInit {

  // constructor(private busService:BusService, private router:Router) { }

  // ngOnInit(): void {
  // }
  // searchBuses(){
  //   this.busService.getBuses().subscribe(
  //     data=>{
  //       console.log(data);
  //       this.router.navigate([''])
  //     }
  //   );
  // };

  searchData:any={
    source:'',
    destination:''
  }

  constructor(private route:ActivatedRoute,private router: Router,private busService: BusService, private routeService:RouteService) { }

  ngOnInit():void {
    // this.searchData.source=this.route.snapshot.paramMap.get('source');
    // this.searchData.destination=this.route.snapshot.paramMap.get('destination');
  }

  onSubmit(form:any){
    console.log(form.value);
    this.searchData.source=form.value.source;
    this.searchData.destination=form.value.destination;
   // this.router.navigate(['/busList',{search:this.searchData}]);

     this.router.navigate(['/busList',{sourcePlace:this.searchData.source,destinationPlace:this.searchData.destination}]);
    // ,destinationPlace:this.searchData.destination}]);
  }

  // update(source: any,destination: any)
  // {
  //   this.routeService.busBetweenValue(source,destination).subscribe(bus =>
  //     {
  //       if(bus!=null)
  //       {
  //         console.log(bus);
  //         this.router.navigate([''])
          
  //       }
  //       else{
  //         console.log(bus)
  //         // console.log("NO Output");
  //         alert("ENTER CORRECT CREDENTAILS");
          
  //            }
  //     }
  //   )
  
  // }

  // myFunc(){
  //   this.router.navigate(['/busList',{sourcePlace:this.searchData.source},{destinationPlace:this.searchData.destination}]);
  // }
}
