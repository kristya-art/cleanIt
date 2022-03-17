import {OrderItem} from "./orderItem";
import {Customer} from "./customer";

export class Order{
  constructor(
    id : number,
    date: Date,
    amount : number,
    status : string,
    notes: string,
  //  customer : any,
   // address: Address,
    //creditCard: CreditCard,
    // items : [] | OrderItem
    items:{}
){}

}
