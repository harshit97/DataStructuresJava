package com.fakeorg.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NonRecursiveTraversal {
    public static void preOrderTraversal(Node current) {
        Deque<Node> stack = new LinkedList<>();
        while (true) {
            while (current != null) {
                //System.out.print(current.value + " ");
                stack.offerFirst(current);
                System.out.print("Before Current : " + current.value + " ");
                current = current.left;
                if (current != null)
                    System.out.print("After Current : " + current.value + "\n");
                else
                    System.out.print("After Current : NULL" + "\n");
            }
            if (!stack.isEmpty()) {
                current = stack.peekFirst();
                stack.removeFirst();
                current = current.right;
            } else {
                break;
            }
        }
    }

    public static void inOrderTraversal(Node current) {
        Deque<Node> stack = new LinkedList<Node>();
        while (true) {
            while (current != null) {
                stack.offerFirst(current);
                current = current.left;
            }
            if (stack.isEmpty())
                break;
            current = stack.peekFirst();
            stack.pollFirst();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }

    public static void postOrderTraversal(Node current) {

    }

    public static void levelOrderTraversal(Node current) {
        Queue<Node> nodeDeque = new LinkedList<Node>();
        if (current == null) {
            System.out.println("Tree has no elements !");
            return;
        }
        nodeDeque.add(current);
        while (nodeDeque.isEmpty() == false) {

            System.out.print(nodeDeque.poll() + " ");


            if (current.left != null)
                nodeDeque.add(current.left);
            if (current.right != null)
                nodeDeque.add(current.right);
        }
    }
}
