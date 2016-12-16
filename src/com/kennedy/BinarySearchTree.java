package com.kennedy;

/**
 * Created by adixith on 12/9/16.
 */
public class BinarySearchTree {
    public class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;
        public BSTNode(int data, BSTNode left, BSTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public BSTNode(int data) {
            this(data, null, null);
        }
    }

    static BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean find(int n) {
        BSTNode current = root;
        while(current != null) {
            if(current.data == n)
                return true;
            else if(current.data < n) {
                current = current.left;
            }
            else
                current = current.right;
        }
        return false;
    }

    public void displayNode(BSTNode current) {
        if(current != null) {
            displayNode(current.left);
            System.out.println(current.data);
            displayNode(current.right);
        }
    }

    public void display() {
        displayNode(root);
    }

    public void insert(int n) {
        BSTNode nodeToInsert = new BSTNode(n);
        if(root == null) {
            root = nodeToInsert;
            return;
        }
        BSTNode current = root;
        BSTNode parent;
        while(true) {
            parent = current;
            if(n <= current.data) {
                current = current.left;
                if(current == null) {
                    parent.left = nodeToInsert;
                    return;
                }
            }
            else {
                current = current.right;
                if(current == null) {
                    parent.right = nodeToInsert;
                    return;
                }
            }
        }
    }

    public void delete(int n) {
        BSTNode parent = root;
        BSTNode current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.data == n) {
                isLeftChild = true;
                break;
            } else if (current.data < n) {
                current = current.left;
            } else
                current = current.right;
        }
        if (current == null)
            return;

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
                return;
            }
            if (isLeftChild) {
                parent.left = null;
            } else
                parent.right = null;
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
                root.left = null;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else
                parent.right = current.left;
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else
                parent.right = current.right;
        } else {
            BSTNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else
                parent.right = successor;
            successor.left = current.left;
        }
    }
        private BSTNode getSuccessor(BSTNode deleteNode) {
            return null;
        }

}
