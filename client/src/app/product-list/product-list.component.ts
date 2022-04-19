import { Component, OnInit } from '@angular/core';
import {Order} from "../order";
import {OrderService} from "../services/order.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  orders : [] |any
  item:any
  items: {} | any

  title : any

  constructor(private orderService:OrderService) {
  }

  ngOnInit(): void {
    this.orderService.getAll().subscribe(data=>
    this.orders=data)
  }

  share(){
    window.alert('the product has been shared!')
  }
 onNotify(){
    window.alert('You will be notified when the product goes on sale');
 }
}
