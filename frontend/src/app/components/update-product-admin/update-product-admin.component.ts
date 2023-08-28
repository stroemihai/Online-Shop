import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/interfaces/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-update-product-admin',
  templateUrl: './update-product-admin.component.html',
  styleUrls: ['./update-product-admin.component.scss']
})
export class UpdateProductAdminComponent implements OnInit {
  updateProductForm!: FormGroup
  id!: number;
  product!: Product

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['productId'];
    this.productService.getProductById(this.id).subscribe((data) => {
      this.product = data;
    })

    this.updateProductForm = new FormGroup({
      brand: new FormControl('', [Validators.required]),
      model: new FormControl('', [Validators.required]),
      fuelType: new FormControl('', [Validators.required]),
      hp: new FormControl('', [Validators.required]),
      engine: new FormControl('', [Validators.required]),
      year: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required])
    })
  }

  updatedFormSubmit() {
    console.log("Input value is: " + this.updateProductForm.value)
    this.productService.updateProductById(this.id, this.updateProductForm.value).subscribe(data => {
      console.log("Product data updated successfully.")
      this.router.navigateByUrl('/admin');
    })
  }
}
