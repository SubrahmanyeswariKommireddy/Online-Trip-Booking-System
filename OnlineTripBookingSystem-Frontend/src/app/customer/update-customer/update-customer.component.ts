import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/models/Customer';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  customer!:Customer;
  updateCustomerForm!: FormGroup;
  id: number = 0;
  oldPassword!:string;
  newPassword!:string
  mobileNumber: string='';
  userName:string='';
  email:string='';
  password:string='';
  userService: any;

  constructor(private formBuilder: FormBuilder, userService:UserService, private router: Router, private _ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.updateCustomerForm=new FormGroup({
      mobileNumber:new FormControl(''),
      password:new FormControl(''),
      email:new FormControl('')
  });
  }
  onSubmit() {
    // console.log(this.updateCustomerForm.value + "from onSubmit of update customer component")
    // this.customerService.updatePassword(this.updateCustomerForm.value).subscribe(
    //     data => {this.customer = data;
    //         this.router.navigate(['busList'])},
    //     err => console.log(err)
    // )
   
}

updateUserInfo()
{
  this.customer = { 
    "id":this.id,
    "mobileNumber":this.mobileNumber,
    "email":this.email,
    "userName":this.userName,
    "password":this.password
   
  };
  console.log('printing')
  this.userService.updateUser(this.id,this.customer).subscribe((data: Customer)=>this.customer=data);
  sessionStorage.setItem("id",this.customer.id.toString());
  sessionStorage.setItem("mobileNumber",this.customer.mobileNumber.toString());
  sessionStorage.setItem("email",this.customer.email.toString());
  sessionStorage.setItem("userName",this.customer.userName.toString());
  sessionStorage.setItem("password",this.customer.password.toString());
  alert("Account Details Updated successfully!")

}

changePassword()
  {
    if(this.password==this.oldPassword)
    {
      if(this.oldPassword!=this.newPassword)
      {
        this.password = this.newPassword;

        this.updateUserInfo();
        console.log('printing')
        location.reload();
        console.log('printing')
        alert("Password changed successfully!");
      }
      else
      {
        alert("New Password cannot be same as Old password!")
      }
    }
    else
    {
      alert("Old Password is Incorrect!")
    }
  }

}




// export class MyAccountComponent implements OnInit {
//   user:User;
//   id;fullname;mobileno;dob;emailid;username;password;oldPassword;newPassword;
//   constructor(private userService:UserService,private route:Router) { }

//   ngOnInit(): void {
//     if(sessionStorage.getItem("userid")==null)
//     {
//       this.route.navigate(["/login"]);
//     }
//     this.id = sessionStorage.getItem('userid');
//     this.fullname = sessionStorage.getItem('userfullname');
//     this.mobileno = sessionStorage.getItem('usermobileno');
//     this.dob = sessionStorage.getItem('userdob');
//     this.emailid = sessionStorage.getItem('useremailid');
//     this.username = sessionStorage.getItem('username');
//     this.password = sessionStorage.getItem('password');
//   }
//   updateUserInfo()
//   {
//     this.user = { 
//       "id":this.id,
//       "fullName":this.fullname,
//       "mobileno":this.mobileno,
//       "dob":this.dob,
//       "emailid":this.emailid,
//       "username":this.username,
//       "password":this.password
//     };
//     this.userService.updateUser(this.id,this.user).subscribe(data=>this.user=data);
//     sessionStorage.setItem("userid",this.user.id.toString());
//     sessionStorage.setItem("userfullname",this.user.fullName.toString());
//     sessionStorage.setItem("usermobileno",this.user.mobileno.toString());
//     sessionStorage.setItem("userdob",this.user.dob.toString());
//     sessionStorage.setItem("useremailid",this.user.emailid.toString());
//     sessionStorage.setItem("username",this.user.username.toString());
//     sessionStorage.setItem("password",this.user.password.toString());
//     alert("Account Details Updated successfully!")
//   }
//   changeUserPassword()
//   {
//     if(this.password==this.oldPassword)
//     {
//       if(this.oldPassword!=this.newPassword)
//       {
//         this.password = this.newPassword;
//         this.updateUserInfo();
//         location.reload();
//         alert("Password changed successfully!");
//       }
//       else
//       {
//         alert("New Password cannot be same as Old password!")
//       }
//     }
//     else
//     {
//       alert("Old Password is Incorrect!")
//     }
//   }
//   deleteCurrentUser()
//   {
//     let id:number = Number(sessionStorage.getItem("userid"));
//     this.userService.deleteUser(id).subscribe((data)=>data);
//     sessionStorage.clear();
//     location.reload();
//     alert("Account Deleted Successfully!");
//   }
// }
