package com.clinica.fx.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class LoadeScreen {

    public static Parent carregarTela(String caminho) throws IOException {

        return FXMLLoader.load(Objects.requireNonNull(LoadeScreen.class.getResource(caminho), "FXML não encontrado: " +  caminho));
    }
}
