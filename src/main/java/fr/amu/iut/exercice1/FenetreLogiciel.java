package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        BorderPane bp1 = new BorderPane();

        //Création de la MenuBar en haut de la page
        Menu file = new Menu("File");
        MenuItem file1 = new MenuItem("New");
        MenuItem file2 = new MenuItem("Open");
        MenuItem file3 = new MenuItem("Save");
        MenuItem file4 = new MenuItem("Close");
        file.getItems().addAll(file1, file2, file3, file4);
        Menu edit = new Menu("Edit");
        MenuItem edit1 = new MenuItem("Cut");
        MenuItem edit2 = new MenuItem("Copy");
        MenuItem edit3 = new MenuItem("Paste");
        edit.getItems().addAll(edit1, edit2, edit3);
        Menu help = new Menu("Help");
        MenuBar mb1 = new MenuBar(file, edit, help);
        bp1.setTop(mb1);

        //Création des boutons à gauche
        VBox leftVBox = new VBox();
        HBox leftHBox = new HBox();
        Label labelLeft = new Label("Boutons :");
        Button butLeft1 = new Button("Bouton 1");
        Button butLeft2 = new Button("Bouton 2");
        Button butLeft3 = new Button("Bouton 3");
        leftVBox.setAlignment(Pos.CENTER);
        Separator leftSeparator = new Separator(Orientation.VERTICAL);
        leftVBox.getChildren().addAll(labelLeft, butLeft1, butLeft2, butLeft3);
        leftVBox.setSpacing(5);
        leftHBox.getChildren().addAll(leftVBox, leftSeparator);
        bp1.setLeft(leftHBox);

        //Création du label du bas
        VBox bottomVBox = new VBox();
        Label labelBottom = new Label("Ceci est un label de bas de page");
        Separator bottomSeparator = new Separator(Orientation.HORIZONTAL);
        bottomVBox.getChildren().addAll(bottomSeparator, labelBottom);
        bottomVBox.setAlignment(Pos.CENTER);
        bp1.setBottom(bottomVBox);

        //Création du formulaire au centre
        VBox centerVBox = new VBox();
        HBox centerHBox = new HBox();
        GridPane form = new GridPane();
        form.add(new Label("Name:"), 0, 0);
        form.add(new Label("Email:"), 0, 1);
        form.add(new Label("Password:"), 0, 2);
        form.add(new TextField(), 1, 0);
        form.add(new TextField(), 1, 1);
        form.add(new TextField(), 1, 2);
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER);
        Button centerButton1 = new Button("Submit");
        Button centerButton2 = new Button("Cancel");
        centerHBox.setAlignment(Pos.CENTER);
        centerHBox.getChildren().addAll(centerButton1, centerButton2);
        centerHBox.setSpacing(5);
        centerVBox.setAlignment(Pos.CENTER);
        centerVBox.getChildren().addAll(form, centerHBox);
        centerVBox.setSpacing(5);
        bp1.setCenter(centerVBox);



        //Ajout du contenur à la scene
        Scene scene = new Scene(bp1);
        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

