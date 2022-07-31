package View;

import Model.Entity.Place;

public class GraphView {

    public void display(int subMode){
        switch (subMode) {
            case 1 -> {
                System.out.println("\t------------------------------------------------------");
                System.out.print("\tEnter the source vertex name: ");
            }
            case 2 -> System.out.println("\t------------------------------------------------------");
            case 3 -> System.out.println("\tError. There is no place with this name.");
            case 4 -> {
                System.out.println("\t------------------------------------------------------");
                System.out.print("\tEnter the vertex name: ");
            }
            case 5 -> System.out.print("\tEnter the vertex ID: ");
            case 6 -> System.out.print("\tEnter the vertex Type: ");
            case 7 -> {
                System.out.println("\tOperation successfully executed. " +
                        "\n\t(Remember, just adding a Vertex without connection leads to a disconnected graph)");
                System.out.println("\t------------------------------------------------------");
            }
            case 8 -> {
                System.out.println("\tError. The ID must be a numeric value.");
                System.out.println("\t------------------------------------------------------");
            }
            case 9 -> {
                System.out.println("\t------------------------------------------------------");
                System.out.print("\tEnter source Vertex name: ");
            }
            case 10 -> System.out.print("\tEnter destination Vertex name: ");
            case 11 -> System.out.print("\tEnter the distance between vertexes: ");
            case 12 -> {
                System.out.println("\tError. The names of the Vertexes must exist.");
                System.out.println("\t------------------------------------------------------");
            }
            case 13 -> {
                System.out.println("\tError. The distance must be a numeric value.");
                System.out.println("\t------------------------------------------------------");
            }
            case 14 -> {
                System.out.println("\tOperation Successfully executed.");
                System.out.println("\t------------------------------------------------------");
            }
        }
    }

    public void display(Place place){
        System.out.println("\t" + place.getName()
                + "\n\t\tType: " + place.getType()
                + "\n\t\tID: " + place.getID());
    }
}
