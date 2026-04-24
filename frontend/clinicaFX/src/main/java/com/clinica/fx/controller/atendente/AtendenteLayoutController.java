package com.clinica.fx.controller.atendente;

import com.clinica.fx.util.LoadeScreen;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class AtendenteLayoutController {

    @FXML
    private StackPane stackPane;

    @FXML
    private Button btnSair;

    @FXML
    private Label labelLayout;

    private static AtendenteLayoutController instance;
    private static Stage stage;

    public void initialize() {
        instance = this;
        try {
            Parent novaTela = LoadeScreen.carregarTela("/view/atendente/inicio.fxml");
            novaTela.getStylesheets().add(getClass().getResource("/css/inicio.css").toExternalForm());
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Platform.runLater(() -> {
            stage = (Stage) stackPane.getScene().getWindow();
        });

        labelLayout.setOnMouseClicked(e -> {
            Parent novaTela;

            try {
                novaTela = LoadeScreen.carregarTela("/view/atendente/inicio.fxml");
                novaTela.getStylesheets().add(getClass().getResource("/css/inicio.css").toExternalForm());
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
        });
    }

    public static AtendenteLayoutController getInstance() {
        return instance;
    }
    public static Stage getStage() {return stage;}

    @FXML
    public void carregarListaPaciente(){
        try{
            Parent novaTela = LoadeScreen.carregarTela("/view/atendente/lista_paciente.fxml");
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregarCadastroPaciente(){
        try {
            Parent novaTela = LoadeScreen.carregarTela("/view/atendente/cadastro_paciente.fxml");
            novaTela.getStylesheets().add(getClass().getResource("/css/cadastro_paciente.css").toExternalForm());
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregarAgendarConsulta(){
        try {
            Parent novaTela = LoadeScreen.carregarTela("/view/atendente/agendar_consulta.fxml");
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregarListaConsulta(){
        try {
            Parent novaTela = LoadeScreen.carregarTela("/view/atendente/lista_consulta.fxml");
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregarListaServico(){
        try {
            Parent novaTela = LoadeScreen.carregarTela("/view/atendente/lista_servico.fxml");
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregarPacienteHistorico(){
        try {
            Parent novaTela = LoadeScreen.carregarTela("/view/atendente/paciente_historico.fxml");
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregarConsultaHistorico(){
        try {
            Parent novaTela = LoadeScreen.carregarTela("/view/atendente/consulta_historico.fxml");
            stackPane.getChildren().clear();
            stackPane.getChildren().add(novaTela);
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
