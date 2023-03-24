import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProvidersService {

  constructor(private http:HttpClient) { }
  

  getProviders():Observable<any>{
    return this.http.get<any>('http://localhost:8080/api/v1/providers');
  }

}
