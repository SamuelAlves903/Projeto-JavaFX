package com.clinica.fx.controller;

import com.clinica.fx.service.LoginService;
import com.clinica.fx.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private LoginService service = new LoginService();

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    public void onButtonLogin(ActionEvent event) {

        try{
            if (service.login(username.getText(), password.getText())) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/atendente/dashboard.fxml"));

                Scene novaScene = new Scene(loader.load());

                Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stageAtual.setScene(novaScene);
                stageAtual.show();
            }
            else {
                Alerts.erro("Usuario ou Senha invalido!");
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
