package br.com.ford.fordcare.service;

import br.com.ford.fordcare.dto.ManutencaoRequestDTO;
import br.com.ford.fordcare.dto.ManutencaoResponseDTO;
import br.com.ford.fordcare.dto.PrevisaoManutencaoDTO;
import br.com.ford.fordcare.entity.Manutencao;
import br.com.ford.fordcare.entity.Veiculo;
import br.com.ford.fordcare.repository.ManutencaoRepository;
import br.com.ford.fordcare.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {

    private ManutencaoRepository manutencaoRepository;
    private VeiculoRepository veiculoRepository;

    public ManutencaoService(ManutencaoRepository manutencaoRepository, VeiculoRepository veiculoRepository){
        this.manutencaoRepository = manutencaoRepository;
        this.veiculoRepository = veiculoRepository;
    }


    public ManutencaoResponseDTO salvar(ManutencaoRequestDTO dto){
        Veiculo veiculo = veiculoRepository.findById(dto.veiculoId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        Manutencao manutencao = new Manutencao();

        manutencao.setDescricao(dto.descricao());
        manutencao.setData(dto.data());
        manutencao.setQuilometragem(dto.quilometragem());
        manutencao.setCusto(dto.custo());
        manutencao.setVeiculo(veiculo);
        Manutencao salva = manutencaoRepository.save(manutencao);

        return new ManutencaoResponseDTO(
                salva.getManutencaoId(),
                salva.getDescricao(),
                salva.getData(),
                salva.getQuilometragem(),
                salva.getCusto(),
                salva.getVeiculo().getId(),
                salva.getVeiculo().getModelo()
        );
    }

    public List<ManutencaoResponseDTO>listarTodos(){
        return manutencaoRepository.findAll().stream().map(manutencao -> new ManutencaoResponseDTO(
                manutencao.getManutencaoId(),
                manutencao.getDescricao(),
                manutencao.getData(),
                manutencao.getQuilometragem(),
                manutencao.getCusto(),
                manutencao.getVeiculo().getId(),
                manutencao.getVeiculo().getModelo()
        )).toList();
    }

    public ManutencaoResponseDTO atualizar(Long id,ManutencaoRequestDTO dto){
        Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));
        Veiculo veiculo = veiculoRepository.findById(dto.veiculoId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        manutencao.setDescricao(dto.descricao());
        manutencao.setData(dto.data());
        manutencao.setQuilometragem(dto.quilometragem());
        manutencao.setCusto(dto.custo());
        manutencao.setVeiculo(veiculo);

        Manutencao atualizada = manutencaoRepository.save(manutencao);
        return new ManutencaoResponseDTO(
                atualizada.getManutencaoId(),
                atualizada.getDescricao(),
                atualizada.getData(),
                atualizada.getQuilometragem(),
                atualizada.getCusto(),
                atualizada.getVeiculo().getId(),
                atualizada.getVeiculo().getModelo()
        );
    }

    public void deletar(Long id) {

        Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));

        manutencaoRepository.delete(manutencao);
    }

    public PrevisaoManutencaoDTO preverManutencao(Long id) {

        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        List<Manutencao> manutencoes = veiculo.getManutencoes();

        double soma = manutencoes.stream()
                .mapToDouble(Manutencao::getCusto)
                .sum();

        int quantidade = manutencoes.size();

        double media = quantidade > 0 ? soma / quantidade : 0;

        double ultimaKm = manutencoes.get(manutencoes.size() - 1)
                .getQuilometragem();

        double fatorDesgaste = ultimaKm / 100000;

        double previsao = media + (media * fatorDesgaste);

        previsao = Math.round(previsao * 100.0) / 100.0;

        return new PrevisaoManutencaoDTO(
                veiculo.getModelo(),
                quantidade,
                media,
                previsao
        );
    }
}
