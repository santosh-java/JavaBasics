package com.cisco.preparation.sorting;

/**
 * Created by MSantoshGiriGovind on 12/17/2016.
 */
public class HeapSortDescending {

    public static void main(String arg[]) {
        int[] arr = {12, 32, 23, 43,12, 1};
        HeapSortDescending hsd = new HeapSortDescending();
        hsd.printArray("Array before sorting", arr);
        hsd.heapSort(arr);
        hsd.printArray("Array after sorting", arr);
    }

    private void printArray(String s, int[] arr) {
        System.out.println("\n" + s);
        for(Integer i: arr)
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public void heapSort(int[] arr) {
        heapify(arr);
        int heapSize = arr.length - 1;
        for (int i = heapSize; i > 0; i--) {
            swap(arr, 0, i);
            heapSize--;
            minHeap(arr, 0, heapSize);
        }
    }

    public void heapify(int[] arr) {
        int startIndex = (arr.length / 2) - 1;

        for (int i = startIndex; i >= 0; i--) {
            minHeap(arr, i, arr.length - 1);
        }
    }

    private void minHeap(int[] arr, int i, int heapSize) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int smallest = i;

        if (left <= heapSize && arr[left] < arr[i])
            smallest = left;

        if (right <= heapSize && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {
            swap(arr, smallest, i);
            minHeap(arr, smallest, heapSize);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
