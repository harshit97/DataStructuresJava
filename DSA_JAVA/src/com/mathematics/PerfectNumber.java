package com.mathematics;

import java.util.Scanner;
/*
Given a number and check if a number is perfect or not.
A number is said to be perfect if sum of all its factors excluding the number itself is equal to the number.
 */
public class PerfectNumber {
    private static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        int t = input.nextInt();
        while (t--!=0) {
            int number = input.nextInt();
            if (number<6) {
                System.out.println(0);
                continue;
            }
            int number_cpy = number;
            double number_sqrt = Math.sqrt(number);
            int number_sqrt_int = (int)Math.ceil(number_sqrt);

            int res=1;
            for (int i=2;i<=((int)number_sqrt_int);i++) {
                int curr_sum=0,curr_term=1;
                while (number%i==0) {
                    number/=i;
                    curr_term*=i;
                    curr_sum+=curr_term;
                }
                res*=curr_sum;
            }
            if (res==number_cpy){
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
