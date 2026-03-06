package com.clinica.fx.backend.repository;

import com.clinica.fx.backend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
