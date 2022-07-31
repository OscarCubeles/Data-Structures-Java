package Model;

import Model.DAO.PirateDAO;
import Model.DAO.PirateDAOI;
import Model.DataStructures.HashTable.HashTable;
import Model.Entity.Pirate;


public class HashTableModel {
    private final PirateDAOI pirateDAO;
    private final HashTable hashTable;

    public HashTableModel(){
        pirateDAO = new PirateDAO();
        hashTable = getPirateTable();
    }

    public HashTable getPirateTable(){
        return pirateDAO.getPopulatedHashTable();
    }

    public void addPirate(String key, Pirate value){
        hashTable.addPirate(key, value);
    }

    public void removePirate(String key){
        hashTable.removePirate(key);
    }

    public Pirate getPirate(String key){
        return hashTable.getPirate(key);
    }




}
