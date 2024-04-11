package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Random;

public class TicTacToe extends Application {

    public Node tirageAlea() {
        Random random = new Random();
        int nombre = random.nextInt(3);
        ImageView vide = new ImageView("exercice2/Vide.png");
        ImageView croix = new ImageView("exercice2/Croix.png");
        ImageView rond = new ImageView("exercice2/Rond.png");
        if (nombre == 0) {
            return croix;
        }
        else if (nombre == 1) {
            return rond;
        }
        else{
            return vide;
        }
    }

    @Override
    public void start(Stage primaryStage) {

        //Création du conteneur de départ
        GridPane gp1 = new GridPane();

        //Création des différents label de cases
        Label hautGauche = new Label();
        Label haut = new Label();
        Label hautDroite = new Label();
        Label milieuGauche = new Label();
        Label milieu = new Label();
        Label milieuDroite = new Label();
        Label basGauche = new Label();
        Label bas = new Label();
        Label basDroite = new Label();

        //Attribution des emplacements de cases
        gp1.add(hautGauche, 0, 0);
        gp1.add(haut, 1, 0);
        gp1.add(hautDroite, 2, 0);
        gp1.add(milieuGauche, 0, 1);
        gp1.add(milieu, 1, 1);
        gp1.add(milieuDroite, 2, 1);
        gp1.add(basGauche, 0, 2);
        gp1.add(bas, 1, 2);
        gp1.add(basDroite, 2, 2);
        gp1.setGridLinesVisible(true);

        //Tirage au sort de ce qui sera affiché
        hautGauche.setGraphic(this.tirageAlea());
        haut.setGraphic(this.tirageAlea());
        basDroite.setGraphic(this.tirageAlea());
        milieuGauche.setGraphic(this.tirageAlea());
        milieu.setGraphic(this.tirageAlea());
        milieuDroite.setGraphic(this.tirageAlea());
        basGauche.setGraphic(this.tirageAlea());
        bas.setGraphic(this.tirageAlea());
        basDroite.setGraphic(this.tirageAlea());

        //Ajout du contenu à la scene
        Scene scene = new Scene(gp1);

        //Ajout de la scene à la fenêtre et changement de ses paramètres
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

