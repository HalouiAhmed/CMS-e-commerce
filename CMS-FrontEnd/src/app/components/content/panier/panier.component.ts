import { ProductPanier } from './../../../models/product.panier';
import { Panier } from './../../../models/panier';
import { PanierService } from './../../../services/panier.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  panier:Panier;
  totalArticls = 0;

  constructor(private PanierService:PanierService) { }

  ngOnInit()  {
    this.panier=
        {
          "id":1,
          "productsPanier": [
            {
              "product":
                {
                  "id": 1,
                  "price": 55,
                  "name": "JACKET JOTEX",
                  "category": "Jacket",
                  "description": "description du produit 1",
                  "images":[
                    {
                      "id":1,
                      "url":"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
                    }
                  ],
                },
              "quantity": 1
            },
            {
              "product":
                {
                  "id": 23,
                  "price": 5000,
                  "name": "jacket cuire zara",
                  "category": "Jacket",
                  "description": "description du produit 2",
                  "images":[
                    {
                      "id":1,
                      "url":"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15a.jpg"
                    }
                  ],
                },
              "quantity": 55
            }
          ]
        }

    for(let productPanier of this.panier.productsPanier){
      this.totalArticls = this.totalArticls += productPanier.quantity
    }
  }

  stepDown(index){
    if(this.panier.productsPanier[index].quantity>0){
      this.panier.productsPanier[index].quantity--;
      this.totalArticls--;
    }
  }

  stepUp(index){
    this.panier.productsPanier[index].quantity++;
    this.totalArticls++
  }

}
