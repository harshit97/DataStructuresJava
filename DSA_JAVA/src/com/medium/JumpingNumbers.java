package com.medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {
    static void bfs(int x, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while (!q.isEmpty()) {
            num = q.remove();
            System.out.print(num + " ");
            if (num <= x) {
                int last_dig = num % 10;
                if (last_dig == 0)
                    q.add((num * 10) + (last_dig + 1));
                else if (last_dig == 9)
                    q.add((num * 10) + (last_dig - 1));

                else {
                    q.add((num * 10) + (last_dig - 1));
                    q.add((num * 10) + (last_dig + 1));
                }
            }
        }
    }
    static void printJumping(int x) {
        System.out.print(0 + " ");
        for (int i = 1; i <= 9 && i <= x; i++)
            bfs(x, i);
    }

    public static void main(String...args) {
        int x = 40;
        printJumping(x);
    }
}
