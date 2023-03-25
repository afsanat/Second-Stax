import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProvidersService {

  constructor(private http:HttpClient) { }
  

  getProviders():Observable<any>{
    let tokenStr = 'Bearer ' + localStorage.getItem("Authorization");
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<any>('http://localhost:8080/api/v1/providers',{headers, responseType: 'text' as 'json' });
  }

}
