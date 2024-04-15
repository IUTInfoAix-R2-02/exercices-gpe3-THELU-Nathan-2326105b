package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Collection;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //Création des obstacles
        Obstacle mur1 = new Obstacle();
        mur1.setX(300);
        mur1.setY(300);
        mur1.setHeight(10);
        mur1.setWidth(10);

        Obstacle mur2 = new Obstacle();
        mur2.setX(50);
        mur2.setY(50);
        mur2.setHeight(100);
        mur2.setWidth(100);

        ArrayList<Obstacle> list = new ArrayList<>();
        list.add(mur1);
        list.add(mur2);

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(mur1);
        jeu.getChildren().add(mur2);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, list);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, ArrayList<Obstacle> alO) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double x1 = j1.getLayoutX();
            double y1 = j1.getLayoutY();
            double x2 = j2.getLayoutX();
            double y2 = j2.getLayoutY();
            int coupJ1 = 0;
            int coupJ2 =0;
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
            }
            if (j1.estEnCollision(j2)) {
                Platform.exit();
            }

            for(int i = 0; i <alO.size(); i++) {
                if (j1.estEnCollision(alO.get(i))) {
                    j1.setLayoutX(x1);
                    j1.setLayoutY(y1);
                }
                if (j2.estEnCollision(alO.get(i))) {
                    j2.setLayoutX(x2);
                    j2.setLayoutY(y2);
                }
            }
            });
    }
}
