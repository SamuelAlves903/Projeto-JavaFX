package com.clinica.fx.backend.service;

import com.clinica.fx.backend.model.Agendamento;
import com.clinica.fx.backend.model.Medico;
import com.clinica.fx.backend.model.Servico;
import com.clinica.fx.backend.repository.AgendamentoRepository;
import com.clinica.fx.backend.repository.MedicoRepository;
import com.clinica.fx.backend.repository.PacienteRepository;
import com.clinica.fx.backend.repository.ServicoRepository;
import com.clinica.fx.dto.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<ListarAgendamentoDTO> listarAgendamentos(){

        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        List<ListarAgendamentoDTO> listaAgendamentos = new ArrayList<>();

        for (Agendamento agendamento : agendamentos) {

            listaAgendamentos.add(new ListarAgendamentoDTO(
                    agendamento.getId(),
                    agendamento.getPaciente().getNome(),
                    agendamento.getServico().getNome(),
                    agendamento.getMedico().getNome(),
                    agendamento.getData(),
                    agendamento.getHorario()
            ));
        }

        return listaAgendamentos;
    }

    public List<BuscarDadosAgendamentoDTO> buscarServicosAgendamento(){

        List<Servico> servicos = servicoRepository.findAll();
        List<BuscarDadosAgendamentoDTO> listarServicos = new ArrayList<>();
        for (Servico servico : servicos) {

            listarServicos.add(new BuscarDadosAgendamentoDTO(
                    servico.getId(),
                    servico.getNome()
            ));
        }

        return listarServicos;
    }

    public List<BuscarDadosAgendamentoDTO> buscarMedicoAgendamento(Long medicoId){

        List<Medico> medico = medicoRepository.findByServicoIdAndAtivoTrue(medicoId);
        List<BuscarDadosAgendamentoDTO> listaMedico = new ArrayList<>();
        for (Medico medicos : medico) {

            listaMedico.add(new BuscarDadosAgendamentoDTO(
                    medicos.getId(),
                    medicos.getNome()
            ));
        }

        return listaMedico;
    }

    public List<LocalTime> buscarHorariosDisponiveis(BuscarHorariosAgendamentoDTO dto) {

        List<Agendamento> agendamentos = agendamentoRepository.findByMedicoIdAndServicoIdAndData(dto.idMedico(), dto.idServico(),  dto.data());
        List<LocalTime> horariosOcupados = agendamentos.stream().map(Agendamento::getHorario).toList();

        List<LocalTime> horariosDisponiveis = new ArrayList<>();
        LocalTime horarioInicio = LocalTime.of(8, 0);
        LocalTime horarioFim = LocalTime.of(18, 0);

        while (horarioInicio.isBefore(horarioFim) || horarioInicio.equals(horarioFim)) {

            if (!horariosOcupados.contains(horarioInicio)) {
                horariosDisponiveis.add(horarioInicio);
            }

            horarioInicio = horarioInicio.plusMinutes(30);
        }

        return horariosDisponiveis;
    }

    public Boolean agendarConsulta(AgendarAgendamentoDTO dto) {

        var paciente = pacienteRepository.findById(dto.pacienteId()).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        var medico = medicoRepository.findById(dto.medicoId()).orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        var servico = servicoRepository.findById(dto.servicoId()).orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        Agendamento agendamento = new Agendamento(
                null,
                paciente,
                servico,
                medico,
                dto.data(),
                dto.hora()
        );

        return agendamentoRepository.save(agendamento) != null;
    }
}
