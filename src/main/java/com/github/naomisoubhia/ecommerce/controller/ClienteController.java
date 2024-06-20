@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<SearchedCliente> listAll() {
        return clienteService.list().stream()
                .map(SearchedCliente::toDto)
                .collect(Collectors.toList());
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
        
        // Mantém o ID do cliente
        // cliente.setCodigo_cliente(codigo_cliente); <-- Removido
        
        // Atualiza apenas os outros campos
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
