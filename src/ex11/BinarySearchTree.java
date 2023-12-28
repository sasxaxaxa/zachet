package ex11;

public class BinarySearchTree {

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Корень дерева
    Node root;

    // Конструктор
    BinarySearchTree() {
        root = null;
    }

    // Вставка элемента
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Рекурсивная функция для вставки элемента
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Поиск элемента
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Рекурсивная функция для поиска элемента
    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    // Обход дерева в прямом порядке (in-order traversal)
    void inorder() {
        inorderRec(root);
    }

    // Рекурсивная функция для обхода дерева в прямом порядке
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.inorder(); // Выводит элементы в отсортированном порядке
    }
}
