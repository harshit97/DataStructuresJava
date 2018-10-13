package com.mathematics;

import java.util.Scanner;

public class PairCubeCount {
    private static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        int t = input.nextInt();
        while (t--!=0) {
            int count = 0;
            int number = input.nextInt();
            int number_cbrt = (int)Math.cbrt(number);
            for (int i=1;i<=number_cbrt;i++) {
                int i_cube = i*i*i;
                int diff = number-i_cube;
                double diff_cbrt = Math.cbrt(diff);
                if (diff_cbrt*diff_cbrt*diff_cbrt==diff)
                    count++;
            }
            System.out.println(count);
        }
    }
}
