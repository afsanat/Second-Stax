import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProviderDetailServiceService {

  constructor(private http:HttpClient) { 
  }

  getProviderDetails(id:any):Observable<any>{
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem("Authorization"));
    return this.http.get<any>('http://localhost:8080/api/v1/products/providerFX/'+ id,{headers, responseType: 'text' as 'json' });
  }

  getPayments(id:any):Observable<any>{
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem("Authorization"));
    return this.http.get<any>('http://localhost:8080/api/v1/payments/accounts/'+ id,{headers, responseType: 'text' as 'json' });
  }

  makeOrder(payload:any):Observable<any>{
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem("Authorization"));
    return this.http.post<any>('http://localhost:8080/api/v1/auth/orders',payload,{headers, responseType: 'text' as 'json' });
  }
}
