import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  constructor(private http:HttpClient) { }

  getPurchases(traderID:any, token:any):Observable<any>{
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<any>('http://localhost:8080/api/v1/auth/orders/traderPurchase/'+traderID,{headers, responseType: 'text' as 'json' });
  }
}
