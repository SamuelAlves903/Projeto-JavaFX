package com.clinica.fx.backend.service;

import com.clinica.fx.backend.model.Servico;
import com.clinica.fx.backend.repository.ServicoRepository;
import com.clinica.fx.dto.ListarServicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<ListarServicoDTO> listar(){

        List<Servico> servicos = servicoRepository.findAll();
        List<ListarServicoDTO> listarServicos = new ArrayList<>();
        for (Servico servico : servicos) {

            listarServicos.add(new ListarServicoDTO(
                    servico.getId(),
                    servico.getNome(),
                    servico.getPreco(),
                    servico.getDescricao()));
        }
        return listarServicos;
    }
}
