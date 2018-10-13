package com.mathematics;

import java.util.Scanner;

public class EfficientPrimeFactors {
    private static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("------------------ PRIME FACTORS ------------------");
        int number = input.nextInt();
        while (number%2==0) {
            System.out.print(2+" ");
            number /= 2;
        }
        int sqrt = (int)Math.sqrt(number);
        for (int i=3;i<=sqrt;i++) {
            while (number%i==0) {
                System.out.print(i+" ");
                number /= i;
            }
        }
        if (number>2)
            System.out.println(number);
    }
}
