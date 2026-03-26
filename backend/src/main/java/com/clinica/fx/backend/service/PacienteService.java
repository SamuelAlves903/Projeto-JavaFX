package com.clinica.fx.backend.service;

import com.clinica.fx.backend.model.Paciente;
import com.clinica.fx.backend.repository.PacienteRepository;
import com.clinica.fx.dto.CadastroPacienteDTO;
import com.clinica.fx.dto.ListarPacienteDTO;
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

    public List<ListarPacienteDTO> listarPaciente(){

        List<Paciente> pacientes = pacienteRepository.findAll();
        List<ListarPacienteDTO> pacienteListarDTOs = new ArrayList<>();
        for (Paciente paciente : pacientes) {

            pacienteListarDTOs.add(new ListarPacienteDTO(
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

    public List<ListarPacienteDTO> buscarPaciente(String nome){

        List<Paciente> pacientes = pacienteRepository.findByNomeContainingIgnoreCase(nome);
        List<ListarPacienteDTO> pacienteListarDTOs = new ArrayList<>();
        for (Paciente paciente : pacientes) {

            pacienteListarDTOs.add(new ListarPacienteDTO(
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

    public void salvarPaciente(CadastroPacienteDTO pacienteCadastroDTO) {

        Paciente paciente = new Paciente(
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
