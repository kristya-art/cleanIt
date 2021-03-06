import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSliderModule} from "@angular/material/slider";
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import {MatListModule} from "@angular/material/list";
import {MatFormField, MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import { OrderListComponent } from './order-list/order-list.component';
import {RouterModule} from "@angular/router";
import { OrderDetailComponent } from './order-detail/order-detail.component';
import { AppRoutingModule } from './app-routing.module';
import {MatTableModule} from "@angular/material/table";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatPaginatorModule} from '@angular/material/paginator';
import { CustomerListComponent } from './customer-list/customer-list.component';
import {MatIconModule} from "@angular/material/icon";
import {MatGridListModule} from "@angular/material/grid-list";
import { ProductListComponent } from './product-list/product-list.component';
import { ProductAlertsComponent } from './product-alerts/product-alerts.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CartComponent } from './cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    OrderListComponent,
    OrderDetailComponent,
    CustomerListComponent,
    ProductListComponent,
    ProductAlertsComponent,
    ProductDetailsComponent,
    CartComponent,
  ],
    imports: [
        BrowserModule,
        FormsModule,
        BrowserAnimationsModule,
        MatSliderModule,
        HttpClientModule,
        MatButtonModule,
        MatCardModule,
        MatToolbarModule,
        MatListModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonToggleModule,
        RouterModule,
        AppRoutingModule,
        MatTableModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatPaginatorModule,
        MatIconModule,
        MatGridListModule,
        RouterModule.forRoot([
          {path: 'products', component: ProductListComponent},
          {path: 'products/:productId', component: ProductDetailsComponent},
          {path: 'cart', component: CartComponent}
        ])


    ],
  exports:[
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
