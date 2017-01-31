package com.cisco.preparation.sorting;

/**
 * Created by MSantoshGiriGovind on 12/17/2016.
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {10, 25, 15, 20, 30};

        System.out.println("Array before heap sort ascending order:");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        HeapSort hs = new HeapSort();
        hs.heapSortAscending(arr);

        System.out.println("\n Array after heap sort ascending order:");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println("\n Array before heap sort descending order:");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        hs.heapSortDescending(arr);

        System.out.println("\n Array after heap sort descending order:");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public void heapSortAscending(int[] array) {
        heapify(array, true);

        int heapSize = array.length - 1;
        for (int i = heapSize; i > 0; i--) {
            swap(array, 0, i);
            heapSize--;
            maxHeap(array, 0, heapSize);
        }
    }

    public void heapSortDescending(int[] array) {
        heapify(array, false);

        int heapSize = array.length - 1;
        for (int i = heapSize; i > 0; i--) {
            swap(array, 0, i);
            heapSize--;
            minHeap(array, 0, heapSize);
        }
    }

    private void heapify(int[] array, boolean isAscending) {
        int startIndex = (array.length / 2) - 1;
        for (int i = startIndex; i >= 0; i--) {
            if (isAscending) {
                maxHeap(array, i, array.length - 1);
            } else {
                minHeap(array, i, array.length - 1);
            }
        }
    }

    private void minHeap(int[] array, int i, int heapSize) {
        int left = (2*i) + 1;
        int right = (2*i) + 2;
        int smallest = i;

        if(left <= heapSize && array[left] < array[i])
            smallest = left;

        if(right <= heapSize && array[right] < array[smallest])
            smallest = right;

        if(smallest != i) {
            swap(array, smallest, i);
            minHeap(array, smallest, heapSize);
        }
    }

    private void maxHeap(int[] array, int i, int heapSize) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int largest = i;

        if (left <= heapSize && array[left] > array[i]) {
            largest = left;
        }

        if (right <= heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            maxHeap(array, largest, heapSize);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
