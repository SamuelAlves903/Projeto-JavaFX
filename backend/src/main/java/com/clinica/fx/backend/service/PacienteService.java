package com.clinica.fx.backend.service;

import com.clinica.fx.backend.model.Paciente;
import com.clinica.fx.backend.repository.PacienteRepository;
import com.clinica.fx.dto.PacienteCadastroDTO;
import com.clinica.fx.dto.PacienteListarDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteListarDTO> listarPaciente(){

        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteListarDTO> pacienteListarDTOs = new ArrayList<>();
        for (Paciente paciente : pacientes) {

            pacienteListarDTOs.add(new PacienteListarDTO(
                    paciente.getId(),
                    paciente.getNome(),
                    paciente.getGenero(),
                    paciente.getCpf(),
                    paciente.getTelefone(),
                    paciente.getEmail(),
                    paciente.getCep(),
                    paciente.getCidade(),
                    paciente.getUf()));
        }
        return pacienteListarDTOs;
    }

    public void salvarPaciente(PacienteCadastroDTO  pacienteCadastroDTO) {

        @Valid Paciente paciente = new Paciente(
                null,
                pacienteCadastroDTO.nome(),
                pacienteCadastroDTO.dataNascimento(),
                pacienteCadastroDTO.genero(),
                pacienteCadastroDTO.cpf(),
                pacienteCadastroDTO.telefone(),
                pacienteCadastroDTO.email(),
                pacienteCadastroDTO.cep(),
                pacienteCadastroDTO.endereco(),
                pacienteCadastroDTO.bairro(),
                pacienteCadastroDTO.numero(),
                pacienteCadastroDTO.complemento(),
                pacienteCadastroDTO.cidade(),
                pacienteCadastroDTO.uf(),
                LocalDate.now(),
                null,
                true);

        pacienteRepository.save(paciente);
    }
}
