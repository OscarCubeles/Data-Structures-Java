package Model.DAO;

import Model.DataStructures.AVLBinaryTree.BinaryTree;
import Model.DataStructures.AVLBinaryTree.NodeBT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreasureDAO implements TreasureDAOI{
    @Override
    public BinaryTree getPopulatedBT() {
        BinaryTree binaryTree = new BinaryTree();

        try {
            File fileObj = new File(DAOConnector.getInstance().getBinaryTreeDataset());
            Scanner fileReader = new Scanner(fileObj);
            int numTreasures = Integer.parseInt(fileReader.nextLine());
            for (int i = 0; i < numTreasures; i++) {
                String data = fileReader.nextLine();
                String[] line = data.split(",");
                binaryTree.AVLAddNode(Long.parseLong(line[1]), line[0]);
            }
        }catch (FileNotFoundException exception){
            System.out.println("Error. Unable to open" + DAOConnector.getInstance().getTablesDataset());
            System.exit(-1);
        }

        return binaryTree;
    }

}
