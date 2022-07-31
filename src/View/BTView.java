package View;

import Model.Entity.Treasure;

public class BTView {

    public void display(int subMode){
        switch (subMode) {
            case 1 -> {
                System.out.println("\t------------------------------------------------------");
                System.out.print("\tEnter the treasure's name: ");
            }
            case 2 -> System.out.print("\tEnter the treasure's value: ");
            case 3 -> {
                System.out.println("\tOperation successfully executed.");
                System.out.println("\t------------------------------------------------------");
            }
            case 4 -> {
                System.out.println("\tError. Invalid value. It must be a numeric value.");
                System.out.println("\t------------------------------------------------------");
            }
            case 5 -> {
                System.out.println("\t------------------------------------------------------");
                System.out.println("\tThe ordered list of nodes in the Binary Tree is: \n");
            }
            case 6 -> System.out.println("\t------------------------------------------------------");
            case 7 -> System.out.println("\tError. There is no treasure with this name.");
            case 8 -> {
                System.out.println("\t------------------------------------------------------");
                System.out.print("\tEnter the lower range value: ");
            }
            case 9 -> System.out.print("\tEnter the top range value: ");
            case 10 -> {
                System.out.println("\tError. The values entered must be numbers.");
                System.out.println("\t------------------------------------------------------");
            }
            case 11 -> System.out.println("\tTreasures in this range: ");
        }
    }

    public void display(Treasure treasure){
        System.out.println("\tTreasure: " + treasure.getName()
                + "\n\t\tValue: $" + treasure.getValue());

    }

}
