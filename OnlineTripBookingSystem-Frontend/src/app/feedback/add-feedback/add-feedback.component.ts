import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {

  stars: number[] = [1, 2, 3, 4, 5];
  currentRate = 0;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  submit(){
    this.router.navigate(['']);
  }

  // countStar(star:any) {
  //   console.log('Value of star', star);
  // }

  




}
