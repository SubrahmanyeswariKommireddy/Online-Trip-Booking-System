import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/models/Admin';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-update-admin',
  templateUrl: './update-admin.component.html',
  styleUrls: ['./update-admin.component.css']
})
export class UpdateAdminComponent implements OnInit {

  updateAdminForm!: FormGroup;
  admin!: Admin;
  id: number = 0;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router, private _ActivatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {

    this.id = Number(this._ActivatedRoute.snapshot.paramMap.get("id"))

    this.userService.getAdminById(this.id).subscribe(
      (data) => {
        console.log(data);
        this.admin = data;
        this.updateAdminForm = this.formBuilder.group({
          id: this.admin.id,
          mobileNumber: this.admin.mobileNumber
        })
      },
      (err) => console.log(err)
    );
  }

  onSubmit() {
    console.log(this.updateAdminForm.value + "from onSubmit of edit admin component")
    this.userService.updateAdmin(this.updateAdminForm.value).subscribe(
      (data) => {
        this.admin = data;
        console.log(data);
        console.log('Mobile number updated successfully!')
        this.router.navigate(['adminProfile'])
      },
      (err) => console.log(err)
    )
  }

}