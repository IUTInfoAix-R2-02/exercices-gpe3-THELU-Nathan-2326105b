package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.format.TextStyle;
import java.util.ArrayList;

public class IHMPendu extends Application {

    private TextField propLettre;

    private Label textFieldLabel;

    Dico dictionnaire = new Dico();
    String mot = dictionnaire.getMot();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp1 = new BorderPane();

        //Récupération du mot
        HBox centerBox = new HBox();
        String motCensure = "";
        for (int i = 0; i<mot.length(); i++){
            motCensure +='*';
        }
        Label motRecherche = new Label(motCensure);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().add(motRecherche);

        //création du textField pour les lettres
        this.propLettre = new TextField();
        propLettre.setOnAction( actionEvent -> handleButonClick(actionEvent) );


        //Création du label du nombre de vies
        int vies = mot.length()+3;
        Label nbVie = new Label();
        nbVie.setText("Vies restantes : " + vies);

        bp1.setTop(nbVie);
        bp1.setCenter(centerBox);
        bp1.setBottom(propLettre);


        //Interface
        Scene scene = new Scene(bp1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        // A completer

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void handleButonClick(Event event) {
        ArrayList<Integer> lisPos = dictionnaire.getPositions(char lettre, this.mot);
    }
}
