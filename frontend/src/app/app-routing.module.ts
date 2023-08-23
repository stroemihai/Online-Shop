import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ModelsComponent } from './components/models/models.component';
import { CommonModule } from '@angular/common';
import { CarouselComponent } from './components/carousel/carousel.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ProductsComponent } from './components/products/products.component';
import { ProductInfoComponent } from './components/product-info/product-info.component';
import { AddProductAdminComponent } from './components/add-product-admin/add-product-admin.component';
import { UpdateProductAdminComponent } from './components/update-product-admin/update-product-admin.component';
import { TwoHundredEightComponent } from './components/all-models/two-hundred-eight/two-hundred-eight.component';
import { TwoThousandEightComponent } from './components/all-models/two-thousand-eight/two-thousand-eight.component';
import { ThreeHundredEightComponent } from './components/all-models/three-hundred-eight/three-hundred-eight.component';
import { FourHundredEightComponent } from './components/all-models/four-hundred-eight/four-hundred-eight.component';
import { HistoryComponent } from './components/history/history.component';
import { ClientsComponent } from './components/clients/clients.component';

const routes: Routes = [
  {
    path: "",
    component: CarouselComponent
  },
  {
    path: "",
    component: HeaderComponent
  },
  {
    path: "",
    component: FooterComponent
  },
  {
    path: "history",
    component: HistoryComponent
  },
  {
    path: "models",
    component: ModelsComponent
  },
  {
    path: "products",
    component: ProductsComponent
  },
  {
    path: "product/info/:productId",
    component: ProductInfoComponent
  },
  {
    path: "products/add-product",
    component: AddProductAdminComponent
  },
  {
    path: "product/edit/:productId",
    component: UpdateProductAdminComponent
  },
  {
    path: "models/208",
    component: TwoHundredEightComponent
  },
  {
    path: "models/2008",
    component: TwoThousandEightComponent
  },
  {
    path: "models/308",
    component: ThreeHundredEightComponent
  },
  {
    path: "models/408",
    component: FourHundredEightComponent
  },
  {
    path: "clients",
    component: ClientsComponent
  }
  
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
