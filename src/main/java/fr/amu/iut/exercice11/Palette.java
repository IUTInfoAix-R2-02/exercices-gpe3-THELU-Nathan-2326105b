package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.beans.binding.Bindings.when;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;
    private IntegerProperty nbFois = new SimpleIntegerProperty(0);;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private StringProperty message = new SimpleStringProperty();
    private StringProperty couleurPanneau = new SimpleStringProperty("#000000");

    private Label texteDuBas;


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */

        texteDuHaut.setText("Cliquez sur un bouton");

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> greenButtonClick(actionEvent) );
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> redButtonClick(actionEvent) );
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> blueButtonClick(actionEvent) );
        createBindings();
        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void redButtonClick(Event event) {
        setCouleurPanneau("-fx-background-color: red");
        setMessage(rouge.getText());
        nbRouge+=1;
        setNbFois(nbRouge);
        /*texteDuBas.setText("Rouge est une jolie couleur");
        texteDuBas.setTextFill(Color.web("#FF0000FF"));*/
    }
    private void greenButtonClick(Event event) {
        setCouleurPanneau("-fx-background-color: green");
        setMessage(vert.getText());
        nbVert+=1;
        setNbFois(nbVert);
    }
    private void blueButtonClick(Event event) {
        setCouleurPanneau("-fx-background-color: blue");
        setMessage(bleu.getText());
        nbBleu+=1;
        setNbFois(nbBleu);
    }

    private void createBindings() {
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty();
        pasEncoreDeClic.bind(Bindings.equal(nbFois, 0));
        texteDuHaut.textProperty().bind(when(pasEncoreDeClic).then("Cliquez sur un bouton").otherwise(Bindings.concat(message, " choisie " ,nbFois.asString(), " fois")));
        panneau.styleProperty().bind(couleurPanneau);
        texteDuBas.textProperty().bind(when(pasEncoreDeClic).then("").otherwise(Bindings.concat(message, " est une jolie couleur !")));
        texteDuBas.textFillProperty().bind(Bindings.createObjectBinding(() -> {
            String style = couleurPanneau.get();
            String colorValue = style.replace("-fx-background-color: ", "").trim();
            return Paint.valueOf(colorValue);
        }, couleurPanneau));
    }

    public void setNbFois(int nbFois) {
        this.nbFois.set(nbFois);
    }

    public int getNbFois() {
        return nbFois.get();
    }

    public IntegerProperty nbFoisProperty() {
        return nbFois;
    }

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public String getCouleurPanneau() {
        return couleurPanneau.get();
    }

    public StringProperty couleurPanneauProperty() {
        return couleurPanneau;
    }

    public void setCouleurPanneau(String couleurPanneau) {
        this.couleurPanneau.set(couleurPanneau);
    }
}

