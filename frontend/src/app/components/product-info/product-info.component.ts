import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/interfaces/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.scss']
})
export class ProductInfoComponent implements OnInit{
  id!: number;
  productData!: Product

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) { //ActivatedRoute -> extrage id-ul din url

  }

  ngOnInit(): void {
    this.getProductInfo();
  }

  getProductInfo(){
    this.id = this.activatedRoute.snapshot.params['productId'];
    this.productService.getProductById(this.id).subscribe((prod: Product) => {
      this.productData = prod;
      console.log("Product info: " + JSON.stringify(this.productData))
    })
  }

}
