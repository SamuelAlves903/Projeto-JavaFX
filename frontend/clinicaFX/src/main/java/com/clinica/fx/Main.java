package com.clinica.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/atendente/layout.fxml"));

        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/css/layout.css").toExternalForm());
        stage.setResizable(false);
        stage.setMaximized(true);
//        stage.setTitle("Login - ClinicaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}