package com.clinica.fx.service;

import com.clinica.fx.dto.*;
import com.clinica.fx.util.SessaoUsuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgendamentoService {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final String URL_AGENDAMENTO = "http://localhost:8080/agendamento";
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    public List<ListarAgendamentoDTO> listarAgendamento(){
        try{

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(URL_AGENDAMENTO + "/listar"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() == 200) {

                return objectMapper.readValue(httpResponse.body(), new TypeReference<List<ListarAgendamentoDTO>>(){});
            }

            return List.of();
        }
        catch (Exception e){
            e.printStackTrace();
            return List.of();
        }
    }

    public List<BuscarDadosAgendamentoDTO> buscarServicosConsulta(){

        try{

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(URL_AGENDAMENTO + "/buscarServicosAgendamento"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() == 200) {

                return objectMapper.readValue(httpResponse.body(), new TypeReference<List<BuscarDadosAgendamentoDTO>>(){});
            }

            return List.of();
        }
        catch (Exception e){
            e.printStackTrace();
            return List.of();
        }
    }

    public List<BuscarDadosAgendamentoDTO> buscarMedicosConsulta(Long id){

        try{
            String json =  objectMapper.writeValueAsString(id);

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(URL_AGENDAMENTO + "/buscarMedicosAgendamento"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() == 200) {

                return objectMapper.readValue(httpResponse.body(), new TypeReference<List<BuscarDadosAgendamentoDTO>>(){});
            }

            return List.of();
        }
        catch (Exception e){
            return List.of();
        }
    }

    public List<LocalTime> buscarHorariosDisponiveis(Long idServico, Long idMedico, LocalDate data){

        try {

            Map<String, Object> map = new HashMap<>();
            map.put("idServico", idServico);
            map.put("idMedico", idMedico);
            map.put("data", data.toString());

            String jsonRequest = objectMapper.writeValueAsString(map);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_AGENDAMENTO + "/buscarHorariosDisponiveis"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), new TypeReference<List<LocalTime>>(){});
            }

            return List.of();
        } catch (Exception e) {

            return List.of();
        }
    }

    public Boolean  agendarConsulta(AgendarAgendamentoDTO dto){

        try {
            Map<String, String> map = new HashMap<>();
            map.put("id", null);
            map.put("pacienteId", dto.pacienteId().toString());
            map.put("servicoId", dto.servicoId().toString());
            map.put("medicoId", dto.medicoId().toString());
            map.put("data", dto.data().toString());
            map.put("hora", dto.hora().toString());

            String jsonRequest = objectMapper.writeValueAsString(map);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_AGENDAMENTO + "/agendarConsulta"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + SessaoUsuario.getToken())
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 200;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
