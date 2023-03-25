import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  ELEMENT_DATA: any;
  dataSource:any;

  constructor(private userService:LoginService, private adminService:AdminService,public router:Router){ }

  UserLogin(loginPayload:any){
    console.log(loginPayload.value);

    if (loginPayload.value.role == false){
      this.userService.traderLogin(loginPayload.value).subscribe({
        next: data => {
          this.ELEMENT_DATA = data;
          localStorage.setItem('Authorization',data);
          localStorage.setItem('LoggedUserName',loginPayload.value.email);
          var auth = localStorage.getItem("Authorization");
          this.testMethod(loginPayload.value.email);
  
          this.dataSource = new MatTableDataSource<any>(this.ELEMENT_DATA);
          this.router.navigate(["/purchases"]);
  
            },
      error: error => {
          console.error('There was an error!', error);
      }
    });
    }

    else{
      console.log("you are admin")
      this.router.navigate(["/sales"]);
    }
 
  }

  testMethod(email:any){
    this.userService.getID(email).subscribe(data=>
      {
      localStorage.setItem('LoggedUserID',data.traderId);
      console.log(localStorage.getItem('LoggedUserID'));
      }
      );
  }

  ngOnInit() {
    console.log("log");
}


}