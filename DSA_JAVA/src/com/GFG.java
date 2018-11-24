package com;

/*package whatever //do not write package name here */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
class GFG {
    private static Scanner input;
	
	public static int BinarySearch (ArrayList<Integer> alist, int searchItem) {
	    int low = 0, high = alist.size()-1;
	    int mid = -1;
	    while (low<=high) {
	    	mid = low + ((high-low)/2);
	    	System.out.println("Mid : "+mid);
	        if (alist.get(mid)==searchItem)
	            return mid;
	        else if (searchItem>alist.get(mid)) {
	            low = mid+1;
	        }
	        else {
	        	high = mid-1;
	        }
	    }
	    if (searchItem < alist.get(mid))
	    	return mid;
	    else 
	    	return mid+1;
	}
	
	public static void main (String[] args) {
		input = new Scanner (System.in);
		int x = 0;
		ArrayList<Integer> alist = new ArrayList<Integer>();
		System.out.println("Enter array size : ");
		int size = input.nextInt();
		System.out.println("Enter the array : ");
		for (int i=0;i<size;i++) {
		    x = input.nextInt();
		    alist.add(x);
		}
		System.out.println("Enter item to be searched : ");
		int sitem = input.nextInt();
		System.out.println(BinarySearch (alist, sitem));
	}
}