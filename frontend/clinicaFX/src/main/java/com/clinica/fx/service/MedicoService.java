package com.clinica.fx.service;

import com.clinica.fx.model.dto.MedicoDTO;

import java.time.LocalDate;
import java.util.List;

public class MedicoService {

    public List<MedicoDTO> listarMedico(){
        return List.of(new MedicoDTO(1L, "Samuel", "alves@gmail.com", "012529202921", "???", "???", "Pediatria", LocalDate.of(2025, 12, 12), LocalDate.of(2026, 12, 12), true));
    }

    public void  adicionarMedico(MedicoDTO dto){
        System.out.println("Medico adicionado com sucesso: " + dto.toString());
    }

    public void editarMedico(MedicoDTO dto){
        System.out.println("Medico editado com sucesso: " + dto.toString());
    }

    public void excluirMedico(MedicoDTO dto){
        System.out.println("Medico removido com sucesso: " + dto.toString());
    }
}
