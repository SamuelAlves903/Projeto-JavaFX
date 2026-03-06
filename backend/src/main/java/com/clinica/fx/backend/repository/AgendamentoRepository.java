package com.clinica.fx.backend.repository;

import com.clinica.fx.backend.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
