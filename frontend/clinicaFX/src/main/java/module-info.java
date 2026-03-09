module clinicaFX {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires shared;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    exports com.clinica.fx;
    opens com.clinica.fx.controller to javafx.fxml;
    opens com.clinica.fx.controller.atendente to javafx.fxml;
    opens com.clinica.fx.service to javafx.fxml;
}