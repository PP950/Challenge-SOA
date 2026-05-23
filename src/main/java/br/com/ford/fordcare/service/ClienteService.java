package br.com.ford.fordcare.service;

import br.com.ford.fordcare.dto.ClienteRequestDTO;
import br.com.ford.fordcare.dto.ClienteResponseDTO;
import br.com.ford.fordcare.entity.Cliente;
import br.com.ford.fordcare.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());

        Cliente salvo = repository.save(cliente);

        return new ClienteResponseDTO(
                salvo.getClienteId(),
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getTelefone(),
                salvo.getCnh()
        );
    }

    public List<ClienteResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(cliente -> new ClienteResponseDTO(
                        cliente.getClienteId(),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getTelefone(),
                        cliente.getCnh()
                ))
                .toList();
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());

        Cliente atualizado = repository.save(cliente);

        return new ClienteResponseDTO(
                atualizado.getClienteId(),
                atualizado.getNome(),
                atualizado.getEmail(),
                atualizado.getTelefone(),
                atualizado.getCnh()
        );
    }

    public void deletar(Long id) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        repository.delete(cliente);
    }
}