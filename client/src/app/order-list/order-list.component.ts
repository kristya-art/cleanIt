import { Component, OnInit } from '@angular/core';
import {OrderService} from "../services/order.service";
import {Order} from "../order";

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  columnToDisplay = ['id','date','status']
  order:any;
  orders:any;

  items:any;


  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.orderService.getAll().subscribe(data=>{
      this.orders=data;

    })
  }

  reloadData(){
    this.orders = this.orderService.getAll();
  }

}
