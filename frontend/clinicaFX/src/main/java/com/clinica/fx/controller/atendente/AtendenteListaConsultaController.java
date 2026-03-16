package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.ListarAgendamentoDTO;
import com.clinica.fx.service.AgendamentoService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.time.LocalDate;
import java.time.LocalTime;

public class AtendenteListaConsultaController {

    AgendamentoService agendamentoService =  new AgendamentoService();

    @FXML
    private TableView<ListarAgendamentoDTO> listaConsulta;

    @FXML
    private TableColumn<ListarAgendamentoDTO, Long> idAgendamento;

    @FXML
    private TableColumn<ListarAgendamentoDTO, String> paciente;

    @FXML
    private TableColumn<ListarAgendamentoDTO, String> medico;

    @FXML
    private TableColumn<ListarAgendamentoDTO, String> servico;

    @FXML
    private TableColumn<ListarAgendamentoDTO, LocalDate> dataAgendamento;

    @FXML
    private TableColumn<ListarAgendamentoDTO, LocalTime> horaAgendamento;

    public void initialize() {

        idAgendamento.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().id()));
        paciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nomePaciente()));
        servico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nomeServico()));
        medico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nomeMedico()));
        dataAgendamento.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().data()));
        horaAgendamento.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().hora()));

        ObservableList<ListarAgendamentoDTO> listaConsultas = FXCollections.observableArrayList(
                agendamentoService.listarAgendamento()
        );

        listaConsulta.setItems(listaConsultas);
    }
}
