package com.clinica.fx.backend.repository;

import com.clinica.fx.backend.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByServicoIdAndAtivoTrue(Long idServico);
}
