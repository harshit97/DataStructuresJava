package com.fakeorg.sortingAlgorithms;

public class QuickSort {
    //Lomuto Partitioning
    // Partition function considering the pivot to be the last
    // element of the array.
    private static int lomuto_partition(int arr[], int low, int high) {
        /*
            Chooses last element as pivot.
            Degrades to O(n2) when the array is already in sorted order.
         */
        int pivot = arr[high];
        int i = low, temp;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                //SWAP
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //END SWAP
                i++;
            }
        }
        //SWAP
        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        //END SWAP
        return i;
    }

    public static void quickSort(int arr[], int low, int high) {
        int partitionElementPosition;
        if (low < high) {
            partitionElementPosition = lomuto_partition(arr, low, high);
            quickSort(arr, low, partitionElementPosition - 1);
            quickSort(arr, partitionElementPosition + 1, high);
        }
    }
}
