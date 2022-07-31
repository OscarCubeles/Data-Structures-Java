package Controller;

import Model.DataStructures.AVLBinaryTree.NodeBT;
import Model.Entity.Treasure;
import Model.BinaryTreeModel;
import View.View;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTreeController {
    private final BinaryTreeModel binaryTreeModel;
    private final View view;

    public BinaryTreeController(BinaryTreeModel treasureModel, View view) {
        this.binaryTreeModel = treasureModel;
        this.view = view;
    }

    public void controlUserAction(String mode){
        switch (mode) {
            case "H" -> addTreasure();
            case "I" -> removeTreasure();
            case "J" -> inOrderTree();
            case "K" -> searchByValue();
            case "L" -> searchByRange();
        }
    }

    private void addTreasure(){
        String name;
        String age;
        view.updateView(1);
        name = new Scanner(System.in).nextLine();
        view.updateView(2);
        age = new Scanner(System.in).nextLine();
        try{
            binaryTreeModel.addBTNode(name, Long.parseLong(age));
            view.updateView(3);
        }catch(NumberFormatException exception){
            view.updateView(4);
        }
    }

    private void removeTreasure(){
        String name;
        view.updateView(1);
        name = new Scanner(System.in).nextLine();
        try{
            binaryTreeModel.deleteBTNode(name);
            view.updateView(3);

        }catch (NullPointerException exception){
            view.updateView(4);
        }

    }

    private void inOrderTree(){
        view.updateView(5);
        inOrderTree(binaryTreeModel.getBinaryTree().getRoot());
        view.updateView(6);
    }

    private void inOrderTree(NodeBT node){
        if(node != null){
            inOrderTree(node.left());
            view.updateView(node.getTreasure());
            inOrderTree(node.right());
        }
    }

    private void searchByValue(){
        String name;
        view.updateView(1);
        name = new Scanner(System.in).nextLine();
        if(binaryTreeModel.getBinaryTree().isTreasureInTree(name)){
            findNode(binaryTreeModel.getBinaryTree().getRoot(), name);
        }else{
            view.updateView(7);
        }
        view.updateView(6);
    }

    private void findNode(NodeBT node, String name){
        if(node != null){
            if(node.getTreasure().getName().compareTo(name) == 0){
               view.updateView(node.getTreasure());
            }else{
                findNode(node.left(), name);
                findNode(node.right(), name);
            }
        }
    }

    private void searchByRange(){
        LinkedList<Treasure> treasuresInRange;
        String low, high;
        view.updateView(8);
        low = new Scanner(System.in).nextLine();
        view.updateView(9);
        high = new Scanner(System.in).nextLine();

        try{
            binaryTreeModel.initRangeSearch();
            treasuresInRange = binaryTreeModel.getRangeSearchTreasures(Long.parseLong(low), Long.parseLong(high));
            view.updateView(11);
            for (Treasure treasure: treasuresInRange) {
                view.updateView(treasure);
            }
            view.updateView(6);
        }catch(NumberFormatException e){
            view.updateView(10);
        }
    }

}
