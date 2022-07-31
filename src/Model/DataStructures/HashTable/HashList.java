package Model.DataStructures.HashTable;

import Model.Entity.Pirate;

import java.util.LinkedList;

public class HashList {
    protected LinkedList<Pirate> pirateList;

    public HashList(){
        pirateList = new LinkedList<>();
    }

    public void addPirate(Pirate pirate){
        this.pirateList.add(pirate);
    }

    public int getSize(){
        return pirateList.size();
    }

    public Pirate get(int i){
        return pirateList.get(i);
    }

}
