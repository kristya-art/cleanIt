import { Injectable } from '@angular/core';
import {Order} from "../order";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  items : Order[]=[]
  constructor() { }

  addToCart(order : Order){
    this.items.push(order);
  }

  getItems(){
    return this.items;
  }
  clearCart(){
    this.items=[];
    return this.items;
  }

}
