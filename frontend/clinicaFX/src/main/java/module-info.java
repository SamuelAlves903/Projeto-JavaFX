module clinicaFX {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.clinica.fx.controller to javafx.fxml;
    exports com.clinica.fx;
}