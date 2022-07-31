package Controller;

import Model.GraphModel;
import Model.HashTableModel;
import Model.BinaryTreeModel;
import View.View;

import java.util.Scanner;

public class MainController {

    private final HashTableModel hashTableModel;
    private final BinaryTreeModel binaryTreeModel;
    private final HashTableController hashTableController;
    private final BinaryTreeController binaryTreeController;
    private final GraphController graphController;
    private final View view;

    public MainController(HashTableModel pirateModel, BinaryTreeModel treasureModel,
                          GraphModel graphModel, View view) {
        this.hashTableModel = pirateModel;
        this.binaryTreeModel = treasureModel;
        this.hashTableController = new HashTableController(pirateModel, view);
        this.binaryTreeController = new BinaryTreeController(treasureModel, view);
        this.graphController = new GraphController(graphModel, view);
        this.view = view;

    }

    public boolean controlUserAction(){
        String userInput = new Scanner(System.in).nextLine();
        switch (userInput){
            case "A":
            case "B":
            case "C":
                view.changeView("A");
                hashTableController.controlUserAction(userInput);
                break;

            case "D":
            case "E":
            case "F":
            case "G":
                view.changeView("B");
                graphController.controlUserAction(userInput);
                break;

            case "H":
            case "I":
            case "J":
            case "K":
            case "L":
                view.changeView("C");
                binaryTreeController.controlUserAction(userInput);
                break;

            case "M":
                return true;

        }
        return false;
    }

    public void updateView(){
        view.updateView();
    }


}
