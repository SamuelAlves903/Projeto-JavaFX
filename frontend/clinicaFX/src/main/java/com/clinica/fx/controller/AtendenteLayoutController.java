package com.clinica.fx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AtendenteLayoutController {

    @FXML
    private ScrollPane scrollPane;

    public void initialize(){
        carregarTela("/view/atendente/dashboard.fxml");
    }

    private void carregarTela(String caminho){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
            Parent root = loader.load();
            scrollPane.setContent(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
