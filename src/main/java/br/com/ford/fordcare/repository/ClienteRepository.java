package br.com.ford.fordcare.repository;

import br.com.ford.fordcare.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
