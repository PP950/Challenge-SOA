package br.com.ford.fordcare.repository;

import br.com.ford.fordcare.entity.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
