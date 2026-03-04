package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.PacienteDTO;
import com.clinica.fx.enums.Genero;
import com.clinica.fx.service.PacienteService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AtendenteAgendarConsultaController {

    private PacienteService pacienteService =  new PacienteService();

    @FXML
    private TextField dado;

    @FXML
    private TableView<PacienteDTO> pacienteDTOTableView;

    @FXML
    private TableColumn<PacienteDTO, Long> idPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colNomePaciente;

    @FXML
    private TableColumn<PacienteDTO, Genero> colGeneroPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colCpfPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colTelPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colEmailPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colCepPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colCidadePaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colUfPaciente;

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
    }

    @FXML
    public void buscarPaciente(){

        ObservableList<PacienteDTO> list = FXCollections.observableArrayList(
                pacienteService.buscarPaciente(dado.getText())
        );

        pacienteDTOTableView.setItems(list);
    }
}
