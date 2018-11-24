/*
You are given an array of N integers. The given array is circular in nature i.e. 
after A(N-1)-th element, A1-th element comes. 
Now, you have to calculate the subarray (contiguous elements) of exactly N/2 length which has the minimum sum of their elements.
*/
package com.misc;

import java.util.Scanner;

public class TCS_ArrayMinContigousSum {
	private static Scanner input;
	public static void main(String args[] ) throws Exception {
		input = new Scanner(System.in);
		int N = input.nextInt();
		int array[] = new int[N];
		int array_sum[] = new int[N];
		for (int i=0;i<N;i++)
			array[i] = input.nextInt();
		array_sum[0] = array[0];
		for (int i=1;i<N;i++)
			array_sum[i] = array_sum[i-1] + array[i];
		
		int subarray_size = N/2;
		int min_sum = Integer.MAX_VALUE;
		for (int i=0;i<N;i++) {
			int end_index = i+(subarray_size-1);
			if (end_index>N-1) {
				end_index = (end_index % (N-1))-1;
				int sum = array_sum[end_index] + (array_sum[N-1] - array_sum[i-1]);
				if (sum<min_sum)
					min_sum = sum;
			}
			else {
				int sum = 0;
				if (i-1>=0)
					sum = array_sum[end_index] - array_sum[i-1];
				else 
					sum = array_sum[end_index];
				
				if (sum<min_sum)
					min_sum = sum;	
			}
		}
		System.out.println(min_sum);
	}

}
