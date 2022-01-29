import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from "@angular/material/icon";
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './components/content/home/home.component';
import { PanierComponent } from './components/content/panier/panier.component';
import { FooterComponent } from './components/footer/footer.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { MaterialModule } from './app.material.module';
import { CustomLoginPopupComponent } from './components/custom-login-popup/custom-login-popup.component';
import { CustomRegisterPopupComponent } from './components/custom-register-popup/custom-register-popup.component';
import { ContactusComponent } from './components/contactus/contactus.component';
import { ProductPageComponent } from './components/content/product-page/product-page.component';
import { AllProductComponent } from './components/content/all-product/all-product.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    PanierComponent,
    FooterComponent,
    SidebarComponent,
    CustomLoginPopupComponent,
    CustomRegisterPopupComponent,
    ContactusComponent,
    ProductPageComponent,
    AllProductComponent,
  ],
  imports: [
    BrowserModule,
    FlexLayoutModule,
    NgbModule,
    MatSliderModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
