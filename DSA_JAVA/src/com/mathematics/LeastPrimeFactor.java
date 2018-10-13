package com.mathematics;

import java.util.Scanner;
import java.util.Vector;

public class LeastPrimeFactor {
    private static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        int number = input.nextInt();
        Vector<Integer> least_prime = new Vector<>(number+1);
        least_prime.add(0, 0);
        least_prime.add(1, 1);
        for (int i=2;i<=number;i++) {
            if (least_prime.get(i)==null) {
                least_prime.add(i, i);
                for (int j=2*i;j<=number;j+=i) {
                    if (least_prime.get(j)==null)
                        least_prime.set(j, i);
                }
            }
        }
    }
}
