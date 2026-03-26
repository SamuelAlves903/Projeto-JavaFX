module shared {
    requires jakarta.validation;
    requires org.hibernate.validator;
    exports com.clinica.fx.dto;
    exports com.clinica.fx.enums;
    exports com.clinica.fx.exceptions;
}