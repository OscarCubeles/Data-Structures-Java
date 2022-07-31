package View;

import Model.Entity.Pirate;

public class TableView {

    public TableView() {}

    public void display(int subMode){
        switch (subMode) {
            case 1 -> {
                System.out.println("\t------------------------------------------------------");
                System.out.print("\tEnter the pirate's name: ");
            }
            case 2 -> System.out.print("\tEnter the pirate's age: ");
            case 3 -> System.out.print("\tEnter the pirate's role: ");
            case 4 -> {
                System.out.println("\tOperation successfully executed.");
                System.out.println("\t------------------------------------------------------");
            }
            case 5 -> {
                System.out.println("\tError. This pirate does not exist.");
                System.out.println("\t------------------------------------------------------");
            }
        }
    }

    public void display(Pirate pirate) throws NullPointerException{
        System.out.println("\tPirate found.\n" + "\t" + pirate.getName() + "'s age is: " + pirate.getAge()
                + " and it's role is: " +pirate.getRole());

    }
}
