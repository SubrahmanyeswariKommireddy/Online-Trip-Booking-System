import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Route } from 'src/app/models/Route';
import { RouteService } from 'src/app/shared/route.service';

@Component({
  selector: 'app-add-route',
  templateUrl: './add-route.component.html',
  styleUrls: ['./add-route.component.css']
})
export class AddRouteComponent implements OnInit {

  route: any = Route;
  id: number = 0;
  addRouteForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private routeService: RouteService) {

  }

  ngOnInit(): void {
    this.addRouteForm=new FormGroup({
      source:new FormControl(''),
      destination:new FormControl('')
     
  });
  }


  onSubmit() {
    console.log(this.addRouteForm.value + "from onSubmit of add route component")
    this.routeService.addRoute(this.addRouteForm.value).subscribe(
        data => {this.route = data;
            this.router.navigate([''])},
        err => console.log(err)
    )
}

}
