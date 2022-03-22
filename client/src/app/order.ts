import {OrderItem} from "./orderItem";
import {Customer} from "./customer";

export class Order{
  constructor(
  public  id : string,
    date: Date,
    amount : number,
    status : string,
    notes: string,
    items:{}
){}

}
