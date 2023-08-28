import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Clients } from 'src/app/interfaces/clients';
import { ClientsService } from 'src/app/services/clients.service';

@Component({
  selector: 'app-update-client-admin',
  templateUrl: './update-client-admin.component.html',
  styleUrls: ['./update-client-admin.component.scss']
})
export class UpdateClientAdminComponent implements OnInit{
  updateClientForm!: FormGroup
  id!: number;
  client!: Clients

  constructor(private clientService: ClientsService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['clientId'];
    this.clientService.getClientById(this.id).subscribe((data) => {
      this.client = data;
    })

    this.updateClientForm = new FormGroup({
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required])
    })
  }

  updatedFormSubmit() {
    console.log("Input value is: " + this.updateClientForm.value)
    this.clientService.updateClientById(this.id, this.updateClientForm.value).subscribe(data => {
      console.log("Product data updated successfully.")
      this.router.navigateByUrl('/admin');
    })
  }
}
