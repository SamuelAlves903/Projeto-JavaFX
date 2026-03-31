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
    private TextField nomePacienteErro;

    @FXML
    private DatePicker dataNascimentoPaciente;

    @FXML
    private TextField dataNascimentoPacienteErro;

    @FXML
    private ChoiceBox<String> generoPaciente;

    @FXML
    private TextField generoPacienteErro;

    @FXML
    private TextField cpfPaciente;

    @FXML
    private TextField cpfPacienteErro;

    @FXML
    private TextField telefonePaciente;

    @FXML
    private TextField telefonePacienteErro;

    @FXML
    private TextField emailPaciente;

    @FXML
    private TextField emailPacienteErro;

    @FXML
    private TextField cepPaciente;

    @FXML
    private TextField cepPacienteErro;

    @FXML
    private TextField enderecoPaciente;

    @FXML
    private TextField enderecoPacienteErro;

    @FXML
    private TextField bairroPaciente;

    @FXML
    private TextField bairroPacienteErro;

    @FXML
    private TextField numeroPaciente;

    @FXML
    private TextField numeroPacienteErro;

    @FXML
    private TextField complementoPaciente;

    @FXML
    private TextField cidadePaciente;

    @FXML
    private TextField cidadePacienteErro;

    @FXML
    private TextField ufPaciente;

    @FXML
    private TextField ufPacienteErro;

    public void initialize() {
        generoPaciente.getItems().addAll(Genero.MASCULINO.toString(), Genero.FEMININO.toString(), Genero.OUTRO.toString());
    }

    @FXML
    public void cadastrarPaciente() {

        if (!validarCampos()) {
            return;
        }

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

            Alerts.sucesso(AtendenteLayoutController.getStage(),"Paciente criado com sucesso");
            AtendenteLayoutController.getInstance().carregarListaPaciente();
        } catch (IOException | InterruptedException e) {
            Alerts.erro(AtendenteLayoutController.getStage(), "Erro inesperado ao cadastrar Paciente: " + e.getMessage());
        } catch (ValidacaoException e) {
            validarExcecoes(e);
        }
    }

    private boolean validarCampos() {

        if (nomePaciente.getText().isEmpty() || nomePaciente.getText().isBlank()) {

            nomePacienteErro.setVisible(true);
            nomePacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        if (dataNascimentoPaciente.getValue() == null) {

            dataNascimentoPacienteErro.setVisible(true);
            dataNascimentoPacienteErro.setText("Informe a data de nascimento!");
            return false;
        }
        if (cpfPaciente.getText().isEmpty() || cpfPaciente.getText().isBlank()) {

            cpfPacienteErro.setVisible(true);
            cpfPacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        if (telefonePaciente.getText().isEmpty() || telefonePaciente.getText().isBlank()) {

            telefonePacienteErro.setVisible(true);
            telefonePacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        if (emailPaciente.getText().isEmpty() || emailPaciente.getText().isBlank()) {

            emailPacienteErro.setVisible(true);
            emailPacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        if (cepPaciente.getText().isEmpty() || cepPaciente.getText().isBlank()) {

            cepPacienteErro.setVisible(true);
            cepPacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        if (enderecoPaciente.getText().isEmpty() || enderecoPaciente.getText().isBlank()) {

            enderecoPacienteErro.setVisible(true);
            enderecoPacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        if (bairroPaciente.getText().isEmpty() || bairroPaciente.getText().isEmpty()) {

            bairroPacienteErro.setVisible(true);
            bairroPacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        if (numeroPaciente.getText().isEmpty() || numeroPaciente.getText().isEmpty()) {

            numeroPacienteErro.setVisible(true);
            numeroPacienteErro.setText("Campo Obrigatorio!");
        }
        if (cidadePaciente.getText().isEmpty() || cidadePaciente.getText().isEmpty()) {

            cidadePacienteErro.setVisible(true);
            cidadePacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        if (ufPaciente.getText().isEmpty() || ufPaciente.getText().isBlank()) {

            ufPacienteErro.setVisible(true);
            ufPacienteErro.setText("Campo Obrigatorio!");
            return false;
        }
        return true;
    }

    private void validarExcecoes(ValidacaoException e) {

        List<ErroValidacaoDTO> alerts = e.getErros();
        for (ErroValidacaoDTO erro : alerts) {
            if (erro.campo().contains("nome")) {

                nomePacienteErro.setVisible(true);
                nomePacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("dataNascimento")) {

                dataNascimentoPacienteErro.setVisible(true);
                dataNascimentoPacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("genero")) {

                generoPacienteErro.setVisible(true);
                generoPacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("cpf")) {

                cpfPacienteErro.setVisible(true);
                cpfPacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("telefone")) {

                telefonePacienteErro.setVisible(true);
                telefonePacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("email")) {

                emailPacienteErro.setVisible(true);
                emailPacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("cep")) {

                cepPacienteErro.setVisible(true);
                cepPacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("endereco")) {

                enderecoPacienteErro.setVisible(true);
                enderecoPacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("bairro")) {

                bairroPacienteErro.setVisible(true);
                bairroPacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("numero")) {

                numeroPacienteErro.setVisible(true);
                numeroPacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("cidade")) {

                cidadePacienteErro.setVisible(true);
                cidadePacienteErro.setText(erro.mensagem());
            }
            if (erro.campo().contains("uf")) {

                ufPacienteErro.setVisible(true);
                ufPacienteErro.setText(erro.mensagem());
            }
        }
    }

}
