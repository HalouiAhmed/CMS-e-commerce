import { Product } from './../models/product-home';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductPageService {
  constructor(private http: HttpClient) { 

  }
  getProduct(): Observable<Product> {
      let url ='http://localhost/test';
      return this.http.get<Product>(url);
    
  }
}

