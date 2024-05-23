package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;
    private static ListChangeListener<Personne> plusieursChangementsListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne -> new Observable[] {personne.ageProperty()});

        unChangementListener = (ListChangeListener.Change<? extends Personne> event) -> {
            while (event.next()) {
                if (event.wasAdded()) {
                    System.out.println("Ajout : " + event.getAddedSubList().get(0).getNom());
                }
                else if (event.wasRemoved()){
                    System.out.println("Enleve :" + event.getRemoved().get(0).getNom());
                }
                else if (event.wasUpdated()) {
                    System.out.println(event.getList().get(event.getFrom()).getNom() + " a maintenant " + event.getList().get(event.getFrom()).getAge().getValue() +  " ans");
                }
            }
        };

        plusieursChangementsListener = (ListChangeListener.Change<? extends Personne> change) -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    System.out.println("Ajout: ");
                    change.getAddedSubList().forEach (personne -> System.out.println(personne.getNom()));
                }
                else if (change.wasRemoved()) {
                    System.out.println("Enleve: ");
                    change.getRemoved().forEach (personne -> System.out.println(personne.getNom()));
                }
                else if (change.wasUpdated()) {
                    System.out.print("Modifie: ");
                    change.getList().subList(change.getFrom(), change.getTo()).forEach (personne -> System.out.println(personne.getNom() +" a maintenant " +  personne.getAge().getValue() + " ans"));
                }
            }
        };

        lesPersonnes.addListener(plusieursChangementsListener);
        question5();


    }

    public static void question1() {
        Personne pierre = new Personne("Pierre");
        pierre.setAge(20);
        Personne paul = new Personne("Paul");
        paul.setAge(40);
        Personne jacques = new Personne("Jacques");
        jacques.setAge(60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre");
        Personne paul = new Personne("Paul");
        Personne jacques = new Personne("Jacques");
        pierre.setAge(20);
        paul.setAge(40);
        jacques.setAge(60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre");
        Personne paul = new Personne("Paul");
        Personne jacques = new Personne("Jacques");
        pierre.setAge(20);
        paul.setAge(40);
        jacques.setAge(60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre");
        Personne paul = new Personne("Paul");
        Personne jacques = new Personne("Jacques");
        pierre.setAge(20);
        paul.setAge(40);
        jacques.setAge(60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge().getValue()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

