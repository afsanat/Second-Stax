import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProviderDetailServiceService {
  constructor(private http:HttpClient) { }
  

  getProviderDetails(id:any):Observable<any>{
    return this.http.get<any>('http://localhost:8080/api/v1/products/providerFX/'+ id);
  }

  makeOrder(payload:any):Observable<any>{
    return this.http.post<any>('http://localhost:8080/api/v1/orders',payload);
  }
}
