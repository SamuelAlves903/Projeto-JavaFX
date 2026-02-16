package com.clinica.fx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

public class AtendenteLayoutController {

    @FXML
    private ScrollPane scrollPane;

    public void initialize(){
        carregarTela("/view/atendente/inicio.fxml");
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
