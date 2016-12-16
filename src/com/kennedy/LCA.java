package com.kennedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adixith on 12/10/16.
 */
public class LCA {
    class BTNode {
        Object data;
        BTNode left;
        BTNode right;

        public BTNode(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    BTNode root;

    public LCA(BTNode node) {
        this.root = node;
    }

    public BTNode findLCA(BTNode root, BTNode node1, BTNode node2) {
        if(root == null)
            return root;
        if(root.data == node1.data || root.data == node2.data)
            return root;
        BTNode leftLCA = findLCA(root.left, node1, node2);
        BTNode rightLCA = findLCA(root.right, node1, node2);

        if(leftLCA != null && rightLCA != null) {
            return root;
        }
        return (leftLCA != null? leftLCA: rightLCA);
    }

    List<BTNode> path = new ArrayList<>();
    public Boolean findPath(BTNode root, BTNode node, List<BTNode> path) {
        if(root == null)
            return false;
        path.add(root);
        if(root.equals(node)) {
            return true;
        }
        if((root.left != null && findPath(root.left, node, path))
            || (root.right != null && findPath(root.right, node, path))) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}
