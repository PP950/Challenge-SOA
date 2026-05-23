package br.com.ford.fordcare.controller;

import br.com.ford.fordcare.dto.ClienteRequestDTO;
import br.com.ford.fordcare.dto.ClienteResponseDTO;
import br.com.ford.fordcare.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ClienteResponseDTO salvar(
            @RequestBody @Valid ClienteRequestDTO dto
    ) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ClienteRequestDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}