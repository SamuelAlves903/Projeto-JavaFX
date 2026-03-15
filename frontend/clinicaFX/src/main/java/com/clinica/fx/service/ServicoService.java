package com.clinica.fx.service;

import com.clinica.fx.dto.ServicoListarDTO;
import com.clinica.fx.util.SessaoUsuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ServicoService {

    private HttpClient httpClient = HttpClient.newHttpClient();
    private String URL_SERVICO = "http://localhost:8080/servico";
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<ServicoListarDTO> listarServico(){
        try{

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(URL_SERVICO + "/listar"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), new TypeReference<List<ServicoListarDTO>>(){});
            }
            return List.of();
        }
        catch (Exception e){
            e.printStackTrace();
            return List.of();
        }
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
