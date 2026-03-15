package com.clinica.fx.service;

import com.clinica.fx.dto.ConsultaBuscarDTO;
import com.clinica.fx.dto.MedicoDTO;
import com.clinica.fx.util.SessaoUsuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicoService {

    private HttpClient httpClient = HttpClient.newHttpClient();
    private String URL_MEDICO = "http://localhost:8080/medico";
    private ObjectMapper objectMapper = new ObjectMapper();

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
