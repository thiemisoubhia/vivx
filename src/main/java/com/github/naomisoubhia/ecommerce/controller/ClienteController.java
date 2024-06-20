package com.github.naomisoubhia.ecommerce.controller;

import com.github.naomisoubhia.ecommerce.controller.dto.ClienteDTO;
import com.github.naomisoubhia.ecommerce.model.Cliente;
import com.github.naomisoubhia.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable String id) {
        try {
            Cliente cliente = clienteService.findById(id);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDTO> getClienteWithProducts(@PathVariable String clienteId) {
        Cliente cliente = clienteService.findById(clienteId);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        ClienteDTO clienteDTO = convertToClienteDTO(cliente);
        return ResponseEntity.ok(clienteDTO);
    }
    
    private ClienteDTO convertToClienteDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setClienteId(cliente.getClienteId());
        dto.setName(cliente.getName());
        dto.setEmail(cliente.getEmail());
        dto.setProducts(cliente.getProducts().stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList()));
        return dto;
    }
}
