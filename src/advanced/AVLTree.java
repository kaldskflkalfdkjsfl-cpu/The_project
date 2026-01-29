package advanced;

import java.util.*;

/**
 * Professional AVL Tree - Self-Balancing Binary Search Tree.
 */
public class AVLTree<T extends Comparable<T>> {
    private class Node {
        T data;
        int height;
        Node left, right;
        Node(T data) { this.data = data; this.height = 1; }
    }

    private Node root;

    public void insert(T data) { root = insert(root, data); }

    private Node insert(Node node, T data) {
        if (node == null) return new Node(data);
        if (data.compareTo(node.data) < 0) node.left = insert(node.left, data);
        else if (data.compareTo(node.data) > 0) node.right = insert(node.right, data);
        else return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // LL
        if (balance > 1 && data.compareTo(node.left.data) < 0) return rightRotate(node);
        // RR
        if (balance < -1 && data.compareTo(node.right.data) > 0) return leftRotate(node);
        // LR
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private int height(Node n) { return n == null ? 0 : n.height; }
    private int getBalance(Node n) { return n == null ? 0 : height(n.left) - height(n.right); }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public void traverse() { inorder(root); System.out.println(); }
    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
}
