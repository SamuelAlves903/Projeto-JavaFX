package com.clinica.fx.backend.api;

import com.clinica.fx.backend.service.ServicoService;
import com.clinica.fx.dto.ListarServicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoApi {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ListarServicoDTO>> listar(){

        return ResponseEntity.ok(servicoService.listar());
    }
}
