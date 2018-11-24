package com.fakeorg;

import com.fakeorg.sortingAlgorithms.QuickSort;


import java.util.Arrays;
import java.util.Scanner;

public class SortTest {
    private static Scanner input;
    public static void main (String...args) {
        input = new Scanner(System.in);

        System.out.println("Enter array size : ");
        int array_size = input.nextInt();
        System.out.println("Enter "+array_size+" array elements : ");
        int array[] = new int[array_size];
        for (int i=0;i<array_size;i++) {
            array[i] = input.nextInt();
        }

        //QUICK SORT
        QuickSort.quickSort(array, 0, array_size-1);
        System.out.println("Sorted Array : "+Arrays.toString(array));
        //END QUICK SORT
    }
}
