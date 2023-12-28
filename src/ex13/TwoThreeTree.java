package ex13;

public class TwoThreeTree {

    class Node {
        int key1;
        int key2;
        Node left;
        Node middle;
        Node right;

        Node(int key1) {
            this.key1 = key1;
        }

        boolean isLeaf() {
            return left == null && middle == null && right == null;
        }

        boolean isTwoNode() {
            return key2 == 0;
        }

        boolean isThreeNode() {
            return key2 != 0;
        }
    }

    private Node root;

    public TwoThreeTree() {
        root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            root = insert(root, key);
        }
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (node.isLeaf()) {
            if (node.isTwoNode()) {
                if (key < node.key1) {
                    node.key2 = node.key1;
                    node.key1 = key;
                } else {
                    node.key2 = key;
                }
            } else {
                if (key < node.key1) {
                    int temp = node.key1;
                    node.key1 = key;
                    node.key2 = temp;
                } else if (key < node.key2) {
                    node.key1 = key;
                } else {
                    node.key2 = key;
                }
            }
            return node;
        } else {
            if (key < node.key1) {
                node.left = insert(node.left, key);
            } else if ((node.isTwoNode() && key > node.key1) || (node.isThreeNode() && key > node.key2)) {
                node.right = insert(node.right, key);
            } else {
                node.middle = insert(node.middle, key);
            }
            return node;
        }
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (node.key1 == key || node.key2 == key) {
            return true;
        } else if (key < node.key1) {
            return search(node.left, key);
        } else if ((node.isTwoNode() && key > node.key1) || (node.isThreeNode() && key > node.key2)) {
            return search(node.right, key);
        } else {
            return search(node.middle, key);
        }
    }
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key1 + " ");
            if (node.isThreeNode()) {
                System.out.print(node.key2 + " ");
            }
            inOrderTraversal(node.middle);
            if (node.isThreeNode()) {
                System.out.print(node.key2 + " ");
            }
            inOrderTraversal(node.right);
        }
    }
    public static void main(String[] args) {
        TwoThreeTree tree = new TwoThreeTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(7);
        tree.inOrderTraversal();  // Вывод: 5 7 10 15 20 25
    }
}
