import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ModelsComponent } from './components/models/models.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ProductsComponent } from './components/products/products.component';
import { ProductInfoComponent } from './components/product-info/product-info.component';
import { AddProductAdminComponent } from './components/add-product-admin/add-product-admin.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UpdateProductAdminComponent } from './components/update-product-admin/update-product-admin.component';
import { TwoHundredEightComponent } from './components/all-models/two-hundred-eight/two-hundred-eight.component';
import { TwoThousandEightComponent } from './components/all-models/two-thousand-eight/two-thousand-eight.component';
import { ThreeHundredEightComponent } from './components/all-models/three-hundred-eight/three-hundred-eight.component';
import { FourHundredEightComponent } from './components/all-models/four-hundred-eight/four-hundred-eight.component';
import { HistoryComponent } from './components/history/history.component';
import { ClientsComponent } from './components/clients/clients.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CarouselComponent,
    ModelsComponent,
    ProductsComponent,
    ProductInfoComponent,
    AddProductAdminComponent,
    UpdateProductAdminComponent,
    TwoHundredEightComponent,
    TwoThousandEightComponent,
    ThreeHundredEightComponent,
    FourHundredEightComponent,
    HistoryComponent,
    ClientsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
