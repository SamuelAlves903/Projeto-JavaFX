package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.ConsultaAgendarDTO;
import com.clinica.fx.dto.ConsultaBuscarDTO;
import com.clinica.fx.dto.PacienteListarDTO;
import com.clinica.fx.enums.Genero;
import com.clinica.fx.service.AgendamentoService;
import com.clinica.fx.service.MedicoService;
import com.clinica.fx.service.PacienteService;
import com.clinica.fx.service.ServicoService;
import com.clinica.fx.util.Alerts;
import com.clinica.fx.util.LoadeScreen;
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
    private TableView<PacienteListarDTO> pacienteDTOTableView;

    @FXML
    private TableColumn<PacienteListarDTO, Long> colIdPaciente;

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

    @FXML
    private TableColumn<PacienteListarDTO, Void> colAcoesPaciente;

    @FXML
    private TextField pacienteTextField;

    @FXML
    private ChoiceBox<ConsultaBuscarDTO> servicos;

    @FXML
    private ChoiceBox<ConsultaBuscarDTO> medicos;

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
                    PacienteListarDTO paciente = getTableView().getItems().get(getIndex());
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

        ObservableList<PacienteListarDTO> list = FXCollections.observableArrayList(
                pacienteService.buscarPaciente(dado.getText())
        );
        pacienteDTOTableView.setItems(list);
    }

    private void selecionarPaciente(PacienteListarDTO paciente) {
        pacienteTextField.setText(paciente.nome());
        pacienteId = paciente.id();

        List<ConsultaBuscarDTO> listarServicos = agendamentoService.buscarServicosConsulta();
        servicos.setItems(FXCollections.observableArrayList(listarServicos));

    }

    public void selecionarServico(){

        servicoId = servicos.getSelectionModel().getSelectedItem().id();

        ObservableList<ConsultaBuscarDTO> listaMedico = FXCollections.observableArrayList(
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

        Boolean sucesso = agendamentoService.agendarConsulta(new ConsultaAgendarDTO(null, pacienteId, servicoId, medicoId, data.getValue(), horariosDisponiveis.getValue()));

        if (sucesso) {
            AtendenteLayoutController.getInstance().carregarListaConsulta();
        }
        else {
            Alerts.erro("Erro ao agendar consulta");
        }
    }
}
