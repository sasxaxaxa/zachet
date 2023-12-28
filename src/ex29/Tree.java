package ex29;

public class Tree {
    TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    public boolean search(int val) {
        return searchNode(root, val);
    }

    private boolean searchNode(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (val < root.val) {
            return searchNode(root.left, val);
        } else if (val > root.val) {
            return searchNode(root.right, val);
        } else {
            return true;
        }
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);

        System.out.println("Inorder traversal of the tree:");
        tree.inorderTraversal();

        int searchValue = 4;
        System.out.println("\nSearching for value " + searchValue + ": " + tree.search(searchValue));
    }
}