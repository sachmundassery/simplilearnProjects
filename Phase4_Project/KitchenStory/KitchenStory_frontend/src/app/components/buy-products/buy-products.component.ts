import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from 'src/app/models/products';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-buy-products',
  templateUrl: './buy-products.component.html',
  styleUrls: ['./buy-products.component.css'],
})
export class BuyProductsComponent implements OnInit {
  product: Products = new Products();
  constructor(
    private _productService: ProductsService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const isIdPresent = this._activatedRoute.snapshot.paramMap.has('id');
    if (isIdPresent) {
      const id = +this._activatedRoute.snapshot.paramMap.get('id')!;
      this._productService
        .getProduct(id)
        .subscribe((data) => (this.product = data));
    }
  }
}
