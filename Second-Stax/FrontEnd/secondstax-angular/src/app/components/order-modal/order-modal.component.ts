import { Component, Inject } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProviderDetailServiceService } from 'src/app/services/provider-detail-service.service';
import { ProviderDetailsComponent } from '../provider-details/provider-details.component';

@Component({
  selector: 'app-order-modal',
  templateUrl: './order-modal.component.html',
  styleUrls: ['./order-modal.component.css']
})
export class OrderModalComponent {
  infoModal:any;
  payload:any
  providers = new FormGroup({
    provider: new FormControl('')
  });

  constructor(@Inject(MAT_DIALOG_DATA) public datas: ProviderDetailsComponent, private service:ProviderDetailServiceService){ 
    this.infoModal = datas
  }

  Purchase() {
    console.log( this.infoModal)
    this.payload={
      "amount": 340,
      "payment": "140569a6-5180-4c8a-a101-7b14c53541d7",
      "fxProduct": "123e4567-e89b-12d3-a456-426614174039",
      "trader": "123e4567-e89b-12d3-a456-426614173119"
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
}

