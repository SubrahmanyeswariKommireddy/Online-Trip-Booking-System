import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Travel } from 'src/app/models/Travel';
import { TravelService } from 'src/app/shared/travel.service';

@Component({
  selector: 'app-add-travel',
  templateUrl: './add-travel.component.html',
  styleUrls: ['./add-travel.component.css']
})
export class AddTravelComponent implements OnInit {

  travel: any = Travel;
  id: number = 0;
  addTravelForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private routeService: TravelService) {

  }

  ngOnInit(): void {
    this.addTravelForm=new FormGroup({
      travelAgentName:new FormControl('')
  })
  }
  onSubmit() {
    console.log(this.addTravelForm.value + "from onSubmit of add route component")
    console.log("travel added")
    this.routeService.addTravel(this.addTravelForm.value).subscribe(
        data => {this.travel = data;
            this.router.navigate(['/home'])},
        err => console.log(err)
    )
}
}
