package com.clinica.fx.service;

import com.clinica.fx.model.dto.ServicoDTO;

import java.math.BigDecimal;
import java.util.List;

public class ServicoService {

    public List<ServicoDTO> listarServico(){
        return List.of(new ServicoDTO(1L, "pimba", BigDecimal.valueOf(120.0), "???"));
    }

    public void  adicionarServico(ServicoDTO dto){
        System.out.println("Servico adicionado com sucesso: " + dto.toString());
    }

    public void editarServico(ServicoDTO dto){
        System.out.println("Servico editado com sucesso: " + dto.toString());
    }

    public void excluirServico(ServicoDTO dto){
        System.out.println("Servico removido com sucesso: " + dto.toString());
    }
}
