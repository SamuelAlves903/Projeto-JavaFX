package com.clinica.fx.backend.repository;

import com.clinica.fx.backend.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByMedicoIdAndServicoIdAndData(Long medicoId, Long servicoId, LocalDate data);
}
