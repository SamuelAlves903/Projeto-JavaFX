package com.clinica.fx.service;

import com.clinica.fx.model.dto.AgendamentoDTO;

import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoService {

    public List<AgendamentoDTO> listarAgendamento(){
        return List.of(new AgendamentoDTO(1L, 1L, 1L, 1L, LocalDateTime.now()));
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
