import { Products } from './../../models/products';
import { ProductsService } from './../../services/products.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css'],
})
export class ListProductsComponent implements OnInit {
  products: Products[] = [];
  filters = {
    keyword: '',
    sortBy: 'Name',
  };
  constructor(private _productService: ProductsService) {}

  ngOnInit(): void {
    this.listProducts();
  }

  listProducts() {
    this._productService
      .getProducts()
      .subscribe((data) => (this.products = this.filterProducts(data)));
  }
  filterProducts(products: Products[]) {
    return products.filter((e) => {
      return e.category
        .toLowerCase()
        .includes(this.filters.keyword.toLowerCase());
    });
  }
}
