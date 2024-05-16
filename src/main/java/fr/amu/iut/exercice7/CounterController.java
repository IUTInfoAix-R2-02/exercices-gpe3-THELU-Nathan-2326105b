package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    private Button decrementButton;

    @FXML
    private Button incrementButton;

    @FXML
    private Label counterLabel = new Label("0");

    int counter = 0;

    @FXML
    public void increment() {
        counter +=1;
        counterLabel.setText(String.valueOf(counter));
    }

    @FXML
    public void decrement() {
        counter -=1;
        counterLabel.setText(String.valueOf(counter));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}