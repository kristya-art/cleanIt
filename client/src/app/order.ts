import {OrderItem} from "./orderItem";
import {Customer} from "./customer";

export class Order{
  constructor(
  public  id : string,
  public date: Date,
  public amount : number,
  public status : string,
  public notes: string,
  public items:{}
){}

}
