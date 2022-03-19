import {Component, OnDestroy, OnInit} from '@angular/core';
import {OrderService} from "../services/order.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable, Subscription} from "rxjs";
import {Order} from "../order";
import {NgForm} from "@angular/forms";
import {CustomerService} from "../services/customer.service";

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit, OnDestroy {

  order: any;
  orders: any;

  sub: Subscription | any;

  customer: any;

  constructor(private orderService: OrderService,
              private router: Router,
              private route: ActivatedRoute,
              private customerService: CustomerService) {
  }

  // ngOnInit(): void {
  //
  //  const orderId = this.route.snapshot.paramMap.get('id');
  //  this.order = this.orderService.get(orderId);
  // }
  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.orderService.get(id).subscribe((order: any) => {
            if (order) {
              this.order = order;
              this.order.href = order._links.self.href;
              this.orderService.get(order.id).subscribe(url => order.Url = url);
            } else {
              console.log(`Order with id '${id}' not found, returning to list`);
              this.gotoList();
            }
          }
        )
      }
    })

  }


  gotoList() {
    // const orderId =  this.order ? this.order.id : null;
    // this.router.navigate(['/order-detail', {id: orderId}]);
    this.router.navigate(['/order-list']);
  }

  reloadData() {
    this.orders = this.orderService.getAll();

  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  update(order: any, href: any) {

  }

  remove(href: any) {

  }

  save(form: NgForm) {
    //   this.orderService.save(form).subscribe(result=>{
    //     this.gotoList();
    //   },error => console.error(error));
    // }
  }

  sendEmail(id:any){
    this.customerService.sendEmail(id);
  }
}
