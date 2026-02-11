package com.clinica.fx.util;

import javafx.scene.control.Alert;

public class Alerts {

    public static void erro(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
