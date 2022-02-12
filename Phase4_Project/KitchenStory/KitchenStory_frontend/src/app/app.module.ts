import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ListProductsComponent } from './components/list-products/list-products.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { EditProductsComponent } from './components/edit-products/edit-products.component';
import { AddProductsComponent } from './components/add-products/add-products.component';
import { BuyProductsComponent } from './components/buy-products/buy-products.component';
import { PaymentComponent } from './components/payment/payment.component';

const routers: Routes = [
  {
    path: 'listProducts',
    component: ListProductsComponent,
  },
  {
    path: 'editProducts',
    component: EditProductsComponent,
  },
  {
    path: 'editProducts/:id',
    component: AddProductsComponent,
  },

  {
    path: 'buyProduct/:id',
    component: BuyProductsComponent,
  },
  {
    path: 'addProducts',
    component: AddProductsComponent,
  },
  {
    path: 'admin',
    component: AdminLoginComponent,
  },
  {
    path: 'payment/:id',
    component: PaymentComponent,
  },
  {
    path: 'admin/changePassword',
    component: ChangePasswordComponent,
  },
];
@NgModule({
  declarations: [
    AppComponent,
    ListProductsComponent,
    AdminLoginComponent,
    ChangePasswordComponent,
    EditProductsComponent,
    AddProductsComponent,
    BuyProductsComponent,
    PaymentComponent,
  ],
  imports: [
    RouterModule.forRoot(routers),
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
