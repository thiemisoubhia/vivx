package com.github.naomisoubhia.ecommerce.controller;

import com.github.naomisoubhia.ecommerce.controller.dto.ClientDTO;
import com.github.naomisoubhia.ecommerce.controller.dto.ProductDTO;
import com.github.naomisoubhia.ecommerce.model.Client;
import com.github.naomisoubhia.ecommerce.model.Product;
import com.github.naomisoubhia.ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        try {
            Client client = clientService.findById(id);
            return ResponseEntity.ok(client);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientWithProducts(@PathVariable String clientId) {
        Client client = clientService.findById(clientId);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        ClientDTO clientDTO = convertToClientDTO(client);
        return ResponseEntity.ok(clientDTO);
    }

    private ClientDTO convertToClientDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setClientId(client.getClientId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        dto.setProducts(client.getProducts().stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setProductType(product.getProductType());
        dto.setStatus(product.getStatus());
        dto.setStartDate(product.getStartDate());
        dto.setSubscriptionType(product.getSubscriptionType());
        return dto;
    }
}
