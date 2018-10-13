package com.puzzle;
/*
Given a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on.
You are given a number N, you have to print the number of integers less than N in the sample space S.
*/

import java.util.HashMap;
import java.util.Scanner;

public class CountSquares {
    private static Scanner input;
    static HashMap<Long, Long> hmap = new HashMap<>();

    static boolean isPerfectSquare(long number){
        double sr = Math.sqrt(number);
        return ((sr - Math.floor(sr)) == 0);
    }

    static long returnCount_recursive (long n) {
        if (hmap.get(n)!=null)
            return hmap.get(n);
        else {
            long x = returnCount_recursive(n-1);
            if (isPerfectSquare(n-1)) {
                hmap.put(n, x+1);
                return hmap.get(n);
            }
            else {
                hmap.put(n, hmap.get(n-1));
                return hmap.get(n);
            }
        }
    }

    static long returnCount_iterative (long n) {
        if (hmap.get(n)==null) {
            long n_copy = n;
            while (n_copy--!=1) {
                if (hmap.get(n_copy)!=null)
                    break;
            }
            for (long i=n_copy;i<n;i++) {
                if (isPerfectSquare(i))
                    hmap.put(i+1, hmap.get(i)+1);
                else
                    hmap.put(i+1, hmap.get(i));
            }
        }
        return hmap.get(n);
    }

    static long returnCount_efficient (long n) {
        return (long)Math.floor (Math.sqrt(n));
    }
    public static void main(String[] args) {
        input = new Scanner(System.in);
        int t = input.nextInt();
        Long one = new Long(1);
        Long zero = new Long(0);
        hmap.put(one, zero);
        hmap.put(zero, zero);
        long n = 0L;
        while (t--!=0) {
            n = input.nextLong();
            System.out.println(returnCount_efficient(n));
        }
    }
}
