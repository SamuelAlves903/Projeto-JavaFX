package com.clinica.fx.service;

import com.clinica.fx.dto.CadastroPacienteDTO;
import com.clinica.fx.dto.ListarPacienteDTO;
import com.clinica.fx.util.SessaoUsuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacienteService {

    private HttpClient httpClient = HttpClient.newHttpClient();
    private String URL_PACIENTE = "http://localhost:8080/paciente";
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<ListarPacienteDTO> listarPaciente(){

        try{

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(URL_PACIENTE + "/listar"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), new TypeReference<List<ListarPacienteDTO>>(){});
            }
            return List.of();
        }
        catch (Exception e){
            e.printStackTrace();
            return List.of();
        }

    }

    public List<ListarPacienteDTO> buscarPaciente(String nome){

        try {
            Map<String, String> map = new HashMap<>();
            map.put("nome", nome);

            String json = objectMapper.writeValueAsString(map);

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(URL_PACIENTE + "/buscar"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() == 200) {

                System.out.println("JSON recebido: " + httpResponse.body());
                return objectMapper.readValue(httpResponse.body(), new TypeReference<List<ListarPacienteDTO>>(){});
            }
            return List.of();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return List.of();

    }

    public String criarPaciente(CadastroPacienteDTO dto) throws IOException, InterruptedException {

        Map<String, String> map = new HashMap<>();
        map.put("id", null);
        map.put("nome", dto.nome());
        map.put("dataNascimento", dto.dataNascimento().toString());
        map.put("genero", dto.genero().toString());
        map.put("cpf", dto.cpf());
        map.put("telefone", dto.telefone());
        map.put("email", dto.email());
        map.put("cep", dto.cep());
        map.put("endereco", dto.endereco());
        map.put("bairro", dto.bairro());
        map.put("numero", dto.numero());
        map.put("complemento", dto.complemento());
        map.put("cidade", dto.cidade());
        map.put("uf", dto.uf());

        String json = objectMapper.writeValueAsString(map);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL_PACIENTE + "/salvar"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (httpResponse.statusCode() == 200) {

            return httpResponse.body();
        }
         return null;
    }

    public void editarPaciente(CadastroPacienteDTO dto){
        System.out.println("Paciente editado com sucesso: " + dto.toString());
    }

    public void excluirPaciente(CadastroPacienteDTO dto){
        System.out.println("Paciente removido com sucesso: " + dto.toString());
    }
}
