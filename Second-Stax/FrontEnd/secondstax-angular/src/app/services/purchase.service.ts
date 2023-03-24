import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  constructor(private http:HttpClient) { }

  getPurchases(traderID:any):Observable<any>{
    return this.http.get<any>('http://localhost:8080/api/v1/orders/traderPurchase/'+traderID);
  }
}
