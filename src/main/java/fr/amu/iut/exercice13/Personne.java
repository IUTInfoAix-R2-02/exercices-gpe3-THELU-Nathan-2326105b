package fr.amu.iut.exercice13;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {

    private String nom;
    private IntegerProperty age = new SimpleIntegerProperty();
    private StringProperty villeDeNaissance;

    public Personne(String nom) {
        this.nom = nom;
        this.villeDeNaissance = new SimpleStringProperty("Paris");
    }

    public String getNom() {
        return nom;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public IntegerProperty getAge() {
        return age;
    }

}
