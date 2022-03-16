import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {OrderListComponent} from "./order-list/order-list.component";
import{OrderDetailComponent} from "./order-detail/order-detail.component";

const routes: Routes = [
  {path: 'order-list', component: OrderListComponent},

  {path:'order-detail/:id', component: OrderDetailComponent}

]

@NgModule({
  declarations: [],
  imports:
    [RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule { }
