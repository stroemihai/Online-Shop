package com.peugeot.service;

import com.peugeot.dto.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getAllClients();
    ClientDto getClientById(Integer id);
    ClientDto saveClient(ClientDto clientDto);
    ClientDto updateClientById(ClientDto clientDto, Integer id);
    void deleteClientById(Integer id);


}
