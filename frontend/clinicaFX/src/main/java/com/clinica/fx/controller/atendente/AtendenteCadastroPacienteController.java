package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.PacienteCadastroDTO;
import com.clinica.fx.enums.Genero;
import com.clinica.fx.service.PacienteService;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AtendenteCadastroPacienteController {

    PacienteService pacienteService = new PacienteService();

    @FXML
    private TextField nomePaciente;

    @FXML
    private DatePicker dataNascimentoPaciente;

    @FXML
    private ChoiceBox<String> generoPaciente;

    @FXML
    private TextField cpfPaciente;

    @FXML
    private TextField telefonePaciente;

    @FXML
    private TextField emailPaciente;

    @FXML
    private TextField cepPaciente;

    @FXML
    private TextField enderecoPaciente;

    @FXML
    private TextField bairroPaciente;

    @FXML
    private TextField numeroPaciente;

    @FXML
    private TextField complementoPaciente;

    @FXML
    private TextField cidadePaciente;

    @FXML
    private TextField ufPaciente;

    public void initialize(){
        generoPaciente.getItems().addAll(Genero.MASCULINO.toString(), Genero.FEMININO.toString(), Genero.OUTRO.toString());
    }

    @FXML
    public void cadastrarPaciente(){

        pacienteService.criarPaciente(new PacienteCadastroDTO(1L,
                nomePaciente.getText(),
                LocalDate.of(dataNascimentoPaciente.getValue().getYear(), dataNascimentoPaciente.getValue().getMonth(), dataNascimentoPaciente.getValue().getDayOfMonth()),
                Genero.valueOf(generoPaciente.getValue()),
                cpfPaciente.getText(),
                telefonePaciente.getText(),
                emailPaciente.getText(),
                cepPaciente.getText(),
                enderecoPaciente.getText(),
                bairroPaciente.getText(),
                numeroPaciente.getText(),
                complementoPaciente.getText(),
                cidadePaciente.getText(),
                ufPaciente.getText()));
    }
}
