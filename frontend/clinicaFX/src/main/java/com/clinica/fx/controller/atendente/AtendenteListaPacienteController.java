package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.ListarPacienteDTO;
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
    private TableView<ListarPacienteDTO> pacienteDTOTableView;

    @FXML
    private TableColumn<ListarPacienteDTO, Long> idPaciente;

    @FXML
    private TableColumn<ListarPacienteDTO, String> colNomePaciente;

    @FXML
    private TableColumn<ListarPacienteDTO, Genero> colGeneroPaciente;

    @FXML
    private TableColumn<ListarPacienteDTO, String> colCpfPaciente;

    @FXML
    private TableColumn<ListarPacienteDTO, String> colTelPaciente;

    @FXML
    private TableColumn<ListarPacienteDTO, String> colEmailPaciente;

    @FXML
    private TableColumn<ListarPacienteDTO, String> colCepPaciente;

    @FXML
    private TableColumn<ListarPacienteDTO, String> colCidadePaciente;

    @FXML
    private TableColumn<ListarPacienteDTO, String> colUfPaciente;

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

        ObservableList<ListarPacienteDTO> listaPacientes = FXCollections.observableArrayList(
                pacienteService.listarPaciente()
                );

        pacienteDTOTableView.setItems(listaPacientes);
    }
}
