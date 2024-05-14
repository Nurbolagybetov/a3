/**
 * This class represents a binary search tree implementation.
 * It is used with the provided Main function.
 */
public class MyBinarySearchTree<K extends Comparable<K>, V> {
    public Node root;

    public class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    public void insert(K key) {
        root = insert(root, key);
    }

    private Node insert(Node current, K key) {
        if (current == null)
            return new Node(key, null);
        int compareKeys = key.compareTo(current.key);
        if (compareKeys < 0)
            current.left = insert(current.left, key);
        else
            current.right = insert(current.right, key);
        return current;
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.key).append(" ");
            inOrder(node.right, sb);
        }
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private Node remove(Node current, K key) {
        if (current == null)
            return null;
        int compareKeys = key.compareTo(current.key);
        if (compareKeys < 0)
            current.left = remove(current.left, key);
        else if (compareKeys > 0)
            current.right = remove(current.right, key);
        else {
            if (current.left == null)
                return current.right;
            if (current.right == null)
                return current.left;
            current.key = findSmallestKey(current.right);
            current.right = remove(current.right, current.key);
        }
        return current;
    }

    private K findSmallestKey(Node node) {
        return node.left == null ? node.key : findSmallestKey(node.left);
    }
}
