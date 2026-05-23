package br.com.ford.fordcare.controller;

import br.com.ford.fordcare.dto.ManutencaoRequestDTO;
import br.com.ford.fordcare.dto.ManutencaoResponseDTO;
import br.com.ford.fordcare.dto.PrevisaoManutencaoDTO;
import br.com.ford.fordcare.service.ManutencaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    private final ManutencaoService service;

    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    @PostMapping
    public ManutencaoResponseDTO salvar(
            @RequestBody ManutencaoRequestDTO dto
    ) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<ManutencaoResponseDTO> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public ManutencaoResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody ManutencaoRequestDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/previsao/{veiculoId}")
    public PrevisaoManutencaoDTO prever(@PathVariable Long veiculoId) {
        return service.preverManutencao(veiculoId);
    }
}