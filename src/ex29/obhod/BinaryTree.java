package ex29.obhod;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Рекурсивная функция для обхода дерева в прямом порядке (preorder)
    void printPreorder(Node node) {
        if (node == null)
            return;

        // Посещаем узел
        System.out.print(node.data + " ");

        // Рекурсивно обходим левое поддерево
        printPreorder(node.left);

        // Рекурсивно обходим правое поддерево
        printPreorder(node.right);
    }

    // Рекурсивная функция для обхода дерева в симметричном порядке (inorder)
    void printInorder(Node node) {
        if (node == null)
            return;

        // Рекурсивно обходим левое поддерево
        printInorder(node.left);

        // Посещаем узел
        System.out.print(node.data + " ");

        // Рекурсивно обходим правое поддерево
        printInorder(node.right);
    }

    // Рекурсивная функция для обхода дерева в обратном порядке (postorder)
    void printPostorder(Node node) {
        if (node == null)
            return;

        // Рекурсивно обходим левое поддерево
        printPostorder(node.left);

        // Рекурсивно обходим правое поддерево
        printPostorder(node.right);

        // Посещаем узел
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Прямой порядок (preorder):");
        tree.printPreorder(tree.root);

        System.out.println("\nСимметричный порядок (inorder):");
        tree.printInorder(tree.root);

        System.out.println("\nОбратный порядок (postorder):");
        tree.printPostorder(tree.root);
    }
}