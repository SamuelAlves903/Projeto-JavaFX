package com.clinica.fx.backend.api;

import com.clinica.fx.backend.security.TokenService;
import com.clinica.fx.backend.service.PacienteService;
import com.clinica.fx.dto.PacienteCadastroDTO;
import com.clinica.fx.dto.PacienteListarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<PacienteListarDTO>> listarPaciente() {

        return ResponseEntity.ok(pacienteService.listarPaciente());
    }

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarPaciente(@RequestBody PacienteCadastroDTO pacienteCadastroDTO) {

        try{
            pacienteService.salvarPaciente(pacienteCadastroDTO);
            return new ResponseEntity<>("Paciente salvo com sucesso", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Erro ao salvar Paciente", HttpStatus.BAD_REQUEST);
        }
    }
}
