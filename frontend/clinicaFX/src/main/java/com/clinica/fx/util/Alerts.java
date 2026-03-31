package com.clinica.fx.util;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Alerts {

    public static void erro(Stage owner, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setHeaderText("Erro!");

        owner.getScene().getRoot().setDisable(true);
        owner.getScene().getRoot().setOpacity(0.5);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Alerts.class.getResource("/css/alerts.css").toExternalForm());
        dialogPane.getStyleClass().add("erro");

        alert.setOnShown(event -> {
            alert.setX(owner.getX() + owner.getWidth() / 2 - alert.getDialogPane().getWidth() / 2 - 12);
            alert.setY(owner.getY() + owner.getHeight() / 2 - 50);
        });

        Scene scene = alert.getDialogPane().getScene();
        scene.setFill(null);

        alert.initStyle(StageStyle.TRANSPARENT);
        alert.showAndWait();

        owner.getScene().getRoot().setDisable(false);
        owner.getScene().getRoot().setOpacity(1);
    }

    public static void aviso(Stage owner, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setHeaderText("Aviso!");

        owner.getScene().getRoot().setDisable(true);
        owner.getScene().getRoot().setOpacity(0.5);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Alerts.class.getResource("/css/alerts.css").toExternalForm());
        dialogPane.getStyleClass().add("aviso");

        alert.setOnShown(event -> {
            alert.setX(owner.getX() + owner.getWidth() / 2 - alert.getDialogPane().getWidth() / 2 - 12);
            alert.setY(owner.getY() + owner.getHeight() / 2 - 50);
        });

        Scene scene = alert.getDialogPane().getScene();
        scene.setFill(null);

        alert.initStyle(StageStyle.TRANSPARENT);
        alert.showAndWait();

        owner.getScene().getRoot().setDisable(false);
        owner.getScene().getRoot().setOpacity(1);
    }

    public static void sucesso(Stage owner, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setHeaderText("Sucesso!");

        owner.getScene().getRoot().setDisable(true);
        owner.getScene().getRoot().setOpacity(0.5);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Alerts.class.getResource("/css/alerts.css").toExternalForm());
        dialogPane.getStyleClass().add("sucesso");

        alert.setOnShown(event -> {
            alert.setX(owner.getX() + owner.getWidth() / 2 - alert.getDialogPane().getWidth() / 2 - 12);
            alert.setY(owner.getY() + owner.getHeight() / 2 - 50);
        });

        Scene scene = alert.getDialogPane().getScene();
        scene.setFill(null);

        alert.initStyle(StageStyle.TRANSPARENT);
        alert.showAndWait();

        owner.getScene().getRoot().setDisable(false);
        owner.getScene().getRoot().setOpacity(1);
    }
}
