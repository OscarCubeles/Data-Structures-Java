import Controller.MainController;
import Model.GraphModel;
import Model.HashTableModel;
import Model.BinaryTreeModel;
import View.View;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        HashTableModel hashTableModel = new HashTableModel();
        BinaryTreeModel binaryTreeModel = new BinaryTreeModel();
        GraphModel graphModel = new GraphModel();
        View view = new View();
        MainController controller = new MainController(hashTableModel, binaryTreeModel, graphModel, view);



        while(!exit){
            controller.updateView();
            exit = controller.controlUserAction();
        }
    }
}

