import { Component, OnInit } from '@angular/core';
import { Clients } from 'src/app/interfaces/clients';
import { ClientsService } from 'src/app/services/clients.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.scss']
})
export class ClientsComponent implements OnInit{
  clientsList:Clients[] = [];

  constructor(private clientsService: ClientsService){}

  ngOnInit(): void {
    this.clientsService.getAllClients().subscribe((data:Clients[]) => {
      this.clientsList = data;
      console.log("Clients List: " + JSON.stringify(this.clientsList)); 
    })
  }

  removeProductById(id:number){
    this.clientsService.deleteClientById(id).subscribe((data)=>{
      this.clientsList = this.clientsList.filter(prod => prod.id !== id);
      console.log("Client with id " + id + " deleted successfully.");
    })
  }
}
