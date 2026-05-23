package br.com.ford.fordcare.repository;

import br.com.ford.fordcare.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
