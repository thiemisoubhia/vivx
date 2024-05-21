package com.github.naomisoubhia.ecommerce.service;

import com.github.naomisoubhia.ecommerce.model.Client;
import com.github.naomisoubhia.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClienteRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(String id) {
        return clientRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(String id) {
        clientRepository.deleteById(Long.valueOf(id));
    }
}
