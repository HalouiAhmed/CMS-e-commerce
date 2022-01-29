import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactusComponent } from './components/contactus/contactus.component';
import { AllProductComponent } from './components/content/all-product/all-product.component';
import { HomeComponent } from './components/content/home/home.component';
import { PanierComponent } from './components/content/panier/panier.component';
import { ProductPageComponent } from './components/content/product-page/product-page.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'panier',
    component: PanierComponent
  },
  {
    path: 'contact',
    component: ContactusComponent
  },
  {
    path: 'product-page',
    component: ProductPageComponent
  },
  {
    path: 'all-product',
    component: AllProductComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
