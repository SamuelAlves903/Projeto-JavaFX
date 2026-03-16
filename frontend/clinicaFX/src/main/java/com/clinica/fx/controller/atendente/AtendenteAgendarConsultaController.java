package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.AgendarAgendamentoDTO;
import com.clinica.fx.dto.BuscarDadosAgendamentoDTO;
import com.clinica.fx.dto.ListarPacienteDTO;
import com.clinica.fx.enums.Genero;
import com.clinica.fx.service.AgendamentoService;
import com.clinica.fx.service.PacienteService;
import com.clinica.fx.util.Alerts;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalTime;
import java.util.List;

public class AtendenteAgendarConsultaController {

    private PacienteService pacienteService =  new PacienteService();

    private AgendamentoService agendamentoService =  new AgendamentoService();

    @FXML
    private TextField dado;

    @FXML
    private TableView<ListarPacienteDTO> pacienteDTOTableView;

    @FXML
    private TableColumn<ListarPacienteDTO, Long> colIdPaciente;

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

    @FXML
    private TableColumn<ListarPacienteDTO, Void> colAcoesPaciente;

    @FXML
    private TextField pacienteTextField;

    @FXML
    private ChoiceBox<BuscarDadosAgendamentoDTO> servicos;

    @FXML
    private ChoiceBox<BuscarDadosAgendamentoDTO> medicos;

    @FXML
    private DatePicker data;

    @FXML
    private ChoiceBox<LocalTime> horariosDisponiveis;

    private Long pacienteId;

    private Long servicoId;

    private Long medicoId;

    public void initialize() {

        colIdPaciente.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().id()));
        colNomePaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nome()));
        colGeneroPaciente.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().genero()));
        colCpfPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cpf()));
        colTelPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().telefone()));
        colEmailPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        colCepPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cep()));
        colCidadePaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cidade()));
        colUfPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().uf()));
        colAcoesPaciente.setCellFactory(param -> new TableCell<>() {
            private final Button btn = new Button("➕");

            {
                btn.setOnAction(event -> {
                    ListarPacienteDTO paciente = getTableView().getItems().get(getIndex());
                    selecionarPaciente(paciente);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

        servicos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selecionarServico();
        });

        medicos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selecionarMedico();
        });
    }

    @FXML
    public void buscarPaciente(){

        ObservableList<ListarPacienteDTO> list = FXCollections.observableArrayList(
                pacienteService.buscarPaciente(dado.getText())
        );
        pacienteDTOTableView.setItems(list);
    }

    private void selecionarPaciente(ListarPacienteDTO paciente) {
        pacienteTextField.setText(paciente.nome());
        pacienteId = paciente.id();

        List<BuscarDadosAgendamentoDTO> listarServicos = agendamentoService.buscarServicosConsulta();
        servicos.setItems(FXCollections.observableArrayList(listarServicos));

    }

    public void selecionarServico(){

        servicoId = servicos.getSelectionModel().getSelectedItem().id();

        ObservableList<BuscarDadosAgendamentoDTO> listaMedico = FXCollections.observableArrayList(
                agendamentoService.buscarMedicosConsulta(servicoId)
        );

        medicos.setItems(listaMedico);
    }

    public void selecionarMedico(){

        medicoId = medicos.getSelectionModel().getSelectedItem().id();
    }

    @FXML
    public void selecionarData(){

        horariosDisponiveis.setItems(FXCollections.observableArrayList(agendamentoService.buscarHorariosDisponiveis(servicoId, medicoId, data.getValue())));
    }

    @FXML
    public void agendarConsulta(){

        Boolean sucesso = agendamentoService.agendarConsulta(new AgendarAgendamentoDTO(null, pacienteId, servicoId, medicoId, data.getValue(), horariosDisponiveis.getValue()));

        if (sucesso) {
            AtendenteLayoutController.getInstance().carregarListaConsulta();
        }
        else {
            Alerts.erro("Erro ao agendar consulta");
        }
    }
}
