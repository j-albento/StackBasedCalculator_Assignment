public class BinarySearchTree {

    // -------- Node class --------
    private class Node {
        String key;
        int value;
        Node left, right;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    // -------- INSERT --------
    public void insert(String key, int value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node current, String key, int value) {
        if (current == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(current.key);

        if (cmp < 0) {
            current.left = insertRec(current.left, key, value);
        } else if (cmp > 0) {
            current.right = insertRec(current.right, key, value);
        } else {
            // key already exists → update value
            current.value = value;
        }
        return current;
    }

    // -------- SEARCH --------
    public Integer search(String key) {
        return searchRec(root, key);
    }

    private Integer searchRec(Node current, String key) {
        if (current == null) return null;

        int cmp = key.compareTo(current.key);

        if (cmp == 0) {
            return current.value;
        } else if (cmp < 0) {
            return searchRec(current.left, key);
        } else {
            return searchRec(current.right, key);
        }
    }

    // -------- DELETE ONE KEY --------
    public void delete(String key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node current, String key) {
        if (current == null) return null;

        int cmp = key.compareTo(current.key);

        if (cmp < 0) {
            current.left = deleteRec(current.left, key);
        } else if (cmp > 0) {
            current.right = deleteRec(current.right, key);
        } else {
            // Case 1 & 2: zero or one child
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            // Case 3: two children
            Node successor = findMin(current.right);
            current.key = successor.key;
            current.value = successor.value;
            current.right = deleteRec(current.right, successor.key);
        }
        return current;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // -------- DELETE ALL --------
    public void deleteAll() {
        root = null;
    }

    // -------- DISPLAY TREE --------
    public void displayTree() {
        displayRec(root, 0);
    }

    private void displayRec(Node node, int level) {
        if (node == null) return;

        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println("==> " + node.key + ":" + node.value);

        displayRec(node.left, level + 1);
        displayRec(node.right, level + 1);
    }
}