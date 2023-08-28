import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Clients } from 'src/app/interfaces/clients';
import { ClientsService } from 'src/app/services/clients.service';

@Component({
  selector: 'app-client-info',
  templateUrl: './client-info.component.html',
  styleUrls: ['./client-info.component.scss']
})
export class ClientInfoComponent implements OnInit{

  id!: number;
  clientData!: Clients

  constructor(private clientService: ClientsService, private activatedRoute: ActivatedRoute) { //ActivatedRoute -> extrage id-ul din url

  }

  ngOnInit(): void {
    this.getClientInfo();
  }

  getClientInfo() {
    this.id = this.activatedRoute.snapshot.params['clientId'];
    this.clientService.getClientById(this.id).subscribe((prod: Clients) => {
      this.clientData = prod;
      console.log("Product info: " + JSON.stringify(this.clientData))
    })
  }

}
