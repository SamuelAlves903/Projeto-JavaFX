package com.clinica.fx.service;

import com.clinica.fx.model.dto.AgendamentoDTO;
import com.clinica.fx.model.dto.MedicoDTO;
import com.clinica.fx.model.dto.PacienteDTO;
import com.clinica.fx.model.dto.ServicoDTO;
import com.clinica.fx.model.enums.Genero;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoService {

    public List<AgendamentoDTO> listarAgendamento(){
        return List.of(new AgendamentoDTO(1L, new PacienteDTO(1L, "Samuel", LocalDate.of(2001, 5, 15), Genero.MASCULINO, "012529202921", "44984593988", "alves123@gmail.com", "87507647", "João", "Joana Plats", "1233", "pimba", "Umuarama", "PR"), new MedicoDTO(1L, "Samuel", "alves@gmail.com", "012529202921", "???", "???", "Pediatria", LocalDate.of(2025, 12, 12), LocalDate.of(2026, 12, 12), true), new ServicoDTO(1L, "pimba", BigDecimal.valueOf(120.0), "???"), LocalDate.now(), LocalDateTime.now()));
    }

    public void  adicionarAgendamento(AgendamentoDTO dto){
        System.out.println("Agendamento adicionado com sucesso: " + dto.toString());
    }

    public void editarAgendamento(AgendamentoDTO dto){
        System.out.println("Agendamento editado com sucesso: " + dto.toString());
    }

    public void excluirAgendamento(AgendamentoDTO dto){
        System.out.println("Agendamento removido com sucesso: " + dto.toString());
    }
}
