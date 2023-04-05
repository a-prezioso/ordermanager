import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomOrderListComponent } from './custom-order-list/custom-order-list.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomOrderService } from './custom-order-list/custom-order-service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CustomOrderListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CustomOrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
