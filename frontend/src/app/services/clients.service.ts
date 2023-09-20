import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Clients } from '../interfaces/clients';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  private serverBaseUrl = "server/api/v1/clients";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json' // datele trimise mai departe catre server sunt in format JSON
    })
  }

  constructor(private httpClient: HttpClient) { }

  // HTTP GET REQUEST
  getAllClients(): Observable<Clients[]> {
    return this.httpClient.get<Clients[]>(this.serverBaseUrl + "/getAllClients");
  }

  // HTTP GET BY ID REQUEST [ex: Product Info Page] -> incarcam informatiile dupa ID
  getClientById(id: any): Observable<Clients> {
    return this.httpClient.get<Clients>(this.serverBaseUrl + "/getClientById/" + id)
  }

  // HTTP POST REQUEST [ex: Add New Product]
  createClient(clients: any): Observable<Clients> {
    return this.httpClient.post<Clients>(this.serverBaseUrl + "/addClient", JSON.stringify(clients), this.httpOptions)
  }

  // HTTP PUT REQUEST
  updateClientById(id: any, clients: any): Observable<Clients> {
    return this.httpClient.put<Clients>(this.serverBaseUrl + "/updateClient/" + id, JSON.stringify(clients), this.httpOptions);
  }

  // HTTP DELETE REQUEST
  deleteClientById(id: number): Observable<Clients> {
    return this.httpClient.delete<Clients>(this.serverBaseUrl + "/deleteClientById/" + id);
  }
}
