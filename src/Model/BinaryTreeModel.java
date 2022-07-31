package Model;

import Model.DAO.TreasureDAO;
import Model.DAO.TreasureDAOI;
import Model.DataStructures.AVLBinaryTree.BinaryTree;
import Model.DataStructures.AVLBinaryTree.NodeBT;
import Model.Entity.Treasure;

import java.util.LinkedList;

public class BinaryTreeModel {
    private final TreasureDAOI treasureDAO;
    private final BinaryTree binaryTree;

    public BinaryTreeModel() {
        this.treasureDAO = new TreasureDAO();
        this.binaryTree = treasureDAO.getPopulatedBT();

    }

    public void deleteBTNode(String name){
        NodeBT newRoot = binaryTree.AVLDeleteNode(binaryTree.getRoot(),binaryTree.getNodeValue(name));
        binaryTree.setRoot(newRoot);
        binaryTree.deleteFromMap(name);
    }

    public void addBTNode(String name, long value){
        binaryTree.AVLAddNode(value, name);
    }

    public BinaryTree getBinaryTree() {
        return binaryTree;
    }

    public void initRangeSearch(){
        binaryTree.initRangeSearch();
    }

    public LinkedList<Treasure> getRangeSearchTreasures(long low, long high){
        if(low > high){
            long aux = low;
            low = high;
            high = aux;
        }
        binaryTree.searchRange(binaryTree.getRoot(), low, high);
        return binaryTree.getRangeNodes();
    }


}
