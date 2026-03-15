package com.clinica.fx.backend.service;

import com.clinica.fx.backend.model.Paciente;
import com.clinica.fx.backend.model.Servico;
import com.clinica.fx.backend.repository.ServicoRepository;
import com.clinica.fx.dto.PacienteListarDTO;
import com.clinica.fx.dto.ServicoListarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<ServicoListarDTO> listar(){

        List<Servico> servicos = servicoRepository.findAll();
        List<ServicoListarDTO> listarServicos = new ArrayList<>();
        for (Servico servico : servicos) {

            listarServicos.add(new ServicoListarDTO(
                    servico.getId(),
                    servico.getNome(),
                    servico.getPreco(),
                    servico.getDescricao()));
        }
        return listarServicos;
    }
}
