import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/models/Admin';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-admin-details',
  templateUrl: './admin-details.component.html',
  styleUrls: ['./admin-details.component.css']
})
export class AdminDetailsComponent implements OnInit {
  admin!: Admin;
  id: number = 0;

  constructor(
    private userService: UserService,
    private router: Router, private _ActivatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {

    var id = sessionStorage.getItem('id');

    this.userService.getAdminById(Number(id)).subscribe(
      (data) => {
        console.log(data);
        this.admin = data
      },
      (err) => console.log(err)
    );
  }

  onEdit(admin: Admin) {
    this.router.navigate(['updateAdmin', admin.id]);
  }

  onBack() {
    this.router.navigate(['']);
  }

}