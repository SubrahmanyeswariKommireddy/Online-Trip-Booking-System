import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/shared/user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-update-password',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.css']
})
export class UpdatePasswordComponent implements OnInit {

  user!: User;
  editForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private service: UserService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      oldPassword: ['', Validators.required],
      newPassword: ['', Validators.required]
    })
  }

  onSubmit() {
    const formValue = this.editForm.value;
    const data: any = {
      "email": sessionStorage.getItem('email'),
      "password": formValue.oldPassword,
      "userType": sessionStorage.getItem('userType')
    };

    this.service.updatePassword(formValue.newPassword, data).
      subscribe(
        (data) => {
          this.toastr.success('Password Updated');
          this.user = data;
          if (sessionStorage.getItem('userType') == "ADMIN") {
            this.router.navigate(['/admin'])
            "Password Updated"
          }
          if (sessionStorage.getItem('userType') == "CUSTOMER") {
            this.router.navigate([''])
            "Password Updated"
          }
        },
        (err) => { console.log(err) }
      )
  }
}