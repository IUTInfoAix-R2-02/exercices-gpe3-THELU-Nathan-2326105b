package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.beans.binding.Bindings.when;

public class LoginControl extends GridPane implements Initializable {
    @FXML
    private TextField userId;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button okBtn;
    @FXML
    private Button cancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
        createBindings();
    }


    private void createBindings() {
            BooleanBinding motDePasseValide = Bindings.createBooleanBinding(() ->
                    pwd.getText().length() >= 8 && pwd.getText().matches(".[A-Z].") && pwd.getText().matches(".[0-9]."),pwd.textProperty()
            );
            okBtn.disableProperty().bind(motDePasseValide.not());
            cancelBtn.disableProperty().bind(
                    Bindings.createBooleanBinding(() -> userId.getText().isEmpty() && pwd.getText().isEmpty(), userId.textProperty(), pwd.textProperty())
            );
            pwd.editableProperty().bind(userId.lengthProperty().greaterThanOrEqualTo(6));
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}