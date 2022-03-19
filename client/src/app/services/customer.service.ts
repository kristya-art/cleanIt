import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../customer";

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

  sendEmail(id:any):void {
    const url = 'http://localhost:8080/customers/sendEmail/' +id;
    this.http.post(url,{responseType: 'text'}).subscribe(
      res=>{location.reload();window.alert("message has been sent!") },
      err=> {
        //alert('An error has occurred while sending email')
      }
    )
  }

  update(customer : Customer) : Observable<any>{
    return this.http.put(this.customerUrl+"/"+customer.id,customer);
  }

   Email(id:any) : void {
     const url = 'http://localhost:8080/customers/sendEmail';
     this.http.post(url,{responseType: 'text'});
   }

}
