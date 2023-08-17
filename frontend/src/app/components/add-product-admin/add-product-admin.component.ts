import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product-admin',
  templateUrl: './add-product-admin.component.html',
  styleUrls: ['./add-product-admin.component.scss']
})
export class AddProductAdminComponent implements OnInit{

  newProductForm!: FormGroup;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.newProductForm = new FormGroup({
      brand: new FormControl('', [Validators.required]),
      model: new FormControl('', [Validators.required]),
      fuelType: new FormControl('', [Validators.required]),
      hp: new FormControl('', [Validators.required]),
      engine: new FormControl('', [Validators.required]),
      year: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required])
    })

  }

  // definim functia de save product
  submitFormData() {
    this.productService.createProduct(this.newProductForm.value).subscribe(data => {
      this.newProductForm.reset();
      console.log("New product added successfully.");
    })
  }

}
