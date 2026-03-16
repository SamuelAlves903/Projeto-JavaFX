package com.clinica.fx.backend.api;

import com.clinica.fx.backend.service.AgendamentoService;
import com.clinica.fx.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoApi {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ListarAgendamentoDTO>> listar() {

        return ResponseEntity.ok(agendamentoService.listarAgendamentos());
    }

    @GetMapping("/buscarServicosAgendamento")
    public ResponseEntity<List<BuscarDadosAgendamentoDTO>> buscarServicos() {

        return ResponseEntity.ok(agendamentoService.buscarServicosAgendamento());
    }

    @PostMapping("/buscarMedicosAgendamento")
    public ResponseEntity<List<BuscarDadosAgendamentoDTO>> buscarMedicos(@RequestBody Long medicoId) {

        return ResponseEntity.ok(agendamentoService.buscarMedicoAgendamento(medicoId));
    }

    @PostMapping("/buscarHorariosDisponiveis")
    public ResponseEntity<List<LocalTime>> buscarHorarios(@RequestBody BuscarHorariosAgendamentoDTO buscarHorariosAgendamentoDTO) {

        System.out.println("Recebido: "  + buscarHorariosAgendamentoDTO);
        return ResponseEntity.ok(agendamentoService.buscarHorariosDisponiveis(buscarHorariosAgendamentoDTO));
    }

    @PostMapping("/agendarConsulta")
    public ResponseEntity agendarConsulta(@RequestBody AgendarAgendamentoDTO consultaAgendarDTO) {

        var sucesso = agendamentoService.agendarConsulta(consultaAgendarDTO);
        if (sucesso) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
