package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.PacienteListarDTO;
import com.clinica.fx.enums.Genero;
import com.clinica.fx.service.PacienteService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AtendenteListaPacienteController {

    private PacienteService pacienteService =  new PacienteService();

    @FXML
    private TableView<PacienteListarDTO> pacienteDTOTableView;

    @FXML
    private TableColumn<PacienteListarDTO, Long> idPaciente;

    @FXML
    private TableColumn<PacienteListarDTO, String> colNomePaciente;

    @FXML
    private TableColumn<PacienteListarDTO, Genero> colGeneroPaciente;

    @FXML
    private TableColumn<PacienteListarDTO, String> colCpfPaciente;

    @FXML
    private TableColumn<PacienteListarDTO, String> colTelPaciente;

    @FXML
    private TableColumn<PacienteListarDTO, String> colEmailPaciente;

    @FXML
    private TableColumn<PacienteListarDTO, String> colCepPaciente;

    @FXML
    private TableColumn<PacienteListarDTO, String> colCidadePaciente;

    @FXML
    private TableColumn<PacienteListarDTO, String> colUfPaciente;

    public void initialize() {

        idPaciente.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().id()));
        colNomePaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nome()));
        colGeneroPaciente.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().genero()));
        colCpfPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cpf()));
        colTelPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().telefone()));
        colEmailPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        colCepPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cep()));
        colCidadePaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cidade()));
        colUfPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().uf()));

        ObservableList<PacienteListarDTO> listaPacientes = FXCollections.observableArrayList(
                pacienteService.listarPaciente()
                );

        pacienteDTOTableView.setItems(listaPacientes);
    }
}
