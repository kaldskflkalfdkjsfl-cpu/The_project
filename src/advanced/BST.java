package advanced;

/**
 * Professional Binary Search Tree (BST).
 */
public class BST<T extends Comparable<T>> {
    private class Node {
        T data;
        Node left, right;
        Node(T data) { this.data = data; }
    }

    private Node root;

    public void insert(T data) { root = insertRecursive(root, data); }

    private Node insertRecursive(Node root, T data) {
        if (root == null) return new Node(data);
        if (data.compareTo(root.data) < 0)
            root.left = insertRecursive(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRecursive(root.right, data);
        return root;
    }

    public boolean search(T data) { return searchRecursive(root, data); }

    private boolean searchRecursive(Node root, T data) {
        if (root == null) return false;
        if (root.data.equals(data)) return true;
        return data.compareTo(root.data) < 0 
            ? searchRecursive(root.left, data) 
            : searchRecursive(root.right, data);
    }

    public void traverse() {
        System.out.print("In-order: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
