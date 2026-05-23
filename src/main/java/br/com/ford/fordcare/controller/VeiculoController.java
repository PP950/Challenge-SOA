package br.com.ford.fordcare.controller;

import br.com.ford.fordcare.dto.VeiculoRequestDTO;
import br.com.ford.fordcare.dto.VeiculoResponseDTO;
import br.com.ford.fordcare.service.VeiculoService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping
    public VeiculoResponseDTO salvar(@RequestBody @Valid VeiculoRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<VeiculoResponseDTO> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public VeiculoResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid VeiculoRequestDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}