package com;

import java.util.*;
class GFG {
    static int gcd (int a, int b) {
        if (b==0)
            return a;
        return gcd(b, a%b);
    }
    private static Scanner input;
    public static void main (String[] args) {
        input = new Scanner(System.in);
        int t = input.nextInt();
        while (t--!=0) {
            int n = input.nextInt();
            int arr[] = new int[n];
            for (int i=0;i<n;i++) {
                arr[i] = input.nextInt();
            }
            int result = arr[0];
            for (int i=1;i<n;i++) {
                 result = gcd (result, arr[i]);
            }
            System.out.println(result);
        }
    }
}