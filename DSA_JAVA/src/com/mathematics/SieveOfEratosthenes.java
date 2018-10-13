package com.mathematics;

import com.TimeFunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class SieveOfEratosthenes {
    private static Scanner input;

    private static void primeSieve(int num) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        hashMap.put(1, false);
        for (int i = 2; i <= num; i++) {
            if (hashMap.get(i) == null) {
                System.out.print(i + " ");
                for (int j = i * i; j <= num; j += i) { //Starting from i^2 instead of 2*i
                    hashMap.put(j, false);
                }
            }
        }
        System.out.println("\n" + hashMap);
    }

    public static List<Integer> gauravSen_findAllPrimesUpto(final int n) {
        final boolean[] touched = new boolean[n + 1];
        final double sqrtOfN = Math.sqrt(n);
        final List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 2; i < n; i += 2) {
            touched[i] = true;
        }
        for (int i = 3; i <= sqrtOfN; i++) {
            if (!touched[i]) {
                for (int j = i * i; j <= n; j = j + (i * 2)) {
                    touched[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!touched[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        input = new Scanner(System.in);
        TimeFunctions obj1 = new TimeFunctions(), obj2 = new TimeFunctions();
        System.out.println("Enter a number :");
        int number = input.nextInt();

        /*Setting start Time*/ obj1.setStarTime();
        primeSieve(number);
        /*Setting end Time*/ obj1.setEndTime();

        System.out.println("------Gaurav Sen Method--------");

        /*Setting start Time*/ obj2.setStarTime();
        System.out.println(gauravSen_findAllPrimesUpto(number));
        /*Setting end Time*/ obj2.setEndTime();
        System.out.println();
        System.out.println("1. "+obj1.timeDifference());
        System.out.println("2. "+obj2.timeDifference());
    }
}
