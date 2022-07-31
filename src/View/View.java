package View;

import Model.Entity.Pirate;
import Model.Entity.Place;
import Model.Entity.Treasure;

public class View {
    private final MainView mainView;
    private final GraphView graphView;
    private final TableView tableView;
    private final BTView btView;
    private String viewMode;


    public View() {
        this.mainView = new MainView();
        this.graphView = new GraphView();
        this.tableView = new TableView();
        this.btView = new BTView();
        this.viewMode = "default";
    }

    public void updateView(){
        this.mainView.display();
    }

    public void updateView(int subMode){
        switch (viewMode) {
            default -> this.mainView.display();
            case "A" -> this.tableView.display(subMode);
            case "B" -> this.graphView.display(subMode);
            case "C" -> this.btView.display(subMode);
        }

    }

    public void updateView(Object object){
        switch (viewMode) {
            case "A" -> this.tableView.display((Pirate) object);
            case "B" -> this.graphView.display((Place) object);
            case "C" -> this.btView.display((Treasure) object);
        }
    }

    public void changeView(String mode){
        switch (mode) {
            case "A", "B", "C","D", "E", "F", "G" , "H", "I",
                    "J", "K", "L", "M", "default" -> this.viewMode = mode;
        }
    }

}
