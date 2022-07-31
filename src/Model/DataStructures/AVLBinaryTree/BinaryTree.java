package Model.DataStructures.AVLBinaryTree;

import Model.Entity.Treasure;

import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTree {
    NodeBT root;
    HashMap<String, Long> treasureMap;
    LinkedList<Treasure> rangeNodes;

    public BinaryTree() {
        this.root = null;
        treasureMap = new  HashMap<>();
    }

    public void AVLAddNode(long value, String name) {
        root = AVLInsertNode(root, value, name);
        treasureMap.put(name, value);
    }

    private NodeBT AVLInsertNode(NodeBT current, long value, String name) {
        if (current == null) {
            return new NodeBT(name, value);
        }

        if (value < current.getValue()) {
            current.left = AVLInsertNode(current.left, value, name);
        } else if (value > current.getValue()) {
            current.right = AVLInsertNode(current.right, value, name);
        } else {
            return current;
        }

        return AVLBalance(current);
    }

    private NodeBT AVLBalance(NodeBT node) {
        AVLUpdateHeight(node);
        int balance = AVLGetBalance(node);
        if (balance > 1) {
            if (AVLHeight(node.right.right) <= AVLHeight(node.right.left)) {
                node.right = AVLRotateRight(node.right);
            }
            node = AVLRotateLeft(node);
        } else if (balance < -1) {
            if (AVLHeight(node.left.left) <= AVLHeight(node.left.right)) {
                node.left = AVLRotateLeft(node.left);
            }
            node = AVLRotateRight(node);
        }
        return node;
    }

    private int AVLGetBalance(NodeBT node){
        return node == null ? 0 : AVLHeight(node.right) - AVLHeight(node.left);
    }

    private void AVLUpdateHeight(NodeBT node) {
        if (AVLHeight(node.left) > AVLHeight(node.right)) {
            node.height = 1 + AVLHeight(node.left);
        } else {
            node.height = 1 + AVLHeight(node.right);
        }
    }

    private int AVLHeight(NodeBT node){
        return node == null ? -1 : node.height();
    }


    private NodeBT AVLRotateLeft(NodeBT node) {
        NodeBT right = node.right;
        NodeBT rightLeft = right.left;
        right.left = node;
        node.right = rightLeft;
        AVLUpdateHeight(node);
        AVLUpdateHeight(right);

        return right;
    }

    private NodeBT AVLRotateRight(NodeBT node) {
        NodeBT left = node.left;
        NodeBT leftRight = left.right;
        left.right = node;
        node.left = leftRight;
        AVLUpdateHeight(node);
        AVLUpdateHeight(left);

        return left;
    }

    public NodeBT AVLDeleteNode(NodeBT current, long value) {
        if (current == null) {
            return null;
        }
        if (value < current.getValue()) {
            current.left = AVLDeleteNode(current.left, value);
        } else if (value > current.getValue()) {
            current.right = AVLDeleteNode(current.right, value);
        } else {
            if (current.right == null) {
                current = current.left;
            } else if (current.left == null) {
                current = current.right;
            } else {
                NodeBT smallestNode = smallestValue(current.right);
                current.setTreasure(smallestNode.getTreasure());
                current.right = AVLDeleteNode(current.right, smallestNode.getValue());
            }
        }

        if (current != null) {
            current = AVLBalance(current);
        }

        return current;
    }

    private NodeBT smallestValue(NodeBT root) {
        if (root.left == null) {
            return root;
        } else {
            return smallestValue(root.left);
        }
    }

    public NodeBT getRoot() {
        return root;
    }

    public void setRoot(NodeBT newRoot){
        this.root = newRoot;
    }

    public long getNodeValue(String name){
        return treasureMap.get(name);
    }

    public void deleteFromMap(String key){
        treasureMap.remove(key);
    }

    public boolean isTreasureInTree(String treasureName){
            return treasureMap.get(treasureName) != null;
    }

    public void initRangeSearch(){
        rangeNodes = new LinkedList<>();
    }

    public void addRangeNode(Treasure treasure){
        rangeNodes.add(treasure);
    }

    public int searchRange(NodeBT current, long low, long high) {
        if (current == null) {
            return 0;
        }

        if (current.getValue() >= low && current.getValue() <= high) {
            rangeNodes.add(current.getTreasure());
            return 1 + searchRange(current.left, low, high) + searchRange(current.right, low, high);
        } else if (current.getValue() > high) {
            return searchRange(current.left, low, high);
        } else {
            return searchRange(current.right, low, high);
        }
    }

    public LinkedList<Treasure> getRangeNodes() {
        return rangeNodes;
    }
}
