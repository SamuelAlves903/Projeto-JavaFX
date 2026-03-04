package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.AgendamentoDTO;
import com.clinica.fx.service.AgendamentoService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AtendenteListaConsultaController {

    AgendamentoService agendamentoService =  new AgendamentoService();

    @FXML
    private TableView<AgendamentoDTO> listaConsulta;

    @FXML
    private TableColumn<AgendamentoDTO, Long> idAgendamento;

    @FXML
    private TableColumn<AgendamentoDTO, String> paciente;

    @FXML
    private TableColumn<AgendamentoDTO, String> medico;

    @FXML
    private TableColumn<AgendamentoDTO, String> servico;

    @FXML
    private TableColumn<AgendamentoDTO, LocalDate> dataAgendamento;

    @FXML
    private TableColumn<AgendamentoDTO, LocalDateTime> horaAgendamento;

    public void initialize() {

        idAgendamento.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().id()));
        paciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().paciente().nome()));
        medico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().medico().nome()));
        servico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().servico().nome()));
        dataAgendamento.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().data()));
        horaAgendamento.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().hora()));

        ObservableList<AgendamentoDTO> listaConsultas = FXCollections.observableArrayList(
                agendamentoService.listarAgendamento()
        );

        listaConsulta.setItems(listaConsultas);
    }
}
