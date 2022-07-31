package Model.DataStructures.HashTable;

import Model.Entity.Pirate;

import java.util.LinkedList;

public class HashTable {

    private final int size;
    private final LinkedList<HashList> hashLists;

    public HashTable(int size){
        this.size = size;
        this.hashLists = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            hashLists.add(new HashList());
        }
    }

    public Integer generateHash(String key) {
        int hash = 7;
        for (int i = 0; i < key.length(); i++) {
            hash = hash*31 + key.charAt(i);
        }
        return Math.abs(hash)%size;
    }

    public void addPirate(String key, Pirate value) {
        int hash = generateHash(key);
        if(hashLists.get(hash) == null) {
            hashLists.get(hash).pirateList = new LinkedList<>();
        }
        hashLists.get(hash).addPirate(value);
    }

    public void removePirate(String key){
        int hash = generateHash(key);
        HashList hashList = hashLists.get(hash);
        for(int i = 0; i < hashList.getSize(); i++){
            if(hashList.get(i).getKey().compareTo(key) == 0){
                hashList.pirateList.remove(hashList.get(i));
            }
        }
    }

    public Pirate getPirate(String key){
        int hash = generateHash(key);
        HashList hashList = hashLists.get(hash);
        for(int i = 0; i < hashList.getSize(); i++){
            if(hashList.get(i).getKey().compareTo(key) == 0){
                return hashList.get(i);
            }
        }
        return null;
    }

}
