import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Order} from "../order";

@Component({
  selector: 'app-product-alerts',
  templateUrl: './product-alerts.component.html',
  styleUrls: ['./product-alerts.component.css']
})
export class ProductAlertsComponent implements OnInit {

  @Input() order! : Order;
  @Output() notify = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

}
