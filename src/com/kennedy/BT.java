package com.kennedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by adixith on 1/23/17.
 */
public class BT {
    static class BTNode {
        int data;
        BTNode left;
        BTNode right;
        public BTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    BTNode root;
    public BT(BTNode node) {
        this.root = node;
    }

    public void addNode(BTNode node) {
        BTNode temp = root;
        while(true) {
            if(temp.data > node.data) {
                if(temp.left != null)
                    temp = temp.left;
                else {
                    temp.left = node;
                    break;
                }
            }
            else {
                if(temp.right != null)
                    temp = temp.right;
                else {
                    temp.right = node;
                    break;
                }
            }
        }
    }

    public void addNodeRecursive(BTNode node) {
        addNodeRecursive(root, node);
    }

    public BTNode addNodeRecursive(BTNode main, BTNode nodeToInsert) {
        if(main == null) {
            return nodeToInsert;
        }
        if(main.data >= nodeToInsert.data)
            main.left = addNodeRecursive(main.left, nodeToInsert);
        else
            main.right = addNodeRecursive(main.right, nodeToInsert);
        return main;
    }

    public boolean search(BTNode node, int value) {
        if(node == null)
            return false;
        if(node.data == value)
            return true;
        if(node.data < value)
            return search(node.right, value);
        return search(node.right, value);
    }

    public boolean search(int value) {
        return search(root, value);
    }

    public boolean searchIterative(int value) {
        if(root == null)
            return false;
        BTNode temp = root;
        while(temp != null) {
            if(temp.data == value)
                return true;
            if(temp.data > value)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return false;
    }

    public boolean isBST() {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(BTNode node, int min, int max) {
        if(node == null)
            return true;
        if(node.data < min || node.data > max)
            return false;
        return checkBST(node.left, min, node.data - 1) && checkBST(node.right, node.data + 1, max);
    }

    public void printBT(int option) {
        switch (option) {
            case 1: {
                printBTInOrder(root);
                System.out.println();
                break;
            }
            case 2: {
                printBTPreOrder(root);
                System.out.println();
                break;
            }
            case 3: {
                printBTPostOrder(root);
                System.out.println();
                break;
            }
            case 4: {
                printBTInOrderReversed(root);
                System.out.println();
                break;
            }
            case 5: {
                levelOrderTraversal();
                System.out.println();
                break;
            }
            case 6: {
                levelOrderBigOOfn();
                System.out.println();
                break;
            }
            case 7: {
                prettyPrint();
                System.out.println();
                break;
            }
        }
    }

    public BTNode clone() {
        return clone(root);
    }

    public BTNode clone(BTNode node) {
        if(node == null)
            return null;
        BTNode clonedNode = new BTNode(node.data);
        clonedNode.left = clone(node.left);
        clonedNode.right = clone(node.right);
        return clonedNode;
    }

    public void prettyPrint() {
        Queue<BTNode> queue = new LinkedList<>();
        if(root == null)
            return;
        queue.add(root);
        int spaces = 0;
        while(!queue.isEmpty()) {
            if(spaces == 0)
                System.out.println();
            BTNode temp = queue.poll();
            System.out.print(temp.data + " , ");
            spaces--;
            if(temp.left != null) {
                queue.add(temp.left);
                spaces++;
            }
            if(temp.right != null) {
                queue.add(temp.right);
                spaces++;
            }
        }
    }

    /*
    SortedOrder
     */
    public void printBTInOrder(BTNode node) {
        if(node == null)
            return;
        printBTInOrder(node.left);
        System.out.print(node.data + " , ");
        printBTInOrder(node.right);
    }

    /*
    Reverse sorted order
     */
    public void printBTInOrderReversed(BTNode node) {
        if(node == null)
            return;
        printBTInOrderReversed(node.right);
        System.out.print(node.data + " , ");
        printBTInOrderReversed(node.left);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(BTNode node) {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int diameter() {
        return diameter(root);
    }

    private int diameter(BTNode node) {
        if(node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int leftDiameter = diameter(node.left);
        int rightDiameter = diameter(node.right);
        return Math.max(Math.max(leftDiameter, rightDiameter), 1 + leftHeight + rightHeight);
    }

    public BTNode mirrorClone() {
        return mirrorClone(root);
    }

    private BTNode mirrorClone(BTNode node) {
        if(node == null)
            return null;
        BTNode primary = new BTNode(node.data);
        primary.left = mirrorClone(node.right);
        primary.right = mirrorClone(node.left);
        return primary;
    }

    public BTNode mirrorInPlace() {
        return mirrorInPlace(root);
    }

    private BTNode mirrorInPlace(BTNode node) {
        if(node == null)
            return null;
        mirrorInPlace(node.left);
        mirrorInPlace(node.right);
        BTNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    //The width of a binary tree is the maximum number of elements on one level of the tree.
    public int width() {
        int maxWidth = 0;
        for(int i=0; i < height(); i++) {
            int width = width(root, i);
            if(width > maxWidth)
                maxWidth = width;
        }
        return maxWidth;
    }

    public int width(BTNode node, int level) {
        if(node == null)
            return 0;
        if(level == 0)
            return 1;
        return (width(node.left, level - 1) + width(node.right, level - 1));
    }

    public void printBTMirror() {
        printBTMirror(root);
    }

    public void printBTMirror(BTNode node) {
        if(node == null)
            return;
        printBTInOrder(node.right);
        System.out.print(node.data + " , ");
        printBTInOrder(node.left);
    }

    public void printBTPreOrder(BTNode node) {
        if(node == null)
            return;
        System.out.print(node.data + " , ");
        printBTInOrder(node.left);
        printBTInOrder(node.right);
    }

    public void printBTPostOrder(BTNode node) {
        if(node == null)
            return;
        printBTInOrder(node.left);
        printBTInOrder(node.right);
        System.out.print(node.data + " , ");
    }

    public int kthLargest(int k, BTNode node) {
        if(node == null)
            return k;
        k = kthLargest(k, node.right);
        k--;
        if(k==0) {
            System.out.println(node.data);
            return node.data;
        }
        k = kthLargest(k, node.left);
        return k;
    }

    public int height() {
        return height(root);
    }

    private int height(BTNode node) {
        if(node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int kthLargest(int k) {
        return kthLargest(k, root);
    }

    public BTNode LCA(BTNode a, BTNode b) {
        return LCA(a, b, root);
    }

    private BTNode LCA(BTNode a, BTNode b, BTNode node) {
       if(node == null)
           return null;
        if(a.data > node.data && b.data > node.data)
            return LCA(a, b, node.right);
        if(a.data < node.data && b.data < node.data)
            return LCA(a, b, node.left);
        return node;
    }

    public int numberOfNodes() {
        return numberOfNodes(root, 0);
    }

    private int numberOfNodes(BTNode node, int nodes) {
        if(node == null)
            return nodes;
        return 1 + numberOfNodes(node.left, nodes) + numberOfNodes(node.right, nodes);
    }

    public void levelOrderTraversal() {
        int height = height();
        for(int i=0; i < height; i++)
            printGivenLevel(root, i);
    }

    public void printGivenLevel(BTNode node, int level) {
        if(node == null)
            return;
        if(level == 0) {
            System.out.print(node.data + " , ");
        }
        else {
            printGivenLevel(node.left, level -1);
            printGivenLevel(node.right, level -1);
        }
    }

    public void levelOrderBigOOfn() {
        Queue<BTNode> queue = new LinkedList<>();
        if(root == null)
            return;
        queue.add(root);
        while(!queue.isEmpty()) {
            BTNode temp = queue.poll();
            System.out.print(temp.data + " , ");
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    public static void main(String args[]) {
        /*
        BTNode btNode = new BTNode(6);
        btNode.left = new BTNode(1);
        btNode.right = new BTNode(8);
        btNode.left.right = new BTNode(3);
        btNode.right.right = new BTNode(18);
        BT bt1 = new BT(btNode);

        BTNode nonBtNode = new BTNode(6);
        nonBtNode.left = new BTNode(1);
        nonBtNode.right = new BTNode(8);
        nonBtNode.left.right = new BTNode(12);
        nonBtNode.right.right = new BTNode(18);
        BT nonBt = new BT(nonBtNode);
        */
        /*
        BT bt = new BT(new BTNode(6));
        bt.addNode(new BTNode(8));
        bt.addNode(new BTNode(5));
        bt.addNode(new BTNode(11));
        bt.addNode(new BTNode(23));
        bt.addNode(new BTNode(7));
        bt.addNode(new BTNode(7));
        bt.addNode(new BTNode(14));
        bt.addNode(new BTNode(17));
        bt.addNode(new BTNode(27));
        bt.addNode(new BTNode(12));
        bt.addNode(new BTNode(1));
        bt.addNode(new BTNode(4));
        bt.addNode(new BTNode(20));
        bt.printBT(4);
        bt.printBT(1);
        */
        //bt.printBT(2);
        //bt.printBT(3);
        /*
        BT btR = new BT(new BTNode(6));
        btR.addNodeRecursive(new BTNode(8));
        btR.addNodeRecursive(new BTNode(5));
        btR.addNodeRecursive(new BTNode(11));
        btR.addNodeRecursive(new BTNode(23));
        btR.addNodeRecursive(new BTNode(7));
        btR.printBT(1);

        System.out.println(" is 6 present? " + bt.search(6));
        System.out.println(" is 50 present? " + bt.search(50));
        System.out.println(" is 4 present? " + bt.search(4));
        System.out.println(" is 23 present? " + bt.search(23));
        System.out.println(" is 6 present iter? " + bt.searchIterative(6));
        System.out.println(" is 50 present iter? " + bt.searchIterative(50));
        System.out.println(" is 4 present iter? " + bt.searchIterative(4));
        System.out.println(" is 23 present iter? " + bt.searchIterative(23));
        */
        BT bt = new BT(new BTNode(64));
        bt.addNode(new BTNode(128));
        bt.addNode(new BTNode(32));
        bt.addNode(new BTNode(256));
        bt.addNode(new BTNode(16));
        bt.addNode(new BTNode(512));
        bt.addNode(new BTNode(8));
        bt.addNode(new BTNode(1024));
        bt.addNode(new BTNode(4));
        bt.addNode(new BTNode(700));
        bt.addNode(new BTNode(6));
        bt.addNode(new BTNode(48));
        bt.addNode(new BTNode(96));
        bt.addNode(new BTNode(175));
        bt.addNode(new BTNode(24));
        bt.addNode(new BTNode(40));
        bt.addNode(new BTNode(56));
        //bt.printBT(4);
        //bt.printBT(5);
        bt.printBT(6);
        //bt.printBT(7);
        //bt.printBT(1);
        //bt.printBTMirror();
        //bt.kthLargest(6);
        //System.out.println("Height is " + bt.height());
        //System.out.println("Number of nodes is " + bt.numberOfNodes());
        //System.out.println("Number of leaves is " + bt.countLeaves());
        //System.out.println("Diameter is " + bt.diameter());
        //System.out.println("Width is " + bt.width());
        //BTNode lcaNode = bt.LCA(new BTNode(8), new BTNode(40));
        //System.out.println("LCA is " + lcaNode.data);
        //BT btCloned = new BT(bt.clone());
        //btCloned.printBT(6);

        //BT btMirrorClone = new BT(bt.mirrorClone());
        //btMirrorClone.printBT(6);
        //bt.mirrorInPlace();
        //bt.printBT(6);
        //System.out.println("Is bt bST? " + bt.isBST());
        //System.out.println("Is bt1 bST? " + bt1.isBST());
        //System.out.println("Is nonBt bST? " + nonBt.isBST());
    }
}
