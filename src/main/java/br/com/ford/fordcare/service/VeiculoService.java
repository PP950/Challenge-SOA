package br.com.ford.fordcare.service;

import br.com.ford.fordcare.dto.VeiculoRequestDTO;
import br.com.ford.fordcare.dto.VeiculoResponseDTO;
import br.com.ford.fordcare.entity.Cliente;
import br.com.ford.fordcare.entity.Veiculo;
import br.com.ford.fordcare.repository.ClienteRepository;
import br.com.ford.fordcare.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    private final ClienteRepository clienteRepository;

    public VeiculoService(
            VeiculoRepository repository,
            ClienteRepository clienteRepository
    ) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    public VeiculoResponseDTO salvar(VeiculoRequestDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Veiculo veiculo = new Veiculo();

        veiculo.setModelo(dto.modelo());
        veiculo.setDataCompra(dto.dataCompra());
        veiculo.setEspecificacoes(dto.especificacoes());

        veiculo.setCliente(cliente);

        Veiculo salvo = repository.save(veiculo);

        return new VeiculoResponseDTO(
                salvo.getId(),
                salvo.getModelo(),
                salvo.getDataCompra(),
                salvo.getEspecificacoes(),
                salvo.getCliente().getClienteId(),
                salvo.getCliente().getNome()
        );
    }

    public List<VeiculoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(veiculo -> new VeiculoResponseDTO(
                        veiculo.getId(),
                        veiculo.getModelo(),
                        veiculo.getDataCompra(),
                        veiculo.getEspecificacoes(),
                        veiculo.getCliente().getClienteId(),
                        veiculo.getCliente().getNome()
                ))
                .toList();
    }

    public VeiculoResponseDTO atualizar(Long id, VeiculoRequestDTO dto) {

        Veiculo veiculo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        veiculo.setModelo(dto.modelo());
        veiculo.setDataCompra(dto.dataCompra());
        veiculo.setEspecificacoes(dto.especificacoes());

        Veiculo atualizado = repository.save(veiculo);

        return new VeiculoResponseDTO(
                atualizado.getId(),
                atualizado.getModelo(),
                atualizado.getDataCompra(),
                atualizado.getEspecificacoes(),
                atualizado.getCliente().getClienteId(),
                atualizado.getCliente().getNome()
        );
    }

    public void deletar(Long id) {

        Veiculo veiculo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        repository.delete(veiculo);
    }
}