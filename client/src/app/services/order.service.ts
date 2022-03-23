import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../order";
import {map} from "rxjs/operators"
import {debounceTime, distinctUntilChanged, Subject} from "rxjs";
import {pipe} from "rxjs";

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

  update(order:Order) : Observable<Order> {
    return this.http.put<Order>(this.orderUrl+'/'+order.id, order);
  }
getOrders(value:any):Observable<any>{
   return this.http.get(`http://localhost:8080/orders?customerId=${value}`)
     .pipe(
       map((d:any) => {
       return d;
       } ));
}



  // getOrderById(id){
  //   return this.http.get(this.orderUrl+id);
  // }
}
//http://localhost:8080/orders?customerId=1
