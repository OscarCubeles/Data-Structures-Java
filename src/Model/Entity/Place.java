package Model.Entity;

public class Place {
    int ID;
    String name;
    String type;

    public Place(int ID, String name, String type) {
        this.ID = ID;
        this.name = name;
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getType(){
        return this.type;
    }
}
