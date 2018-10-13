package com.gfg.sudo_placement.Arrays;

import java.util.Scanner;

public class ImmediateSmallerElement {
    private static Scanner input;
    static void  immediateSmallerElement(int arr[], int size) {
        for (int i=0;i<size-1;i++) {
            if (arr[i]>arr[i+1])
                System.out.print(arr[i+1]+" ");
            else
                System.out.print("-1 ");
        }
        System.out.print("-1\n");
    }
    public static void main (String...args) {
        input = new Scanner(System.in);
        int n, t = input.nextInt();
        while (t--!=0) {
            n = input.nextInt();
            int array[] = new int[n];
            for (int i=0;i<n;i++) {
                array[i] = input.nextInt();
            }
            immediateSmallerElement(array, n);
        }
    }
}
