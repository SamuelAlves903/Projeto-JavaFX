module clinicaFX {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.clinica.fx.controller to javafx.fxml;
    opens com.clinica.fx.model.dto to javafx.base;
    exports com.clinica.fx;
}