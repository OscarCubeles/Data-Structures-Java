package Model.DAO;

import Model.DataStructures.HashTable.HashTable;
import Model.Entity.Pirate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PirateDAO implements PirateDAOI{

    @Override
    public int getNumPirates() {
        try{
            File myObj = new File(DAOConnector.getInstance().getTablesDataset());
            Scanner myReader = new Scanner(myObj);
            return Integer.parseInt(myReader.nextLine());
        }catch(FileNotFoundException exception){
            return -1;
        }
    }

    @Override
    public List<Pirate> getAllPirates() {
        List<Pirate> pirateList = new LinkedList<>();
        try {
            File myObj = new File(DAOConnector.getInstance().getTablesDataset());
            Scanner fileReader = new Scanner(myObj);
            int numPirates = Integer.parseInt(fileReader.nextLine());

            for (int i = 0; i < numPirates; i++) {
                String[] line = fileReader.nextLine().split(",");
                pirateList.add(new Pirate(line[0],line[1],line[2]));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error. Unable to open: " + DAOConnector.getInstance().getTablesDataset());
            System.exit(-1);
        }
        return pirateList;
    }

    @Override
    public HashTable getPopulatedHashTable() {
        List<Pirate> pirateList = getAllPirates();
        HashTable hashTable = new HashTable(getNumPirates());
        for(Pirate pirate: pirateList){
            hashTable.addPirate(pirate.getName(), pirate);
        }
        return hashTable;
    }

}
