package com.clinica.fx.controller;

import com.clinica.fx.util.LoadeScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AtendenteLayoutController {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button btnSair;

    public void initialize(){

        try {
            scrollPane.setContent(LoadeScreen.carregarTela("/view/atendente/inicio.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregarListaPaciente(){
        try{
            scrollPane.setContent(LoadeScreen.carregarTela("/view/atendente/lista_paciente.fxml"));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregarTelaCadastroPaciente(){
        try {
            scrollPane.setContent(LoadeScreen.carregarTela("/view/atendente/cadastro_paciente.fxml"));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void sair(){
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
}
