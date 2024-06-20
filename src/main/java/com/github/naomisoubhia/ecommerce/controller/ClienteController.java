package com.github.naomisoubhia.ecommerce.controller;

import com.github.naomisoubhia.ecommerce.controller.dto.cliente.ClienteRequestCreate;
import com.github.naomisoubhia.ecommerce.controller.dto.cliente.ClienteRequestUpdate;
import com.github.naomisoubhia.ecommerce.controller.dto.cliente.SearchedCliente;
import com.github.naomisoubhia.ecommerce.model.Cliente;
import com.github.naomisoubhia.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<SearchedCliente> listAll() {
        List<SearchedCliente> result = clienteService.list().stream()
                .map(SearchedCliente::toDto)
                .collect(Collectors.toList());
        return result;
    }

    @PostMapping
    public Cliente create(@RequestBody ClienteRequestCreate dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCep(dto.getCep());
        cliente.setInscricao_federal(dto.getInscricao_federal());
        return clienteService.save(cliente);
    }

    @PutMapping("/{codigo_cliente}")
    public Cliente update(@PathVariable Long codigo_cliente, @RequestBody ClienteRequestUpdate dto) {
        Cliente cliente = clienteService.findById(codigo_cliente);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado com o código: " + codigo_cliente);
        }
        cliente.setNome(dto.getNome());
        cliente.setCep(dto.getCep());
        cliente.setInscricao_federal(dto.getInscricao_federal());
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{codigo_cliente}")
    public void delete(@PathVariable Long codigo_cliente) {
        clienteService.delete(codigo_cliente);
    }
}
