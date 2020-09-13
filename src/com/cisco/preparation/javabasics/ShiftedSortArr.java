package com.cisco.preparation.javabasics;

public class ShiftedSortArr {
  static int shiftedArrSearch(int[] arr, int num) {
    int left = 0, right = arr.length - 1, mid;

    while(left <= right) {
      mid = left + (right - left) / 2;
      if(num == arr[mid])
        return mid;
      if(arr[left] < arr[mid]) {
        if(num > arr[left] && num < arr[mid]) {
          right = mid - 1;
        }else left = mid + 1;

      }else {
        if(num < arr[mid])
          right = mid - 1;
        else left = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {9, 12, 17, 2, 4, 5};
    System.out.println("Postion of 2 in the provided arr is: "+ ShiftedSortArr.shiftedArrSearch(arr, 2));

    for(int n: arr){
      for (int m:arr){
        System.out.println(n+":"+m);
      }
    }



  }


}