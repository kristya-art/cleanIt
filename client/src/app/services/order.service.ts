import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private orderUrl = 'http://localhost:8080/orders';


  constructor(private http: HttpClient) { }

  getAll() : Observable<any>{
    return this.http.get(this.orderUrl,{responseType: 'json'});
  }

  get(id: string | null) {
    return this.http.get(this.orderUrl+'/'+ id);
  }


  // getOrderById(id){
  //   return this.http.get(this.orderUrl+id);
  // }
}
