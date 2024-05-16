package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private TextField Uid;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okid;

    @FXML
    private Button cancelid;


    @FXML
    private void okClicked() {
        String mot = "";
        for(int i = 0; i<pwd.getLength(); i++){
            mot+='*';
        }
        System.out.println(Uid.getText());
        System.out.println(mot);
    }
    @FXML
    private void cancelClicked() {
        Uid.setText("");
        pwd.setText("");

    }
}