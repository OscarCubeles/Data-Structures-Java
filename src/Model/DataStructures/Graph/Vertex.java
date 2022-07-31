package Model.DataStructures.Graph;

import Model.Entity.Place;

public class Vertex {
    private final Place place;
    private boolean isVisited;


    public Vertex(int ID, String name, String type) {
        this.place = new Place(ID, name, type);
    }

    public String getName(){
        return place.getName();
    }

    public void setUnvisited(){
        this.isVisited = false;
    }

    public void setVisited(){
        this.isVisited = true;
    }

    public boolean isVisited(){
        return isVisited;
    }

    public Place getPlace(){
        return this.place;
    }

}
