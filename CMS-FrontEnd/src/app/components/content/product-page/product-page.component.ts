import { Product } from './../../../models/product-home';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductPageService } from 'src/app/services/product-page.service';
import { convertPropertyBindingBuiltins } from '@angular/compiler/src/compiler_util/expression_converter';
import { Image } from 'src/app/models/image';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {

  product:Product
  chosenImg : Image;

  constructor(private productpageservice: ProductPageService) { 

  }
  ngOnInit() {
    // this.productpageservice.getProduct().subscribe(
    //   result => {
    //     this.product = result
    //   }
    // )
    this.product={
      "id" : 1,
      "name" : "NOM DE PRODUIT",
      "price" : 152,
      "category" : "categorie",
      "description" : "description du produit",
      "images": [
        {
          "id":1,
          "url": "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15a.jpg"
        },   
        {
          "id":2,
          "url": "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
        }, 
        {
          "id":3,
          "url": "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13a.jpg"
        },
        {
          "id":4,
          "url": "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/14a.jpg"
        },

      ]
    }

    this.chosenImg = this.product.images[0];
  }

  changeImg(image){
    this.chosenImg = image;
  }
}

