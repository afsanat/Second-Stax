import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  getPurchases(id:any):Observable<any>{
    return this.http.get<any>('http://localhost:8080/api/v1/auth/orders/ProviderSells/'+id);
  }

  approveOrder(id:any):Observable<any>{
    return this.http.put<any>('http://localhost:8080/api/v1/auth/orders/acceptOrder/'+id,null);
  }

  rejectOrder(id:any):Observable<any>{
    return this.http.put<any>('http://localhost:8080/api/v1/auth/orders/rejectOrder/'+id,null);
  }
}
