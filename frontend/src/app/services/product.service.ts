import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../interfaces/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private serverBaseUrl = "server/api/v1/products";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json' // datele trimise mai departe catre server sunt in format JSON
    })
  }

  constructor(private httpClient: HttpClient) { }

  // HTTP GET REQUEST
  getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.serverBaseUrl + "/allProducts");
  }

  // get product by id
  // HTTP GET BY ID REQUEST [ex: Product Info Page] -> incarcam informatiile dupa ID
  getProductById(id: any): Observable<Product> {
    return this.httpClient.get<Product>(this.serverBaseUrl + "/getProductById/" + id)
  }

  // HTTP POST REQUEST [ex: Add New Product]
  createProduct(product: any): Observable<Product> {
    return this.httpClient.post<Product>(this.serverBaseUrl + "/addProduct", JSON.stringify(product), this.httpOptions)
  }

  // update product
  // HTTP PUT REQUEST
  updateProductById(id: any, product: any): Observable<Product> {
    return this.httpClient.put<Product>(this.serverBaseUrl + "/updateProduct/" + id, JSON.stringify(product), this.httpOptions);
  }

  // HTTP DELETE REQUEST
  deleteProductById(id: number): Observable<Product> {
    return this.httpClient.delete<Product>(this.serverBaseUrl + "/deleteProductById/" + id);
  }
}
