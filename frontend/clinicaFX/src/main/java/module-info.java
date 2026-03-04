module clinicaFX {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires shared;

    exports com.clinica.fx;
    opens com.clinica.fx.controller to javafx.fxml;
    opens com.clinica.fx.controller.atendente to javafx.fxml;
    opens com.clinica.fx.service to javafx.fxml;
}