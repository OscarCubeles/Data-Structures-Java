package Model.DataStructures.AVLBinaryTree;

import Model.Entity.Treasure;

public class NodeBT {
    protected NodeBT right;
    protected NodeBT left;
    private Treasure treasure;
    protected int height;


    public NodeBT(String treasureName, long treasureValue){
        this.treasure = new Treasure(treasureName, treasureValue);
        right = null;
        left = null;
        height = 0;
    }

    public long getValue(){
        return this.treasure.getValue();
    }

    public void setTreasure(Treasure treasure){
        this.treasure = treasure;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public NodeBT right() {
        return right;
    }

    public NodeBT left() {
        return left;
    }

    public void setRight(NodeBT right) {
        this.right = right;
    }

    public void setLeft(NodeBT left) {
        this.left = left;
    }

    public int height(){
        return this.height;
    }

    public int getBalance(){
        return right.height - left.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
