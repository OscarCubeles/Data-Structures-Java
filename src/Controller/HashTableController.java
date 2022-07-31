package Controller;

import Model.Entity.Pirate;
import Model.HashTableModel;
import View.View;

import java.util.Scanner;

public class HashTableController {

    private final HashTableModel hashTableModel;
    private final View view;

    public HashTableController(HashTableModel pirateModel, View view) {
        this.hashTableModel = pirateModel;
        this.view = view;
    }

    private void addPirate(){
        String name;
        String age;
        String role;
        view.updateView(1);
        name = new Scanner(System.in).nextLine();
        view.updateView(2);
        age = new Scanner(System.in).nextLine();
        view.updateView(3);
        role = new Scanner(System.in).nextLine();
        hashTableModel.addPirate(name, new Pirate(name, age, role));
        view.updateView(4);
    }

    /**
     * Removes the pirate from the Hash Table if it exists, if not it does not alter anything
     */
    private void removePirate(){
        String key;
        view.updateView(1);
        key = new Scanner(System.in).nextLine();
        hashTableModel.removePirate(key);
        view.updateView(4);
    }

    private void findPirate(){
        String key;
        view.updateView(1);
        key = new Scanner(System.in).nextLine();
        try{
            Pirate tmp = hashTableModel.getPirate(key);
            view.updateView(tmp);
            view.updateView(4);
        }catch(NullPointerException exception){
            view.updateView(5);
        }
    }

    public void controlUserAction(String mode){

        switch (mode) {
            case "A" -> addPirate();
            case "B" -> removePirate();
            case "C" -> findPirate();
        }
    }


}
