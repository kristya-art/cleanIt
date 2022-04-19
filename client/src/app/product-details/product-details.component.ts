import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Order} from "../order";
import {OrderService} from "../services/order.service";
import {CartService} from "../services/cart.service";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  order : any
  id : any | number
  orders : []|any

  constructor(private orderService: OrderService,
              private route:ActivatedRoute,
              private cartService:CartService) { }

  ngOnInit(): void {
    this.orderService.getAll().subscribe(data=>{
      this.orders=data;
      const routeParam = this.route.snapshot.paramMap;
      const productIdFromRoute = Number(routeParam.get('productId'));
      //find the product that corresponds to this id
      this.order = this.orders.find((order: { id: number; }) => order.id === productIdFromRoute);
    })
  }

  addToCart(order:Order){
    this.cartService.addToCart(order);
    window.alert('Your product has been added to the cart!');
  }
}
