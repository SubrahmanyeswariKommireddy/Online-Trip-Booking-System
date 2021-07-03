import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bus } from 'src/app/models/Bus';
import { BusService } from 'src/app/shared/bus.service';

@Component({
  selector: 'app-bus-component',
  templateUrl: './bus-component.component.html',
  styleUrls: ['./bus-component.component.css']
})
export class BusComponentComponent implements OnInit {
bus!:Bus;
id:number=0;
  constructor(private _ActivatedRoute: ActivatedRoute, private router: Router, private service: BusService) { }

  ngOnInit(): void {
      
      this.id = Number(this._ActivatedRoute.snapshot.paramMap.get("id"));
      this.service.getBusById(this.id).subscribe(
          (data) => {
              console.log(data);
              this.bus = data;
          },
          (err) => console.log(err)
      );
  }
    onBack(){
      this.router.navigate(['']);
  }

}


