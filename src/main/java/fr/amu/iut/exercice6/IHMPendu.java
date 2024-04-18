package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.security.InvalidParameterException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;

public class IHMPendu extends Application {

    private TextField propLettre;
    private Label textFieldLabel;
    private BorderPane bp1;
    private Scene scene;
    VBox centerBox;
    Label motRecherche;
    Dico dictionnaire = new Dico();
    String mot = dictionnaire.getMot();
    String motCensure = "";
    Label nbVie;
    ImageView pendu;
    int vies = 7;
    Button a = new Button("a");
    Button b = new Button("b");
    Button c = new Button("c");
    Button d = new Button("d");
    Button e = new Button("e");
    Button f = new Button("f");
    Button g = new Button("g");
    Button h = new Button("h");
    Button i = new Button("i");
    Button j = new Button("j");
    Button k = new Button("k");
    Button l = new Button("l");
    Button m = new Button("m");
    Button n = new Button("n");
    Button o = new Button("o");
    Button p = new Button("p");
    Button q = new Button("q");
    Button r = new Button("r");
    Button s = new Button("s");
    Button t = new Button("t");
    Button u = new Button("u");
    Button v = new Button("v");
    Button w = new Button("w");
    Button x = new Button("x");
    Button y = new Button("y");
    Button z = new Button("z");
    HBox boxBouttons;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.bp1 = new BorderPane();

        //Chargement des images
        Image septVies = new Image("exercice6/pendu7.png");

        this.pendu = new ImageView(septVies);

        //Récupération du mot
        this.centerBox = new VBox();
        for (int i = 0; i<mot.length(); i++){
            motCensure +='*';
        }

        //Boutons

        GridPane boutons = new GridPane();
        boutons.add(a, 0, 0);
        boutons.add(b, 1, 0);
        boutons.add(c, 2, 0);
        boutons.add(d, 3, 0);
        boutons.add(e, 4, 0);
        boutons.add(f, 5, 0);
        boutons.add(g, 6, 0);
        boutons.add(h, 7, 0);
        boutons.add(i, 8, 0);
        boutons.add(j, 9, 0);
        boutons.add(k, 0, 1);
        boutons.add(l, 1, 1);
        boutons.add(m, 2, 1);
        boutons.add(n, 3, 1);
        boutons.add(o, 4, 1);
        boutons.add(p, 5, 1);
        boutons.add(q, 6, 1);
        boutons.add(r, 7, 1);
        boutons.add(s, 8, 1);
        boutons.add(t, 9, 1);
        boutons.add(u, 2, 2);
        boutons.add(v, 3, 2);
        boutons.add(w, 4, 2);
        boutons.add(x, 5, 2);
        boutons.add(y, 6, 2);
        boutons.add(z, 7, 2);
        this.boxBouttons = new HBox(boutons);
        boxBouttons.setAlignment(Pos.CENTER);

        boutonR1(a, b, c, d, e, f, g, h, i, j, k, l, m);
        boutonR1(n, o, p, q, r, s, t, u, v, w, x, y, z);

        this.motRecherche = new Label(motCensure);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(pendu, motRecherche, boxBouttons);

        //création du textField pour les lettres
        this.propLettre = new TextField();
        System.out.println(mot);
        input();


        //Création du label du nombre de vies
        this.nbVie = new Label();
        nbVie.setText("Vies restantes : " + vies);

        bp1.setTop(nbVie);
        bp1.setCenter(centerBox);
        bp1.setBottom(propLettre);


        //Interface
        this.scene = new Scene(bp1);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        // A completer

        primaryStage.show();
    }

    private void boutonR1(Button a, Button b, Button c, Button d, Button e, Button f, Button g, Button h, Button i, Button j, Button k, Button l, Button m) {
        a.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        b.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        c.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        d.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        e.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        f.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        g.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        h.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        i.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        j.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        k.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        l.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
        m.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonClick);
    }

    public static void main(String[] args) {
        launch(args);
    }


    public String changeCharInPosition(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }
    private void buttonClick(Event event) {
        Image sixVies = new Image("exercice6/pendu6.png");
        Image cinqVies = new Image("exercice6/pendu5.png");
        Image quatreVies = new Image("exercice6/pendu4.png");
        Image troisVies = new Image("exercice6/pendu3.png");
        Image deuxVies = new Image("exercice6/pendu2.png");
        Image uneVie = new Image("exercice6/pendu1.png");
        Image zeroVies = new Image("exercice6/pendu0.png");

        Button source= (Button) event.getSource();
        String s = source.getText();
        boolean verif = false;
        List<Integer> listePos = dictionnaire.getPositions(s.toCharArray()[0], mot);
        for (int index = 0; index< mot.length();index++){
            if (listePos.contains(index)) {
                verif = true;
                motCensure = changeCharInPosition(index, s.toCharArray()[0], motCensure);
            }
        }
        if (verif == false){
            vies -=1;
            switch(vies){
                case(6):
                    pendu.setImage(sixVies);
                    break;
                case(5):
                    pendu.setImage(cinqVies);
                    break;
                case(4):
                    pendu.setImage(quatreVies);
                    break;
                case(3):
                    pendu.setImage(troisVies);
                    break;
                case(2):
                    pendu.setImage(deuxVies);
                    break;
                case(1):
                    pendu.setImage(uneVie);
                    break;
            }
        }
        if (vies == 0){
            pendu.setImage(zeroVies);
        }
        if(motCensure.equals(mot)){
            System.out.println("Vous avez gagné !");
            Platform.exit();
        }
        nbVie.setText("Vies restantes : " + vies);
        motRecherche.setText(motCensure);
    }

    private void input() {
        Image sixVies = new Image("exercice6/pendu6.png");
        Image cinqVies = new Image("exercice6/pendu5.png");
        Image quatreVies = new Image("exercice6/pendu4.png");
        Image troisVies = new Image("exercice6/pendu3.png");
        Image deuxVies = new Image("exercice6/pendu2.png");
        Image uneVie = new Image("exercice6/pendu1.png");
        Image zeroVies = new Image("exercice6/pendu0.png");



        propLettre.setOnAction((ActionEvent event) -> {
            boolean verif = false;
            String lettre = propLettre.getText();
            List<Integer> listePos = dictionnaire.getPositions(lettre.toCharArray()[0], mot);
            for (int index = 0; index< mot.length();index++){
                if (listePos.contains(index)) {
                    verif = true;
                    motCensure = changeCharInPosition(index, lettre.toCharArray()[0], motCensure);
                }
            }
            propLettre.deleteText(0, 1);
            if (verif == false){
                vies -=1;
                switch(vies){
                    case(6):
                        pendu.setImage(sixVies);
                        break;
                    case(5):
                        pendu.setImage(cinqVies);
                        break;
                    case(4):
                        pendu.setImage(quatreVies);
                        break;
                    case(3):
                        pendu.setImage(troisVies);
                        break;
                    case(2):
                        pendu.setImage(deuxVies);
                        break;
                    case(1):
                        pendu.setImage(uneVie);
                        break;
                }
            }
            if (vies == 0){
                pendu.setImage(zeroVies);
            }
            if(motCensure.equals(mot)){
                System.out.println("Vous avez gagné !");
                Platform.exit();
            }
            nbVie.setText("Vies restantes : " + vies);
            motRecherche.setText(motCensure);
        });
    }
}
