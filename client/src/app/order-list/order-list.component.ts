import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {OrderService} from "../services/order.service";
import {Order} from "../order";
import {Router} from "@angular/router";
import {OrderItem} from "../orderItem";
import {Customer} from "../customer";
import {MatTableDataSource} from "@angular/material/table";
import {CustomerService} from "../services/customer.service";
import {ProductInfo} from "../productInfo";
import {debounceTime, distinctUntilChanged, filter, Subject} from "rxjs";


@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})


export class OrderListComponent implements OnInit {
  columnToDisplay : string[] = ['id','date','description','status','customerId','customerName','action','notes']

  private subjectKyeUp = new Subject<any>();
  order:any;
  orders:any;
  item:any;
  product: ProductInfo | any;


  items : {} | any;
  customer : Customer | any;

  customers : [] | any;

  id:any
  orders$:any

  constructor(private orderService: OrderService, private router: Router,private customerService : CustomerService) { }

  ngOnInit(): void {
    this.orderService.getAll().subscribe(data=>{
      this.orders=data;
      this.customers = this.customerService.getAll();

      this.subjectKyeUp.pipe(debounceTime(1000),
        distinctUntilChanged()).subscribe((d)=>{
        this.getOrders(d)});

   //  this.dataSource.paginator = this.paginator;
     // this.dataSource=data;
    })
  }

getOrders(value:string) {
    this.orders$ = this.orderService.getOrders(value)
    .subscribe((d)=>
    {
      console.log(d);
      // this.orders=d;

      });


}
  reloadData(){
    this.orders = this.orderService.getAll();
  }
   // @ViewChild(MatPaginator) paginator: MatPaginator;
   // @ViewChild(MatSort) sort : MatSort;

  gotoList(id: any) {
    this.id = id;
    // const orderId =  this.order ? this.order.id : null;
    // this.router.navigate(['/order-detail', {id: orderId}]);
    this.router.navigate(['/order-detail', {id}]);
  }

  onSearch($event:any){
    const value=$event.target.value;
    this.subjectKyeUp.next(value);

  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.orders.filter = filterValue.trim().toLowerCase();
  }

  done(order:Order){
    this.orderService.update(order)
  }

  update(order:Order): void{
    this.orderService.update(order)
      .subscribe(()=>this.order="Order updated successfully!");
  }
  create(order:Order) : void {

  }
  // a
  // applyFilter(filterValue: string) {
  //   filterValue = filterValue.trim(); // Remove whitespace
  //   filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
  //
  //   this.orders.filter = filterValue;
  // }


}
