import { Products } from './../../models/products';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductsService } from './../../services/products.service';
@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css'],
})
export class AddProductsComponent implements OnInit {
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

  saveProduct() {
    console.log('---- inside save product');

    this._productService.saveProduct(this.product).subscribe((data) => {
      alert('product added successfully');
      this._router.navigateByUrl('/editProducts');
    });
  }

  deleteProduct(id: number) {
    this._productService.deleteProduct(id).subscribe((data) => {
      alert('product deleted successfully');
      this._router.navigateByUrl('/editProducts');
    });
  }
}
