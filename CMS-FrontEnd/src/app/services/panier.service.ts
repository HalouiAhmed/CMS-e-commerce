import { Panier } from './../models/panier';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class PanierService {

  constructor( private http :HttpClient ) { }

  getPanier(): Observable<Panier>{
     let url ='http://localhost:4200/panier';
    return this.http.get<Panier>(url);
    


  }
}
