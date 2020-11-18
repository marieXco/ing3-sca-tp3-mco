import { Component } from '@angular/core';
import {NgForm} from "@angular/forms";
import {OrderService} from "./service/OrderService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'episen-sca-mco-front';

  constructor(private orderService: OrderService){}

  onFormSubmit(orderForm: NgForm) {
    let order = orderForm.controls['order'].value;
    console.log(order);
    this.orderService.addOrder(order);

  }

}
