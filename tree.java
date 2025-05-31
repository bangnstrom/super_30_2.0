package daythree;

import java.util.Scanner;

public class tree {

    Node root;

    void insert(Node r, Node n) {
        if (root == null) {
            root = n;
        } else {
            while (true) {

                if (n.data < r.data)// left
                {
                    if (r.left == null) {
                        r.left = n; // inserted to left
                        break;
                    } else {
                        r = r.left;
                    }
                } else { // greater or equal
                    if (r.right == null) {
                        r.right = n; // inserted to right
                        break;
                    } else {
                        r = r.right;
                    }
                }
            }
        }

    }

    void inorder(Node r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + ",");
            inorder(r.right);
        }
    }

    int count_nodes(Node r) {

        if (r == null) {
            return 0;
        }
        return 1 + count_nodes(r.left) + count_nodes(r.right);

    }

    int count_leaf(Node r) {
        if (r == null) {
            return 0;
        }
        if (r.left == null && r.right == null) {
            return 1;
        }
        return count_leaf(r.left) + count_leaf(r.right);

    }

    int getDepth(Node r) {
        if (r == null) {
            return 0;
        }
        int leftDepth = getDepth(r.left);
        int rightDepth = getDepth(r.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    boolean search(Node r, int key) {
        if (r == null) {
            return false;
        }

        if (r.data == key) {
            return true;
        } else if (key < r.data) {
            return search(r.left, key);
        } else {
            return search(r.right, key);
        }

    }

    void only_lefts(Node r) {
        if (r == null) {
            return;
        }
        if (r != null) {
            only_lefts(r.left);
            System.out.print(r.data + ",");
            if (r.right != null) {
                only_lefts(r.right.left);

            }
        }
    }

    void only_rights(Node r) {
        if (r == null) {
            return;
        }
        if (r != null) {
            only_rights(r.right);
            System.out.print(r.data + ",");
            if (r.left != null) {
                only_rights(r.left.right);

            }
        }
    }

    boolean isBst(Node r) {
        if (r == null) {
            return true;
        }
        if ((r.left != null && r.data <= r.left.data) || (r.right != null && r.data >= r.right.data)) {
            return false;
        }
        return isBst(r.left) &&
                isBst(r.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tree_values[] = { 22, 64, 64, 43, 3, 236, 575, 45 };
        tree obj = new tree();
        for (int i = 0; i < tree_values.length; i++) {

            obj.insert(obj.root, new Node(tree_values[i]));
        }
        System.out.println("inorder traversal is: ");
        obj.inorder(obj.root);
        System.out.println("\n");
        System.out.println("the count of node is: " + obj.count_nodes(obj.root));
        System.out.println("the count of leaf node is: " + obj.count_leaf(obj.root));
        System.out.println("enter the key to search");
        int n = in.nextInt();
        System.out.println("the key is: " + obj.search(obj.root, n));
        System.out.println("only left tree is: ");
        obj.only_lefts(obj.root);
        System.out.println("\n");
        System.out.println("only right tree is: ");
        obj.only_rights(obj.root);
    }
}
