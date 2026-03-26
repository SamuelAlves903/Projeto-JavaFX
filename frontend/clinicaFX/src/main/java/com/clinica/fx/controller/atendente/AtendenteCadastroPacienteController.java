package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.CadastroPacienteDTO;
import com.clinica.fx.dto.ErroValidacaoDTO;
import com.clinica.fx.enums.Genero;
import com.clinica.fx.exceptions.ValidacaoException;
import com.clinica.fx.service.PacienteService;
import com.clinica.fx.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

        try {
            pacienteService.criarPaciente(new CadastroPacienteDTO(
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

            AtendenteLayoutController.getInstance().carregarListaPaciente();
        }
        catch (IOException | InterruptedException e){
            Alerts.erro("Erro ao cadastrar Paciente: " +  e.getMessage());
        }
        catch (ValidacaoException e){
            List<ErroValidacaoDTO> alerts = e.getErros();
            System.out.println(alerts);
        }
    }
}
