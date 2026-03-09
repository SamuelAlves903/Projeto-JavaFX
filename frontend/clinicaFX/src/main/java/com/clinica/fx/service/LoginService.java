package com.clinica.fx.service;

import com.clinica.fx.dto.LoginResponseDTO;
import com.clinica.fx.enums.Cargo;
import com.clinica.fx.util.SessaoUsuario;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String URL_LOGIN = "http://localhost:8080/auth/login";

    public boolean login(String login, String password) {

        try {
            Map<String, String> data = new HashMap<>();
            data.put("login", login);
            data.put("password", password);

            String jsonRequst = objectMapper.writeValueAsString(data);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_LOGIN))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequst))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                LoginResponseDTO loginResponseDTO = objectMapper.readValue(response.body(), LoginResponseDTO.class);
                String token = loginResponseDTO.token();
                String usuario = loginResponseDTO.usuario();
                Cargo cargo = loginResponseDTO.cargo();

                SessaoUsuario.setToken(token);
                SessaoUsuario.setUsuario(usuario);
                SessaoUsuario.setCargo(cargo);

                System.out.println(SessaoUsuario.getToken());
                System.out.println(SessaoUsuario.getUsuario());
                System.out.println(SessaoUsuario.getCargo());
                return true;
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
