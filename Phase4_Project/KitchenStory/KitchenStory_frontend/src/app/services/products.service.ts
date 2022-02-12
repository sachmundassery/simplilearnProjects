import { Products } from './../models/products';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  private getUrl1: string = 'http://localhost:8080/products/getAllItems';
  private getUrl2: string = 'http://localhost:8080/products/addItem';
  private getUrl3: string = 'http://localhost:8080/products/getProduct';
  private getUrl4: string = 'http://localhost:8080/products/deleteProduct';
  constructor(private _httpClient: HttpClient) {}

  getProducts(): Observable<Products[]> {
    return this._httpClient
      .get<Products[]>(this.getUrl1)
      .pipe(map((response) => response));
  }

  getProduct(id: number): Observable<Products> {
    return this._httpClient
      .get<Products>(`${this.getUrl3}/${id}`)
      .pipe(map((response) => response));
  }

  saveProduct(product: Products): Observable<Products> {
    console.log('----inside service ---', product.category);

    return this._httpClient.post<Products>(this.getUrl2, product);
  }
  deleteProduct(id: number): Observable<any> {
    return this._httpClient.delete(`${this.getUrl4}/${id}`, {
      responseType: 'text',
    });
  }
}
