import { Component, OnInit } from '@angular/core';
import { CustomOrderService } from './custom-order-service';
import { CustomOrderDTO } from './custom-order-dto';

@Component({
  selector: 'app-custom-order-list',
  templateUrl: './custom-order-list.component.html',
  styleUrls: ['./custom-order-list.component.css']
})
export class CustomOrderListComponent implements OnInit {
  orders: CustomOrderDTO[] = [];
  orderStatusFilter: string = '';

  constructor(private customOrderService: CustomOrderService) {}

  ngOnInit(): void {
    this.fetchOrders();
  }

  fetchOrders(status?: string): void {
    this.customOrderService.getOrders(status).subscribe((orders) => {
      this.orders = orders;
    });
  }
    applyFilter(): void {
    this.fetchOrders(this.orderStatusFilter);
  }
}
