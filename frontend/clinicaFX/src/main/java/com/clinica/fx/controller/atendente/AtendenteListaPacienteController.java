package com.clinica.fx.controller.atendente;

import com.clinica.fx.model.dto.PacienteDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AtendenteListaPacienteController {

    @FXML
    private TableView<PacienteDTO> pacienteDTOTableView;

    @FXML
    private TableColumn<PacienteDTO, Long> idPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colNomePaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colCpfPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colTelPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colEmailPaciente;

    @FXML
    private TableColumn<PacienteDTO, String> colCepPaciente;

    public void initialize() {

        idPaciente.setCellValueFactory( new PropertyValueFactory<>("id"));
        colNomePaciente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCpfPaciente.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colTelPaciente.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colEmailPaciente.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCepPaciente.setCellValueFactory(new PropertyValueFactory<>("cep"));

        ObservableList<PacienteDTO> listaPacientes = FXCollections.observableArrayList(
                new PacienteDTO(1L, "Samuel", "12332112332", "44984593988", "alves123321@gmail.com", "32131312312", "Rua João", "Tonhão", "1233")
        );

        pacienteDTOTableView.setItems(listaPacientes);
    }
}
