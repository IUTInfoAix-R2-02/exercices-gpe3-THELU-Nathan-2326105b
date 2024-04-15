package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();

        //Création de la boite d'en haut
        HBox hboxHaut = new HBox();
        this.label = new Label("");
        hboxHaut.getChildren().add(this.label);
        hboxHaut.setAlignment(Pos.CENTER);

        //Création de la Pane
        this.panneau = new Pane();
        this.panneau.setStyle("-fx-background-color: white");

        //Création de la boite d'en bas
        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> greenButtonClick(actionEvent) );
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> redButtonClick(actionEvent) );
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> blueButtonClick(actionEvent) );
        this.bas = new HBox();
        this.bas.setAlignment(Pos.CENTER);
        this.bas.getChildren().addAll(vert, rouge, bleu);

        root.setTop(hboxHaut);
        root.setCenter(panneau);
        root.setBottom(bas);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setHeight(200);
        primaryStage.setWidth(400);
        primaryStage.show();
    }

    private void redButtonClick(Event event) {
        this.panneau.setStyle( "-fx-background-color: red");
        this.nbRouge+=1;
        this.label.setText("Rouge choisi " + this.nbRouge+ " fois");
    }
    private void greenButtonClick(Event event) {
        this.panneau.setStyle( "-fx-background-color: green");
        this.nbVert+=1;
        this.label.setText("Vert choisi " + this.nbVert+ " fois");
    }
    private void blueButtonClick(Event event) {
        this.panneau.setStyle( "-fx-background-color:blue");
        this.nbBleu+=1;
        this.label.setText("Bleu choisi " + this.nbBleu+ " fois");
    }
    public static void main(String[] args) {
        launch(args);
    }
}


