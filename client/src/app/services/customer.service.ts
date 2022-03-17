import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customerUrl = 'http://localhost:8080/customers';

  constructor(private http: HttpClient) { }

  getAll() : Observable<any>{
    return this.http.get(this.customerUrl,{responseType:'json'});
  }

  get(id:string | null){
    return this.http.get(this.customerUrl+'/'+id)
  }
}
