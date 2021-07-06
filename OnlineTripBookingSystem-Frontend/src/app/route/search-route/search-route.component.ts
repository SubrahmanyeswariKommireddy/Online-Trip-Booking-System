import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BusService } from 'src/app/shared/bus.service';
import { RouteService } from 'src/app/shared/route.service';

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

  constructor(private router: Router,private busService: BusService, private routeService:RouteService) { }

  ngOnInit() {
  }

  onSubmit(form: any){
    this.router.navigate(['busList'])
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
}
