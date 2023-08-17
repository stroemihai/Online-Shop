import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/interfaces/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit{
  productsList:Product[] = [];

  constructor(private productService: ProductService){}

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe((data:Product[]) => {
      this.productsList = data;
      console.log("Products List: " + JSON.stringify(this.productsList)); 
    })
  }

  removeProductById(id:number){
    this.productService.deleteProductById(id).subscribe((data)=>{
      this.productsList = this.productsList.filter(prod => prod.id !== id);
      console.log("Product with id " + id + " deleted successfully.");
    })
  }
}
