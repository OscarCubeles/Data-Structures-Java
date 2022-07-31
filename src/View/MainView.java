package View;

public class MainView {

    private final String menu;

    public MainView(){
        menu =
        "\n -- Java Data Structures -- " +
        "\n\n\tHash Tables" +
                "\n\t\tA. Add Pirate" +
                "\n\t\tB. Remove Pirate" +
                "\n\t\tC. Show Pirate" +
        "\n\n\tGraphs" +
                "\n\t\tD. Find Points of Interest (DFS)" +
                "\n\t\tE. Find Danger Points (BFS)" +
                "\n\t\tF. Add Vertex" +
                "\n\t\tG. Add Connection" +
        "\n\n\tBinary Trees" +
                "\n\t\tH. Add Treasure (BT Insertion)"+
                "\n\t\tI. Remove Treasure (BT Deletion)"+
                "\n\t\tJ. List Loot (BT Inorder)" +
                "\n\t\tK. Search by Exact Value"+
                "\n\t\tL. Search by Range"+
        "\n\n\tM. Exit Program" +
        "\n\n\tWhich functionality do you want to run ? ";
    }

    public void display(){
        System.out.print(menu);
    }



}
