package com.clinica.fx.service;

import com.clinica.fx.dto.PacienteDTO;
import com.clinica.fx.enums.Genero;

import java.time.LocalDate;
import java.util.List;

public class PacienteService {

    public List<PacienteDTO> listarPaciente(){
        return List.of(new PacienteDTO(1L, "Samuel", LocalDate.of(2001, 5, 15), Genero.MASCULINO, "012529202921", "44984593988", "alves123@gmail.com", "87507647", "João", "Joana Plats", "1233", "pimba", "Umuarama", "PR"));
    }

    public List<PacienteDTO> buscarPaciente(String dado){
        return List.of(new PacienteDTO(1L, "Samuel", LocalDate.of(2001, 5, 15), Genero.MASCULINO, "012529202921", "44984593988", "alves123@gmail.com", "87507647", "João", "Joana Plats", "1233", "pimba", "Umuarama", "PR"));
    }

    public void  criarPaciente(PacienteDTO dto){
        System.out.println("Paciente criado com sucesso: " + dto.toString());
    }

    public void editarPaciente(PacienteDTO dto){
        System.out.println("Paciente editado com sucesso: " + dto.toString());
    }

    public void excluirPaciente(PacienteDTO dto){
        System.out.println("Paciente removido com sucesso: " + dto.toString());
    }
}
