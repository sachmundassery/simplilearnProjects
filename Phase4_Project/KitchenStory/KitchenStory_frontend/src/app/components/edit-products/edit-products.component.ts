import { Component, OnInit } from '@angular/core';
import { Products } from './../../models/products';
import { ProductsService } from './../../services/products.service';

@Component({
  selector: 'app-edit-products',
  templateUrl: './edit-products.component.html',
  styleUrls: ['./edit-products.component.css'],
})
export class EditProductsComponent implements OnInit {
  products: Products[] = [];
  constructor(private _productService: ProductsService) {}

  ngOnInit(): void {
    this.listProducts();
  }

  listProducts() {
    this._productService
      .getProducts()
      .subscribe((data) => (this.products = data));
  }
}
