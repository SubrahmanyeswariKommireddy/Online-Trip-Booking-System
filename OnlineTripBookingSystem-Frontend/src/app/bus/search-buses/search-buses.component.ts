import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-search-buses',
  templateUrl: './search-buses.component.html',
  styleUrls: ['./search-buses.component.css']
})
export class SearchBusesComponent implements OnInit {
  buses!:Bus[];

  constructor(
    private busService: BusService,
    private router:Router
  ) { }

  ngOnInit(): void {

    this.busService.getBuses().subscribe(
      (data) => this.buses = data,
      (err) => console.log(err)
  )
  }
  checkAvailability(){

  }

}



// import { Component, OnInit } from '@angular/core';
// import {SearchService} from './search.service';
// import { Subscription } from 'rxjs/Subscription';

// @Component({
//   selector: 'app-search-result',
//   templateUrl: './search-result.component.html',
//   styleUrls: ['./search-result.component.css']
// })
// export class SearchResultComponent implements OnInit {
//   subscription: Subscription;
//   results: object;

//   constructor(private service: SearchService) {
//     this.subscription = service.results$.subscribe(results =>; {
//       this.results = results;
//     })
//   }

//   ngOnInit() {

//   }
// }