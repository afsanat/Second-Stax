import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProviderDetailServiceService } from 'src/app/services/provider-detail-service.service';
import { ProviderDetailsComponent } from '../provider-details/provider-details.component';

@Component({
  selector: 'app-order-modal',
  templateUrl: './order-modal.component.html',
  styleUrls: ['./order-modal.component.css']
})
export class OrderModalComponent implements OnInit{
  infoModal:any;
  banks:any;
  payload:any
  providers = new FormGroup({
    provider: new FormControl('')
  });

  constructor(@Inject(MAT_DIALOG_DATA) public datas: ProviderDetailsComponent, private service:ProviderDetailServiceService){ 
    this.infoModal = datas
  }

  ngOnInit(): void {
    console.log("opening modal");
    this.getPayment();
  }

  Purchase(f:any) {
    this.payload={
      "amount": f.value.amount,
      "payment": f.value.payment,
      "fxProduct": this.infoModal.dataId,
      "trader":  localStorage.getItem("LoggedUserID")
  }

    this.service.makeOrder(this.payload).subscribe({
      next: data => {
        console.log('order created!');
        console.log(data);
    },
    error: error => {
        console.error('There was an error creating order!', error);
    }
  });
  }

  getPayment(){
    this.service.getPayments(localStorage.getItem("LoggedUserID")).subscribe({
      next: data => {
        this.banks = JSON.parse(data);
        console.log('retrieved payments');
        console.log(this.banks);

    },
    error: error => {
        console.error('There was an error creating order!', error);
    }
  });
  }



  // banks: any= [
  //   {value: 'BK', viewValue: 'JE'},
  //   {value: 'ECOBANK', viewValue: 'KSD'},
  //   {value: 'SER', viewValue: 'JT'}
  // ];
}

