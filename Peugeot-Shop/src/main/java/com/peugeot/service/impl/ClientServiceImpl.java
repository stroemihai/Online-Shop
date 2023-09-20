package com.peugeot.service.impl;

import com.peugeot.dto.ClientDto;
import com.peugeot.exception.ClientNotFoundException;
import com.peugeot.model.Client;
import com.peugeot.repository.ClientRepository;
import com.peugeot.service.ClientService;
import com.peugeot.utils.EntityDtoConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(EntityDtoConvertor::toDto).collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id));
        return EntityDtoConvertor.toDto(client);
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        Client client = EntityDtoConvertor.toEntity(clientDto);
        Client savedClient = clientRepository.save(client);
        return EntityDtoConvertor.toDto(savedClient);
    }

    @Override
    public ClientDto updateClientById(ClientDto clientDto, Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id));

        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setAddress(clientDto.getAddress());
        client.setPhone(clientDto.getPhone());
        Client updatedClient = clientRepository.save(client);
        return EntityDtoConvertor.toDto(updatedClient);
    }

    @Override
    public void deleteClientById(Integer id) {
        clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Customer not found with id: " + id));
        clientRepository.deleteById(id);
    }


}
