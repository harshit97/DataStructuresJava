package com.fakeorg.Tree;
class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
public class BinaryTreeBasics {

    private Node root = null;

    public Node getRoot() {
        return root;
    }

    // Add a node to the binary search tree recursively
    private Node addRecursive (Node current, int value) {
        if (current==null)
            return new Node(value);
        else if (current.value<value) {
            current.right = addRecursive(current.right, value);
        }
        else if (current.value>value) {
            current.left = addRecursive(current.left, value);
        }
        else {
            return current;
        }
        return current;
    }

    // Public function to call addRecursive()
    public void addNode (int value) {
        root = addRecursive(root, value);
    }

    public static boolean findElement (Node current, int value) {
        if (current==null)
            return false;
        else if (current.value == value)
            return true;
        return (current.value < value)?
            findElement(current.right, value)
        :
            findElement(current.left, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current==null)
            return current;
        else if (current.value<value)
            current.right = deleteRecursive(current.right, value);
        else if (current.value>value)
            current.left = deleteRecursive(current.left, value);
        else {
            if (current.left==null)
                return deleteRecursive(current.right, value);
            else if (current.right==null)
                return deleteRecursive(current.left, value);
            else {
                current.value = (current.left.value<current.right.value)?current.left.value:current.right.value;
                current.right = deleteRecursive(current.right, current.value);
            }
        }
        return current;
    }

    public void deleteNode (Node treeRoot, int value) {
        root = deleteRecursive(treeRoot, value);
    }



    // START Recursive Traversal Functions
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            traverseInOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }
    // END Recursive Traversal Functions

    public static void main (String...args) {
        BinaryTreeBasics binaryTreeBasics = new BinaryTreeBasics();
        binaryTreeBasics.addNode(1);
        binaryTreeBasics.addNode(0);
        binaryTreeBasics.addNode(3);
        binaryTreeBasics.addNode(4);
        binaryTreeBasics.addNode(5);
        binaryTreeBasics.addNode(6);
        binaryTreeBasics.addNode(7);
        //binaryTreeBasics.addNode(8);

        NonRecursiveTraversal.levelOrderTraversal(binaryTreeBasics.getRoot());
        System.out.println();
        binaryTreeBasics.traversePreOrder(binaryTreeBasics.getRoot());

        System.out.println();
        binaryTreeBasics.deleteNode(binaryTreeBasics.getRoot(), 3);


        binaryTreeBasics.traversePreOrder(binaryTreeBasics.getRoot());



        System.out.println(BinaryTreeBasics.findElement(binaryTreeBasics.getRoot(), 3));


    }
}
