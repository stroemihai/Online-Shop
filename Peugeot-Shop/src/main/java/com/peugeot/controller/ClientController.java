package com.peugeot.controller;

import com.peugeot.dto.ClientDto;
import com.peugeot.service.ClientService;
import com.peugeot.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controller + ResponseBody -> ne returneaza raspunsul in format JSON
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping(value = "/addClient")
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto){
        //cream produsul
        ClientDto savedClient = clientService.saveClient(clientDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("message", "Client created successfully.")
                .body(savedClient);
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<ClientDto>> getAllClients(){
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable("clientId") Integer clientId){
        ClientDto clientById = clientService.getClientById(clientId);
        return new ResponseEntity<>(clientById, HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable("clientId") Integer clientId, @RequestBody ClientDto clientDto){
        ClientDto updatedClient = clientService.updateClientById(clientDto, clientId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("message", "Client updated successfully.")
                .body(updatedClient);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("clientId") Integer clientId){
        clientService.deleteClientById(clientId);
        return ResponseEntity.noContent().header("message", "Client deleted successfully.").build();
    }


}
