package com.clinica.fx.service;

import com.clinica.fx.dto.ServicoListarDTO;

import java.math.BigDecimal;
import java.util.List;

public class ServicoService {

    public List<ServicoListarDTO> listarServico(){
        return List.of(new ServicoListarDTO(1L, "pimba", BigDecimal.valueOf(120.0), "???"));
    }

    public void  adicionarServico(ServicoListarDTO dto){
        System.out.println("Servico adicionado com sucesso: " + dto.toString());
    }

    public void editarServico(ServicoListarDTO dto){
        System.out.println("Servico editado com sucesso: " + dto.toString());
    }

    public void excluirServico(ServicoListarDTO dto){
        System.out.println("Servico removido com sucesso: " + dto.toString());
    }
}
