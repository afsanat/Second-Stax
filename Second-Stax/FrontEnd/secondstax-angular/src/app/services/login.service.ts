import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  public traderLogin(request:any){
    return this.http.post<any>("http://localhost:8080/api/v1/auth/login",request,{responseType:'text' as 'json'});
  }

  public salesTest(token:any){
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<any>("http://localhost:8080/api/v1/orders/ProviderSells/123e4567-e89b-12d3-a456-426614174007", {headers, responseType: 'text' as 'json' });
  }


public getID(email:any){
  return this.http.get<any>("http://localhost:8080/api/v1/auth/loggedID/"+email);
}

}
