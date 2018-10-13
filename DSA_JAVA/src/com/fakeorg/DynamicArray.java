package com.fakeorg;

import java.util.Arrays;
import java.util.Scanner;

class DynamicArrayImplementation {
    private int size = 1;
    private int arr[] = new int[size];
    private int counter = 0;

    public void add (int element) {
        if (counter==size) {
            size *= 2;
            final int[] temp = new int[size];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
            System.out.println("Array size doubled !!");
        }
        arr[counter] = element;
        counter++;
    }



    @Override
    public String toString() {
        return "DynamicArrayImplementation{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                ", counter=" + counter +
                '}';
    }
}
public class DynamicArray {
    private static Scanner input;
    public static void main (String...args) {
        input = new Scanner(System.in);
        DynamicArrayImplementation newArr = new DynamicArrayImplementation();
        int element = input.nextInt();
        while(element!=-1 && element!=0) {
            element = input.nextInt();
            newArr.add(element);
        }
        System.out.println(newArr);
    }
}
