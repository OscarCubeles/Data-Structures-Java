package Model.DAO;

import Model.DataStructures.HashTable.HashTable;
import Model.Entity.Pirate;

import java.util.List;

public interface PirateDAOI {

    int getNumPirates();

    List<Pirate> getAllPirates();

    HashTable getPopulatedHashTable();


}
