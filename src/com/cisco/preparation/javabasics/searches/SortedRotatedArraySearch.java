package com.cisco.preparation.javabasics.searches;

/**
 * Given a sorted array in increasing order, that is rotated unknown number of times to left or right. And in that array,
 * find if a given number appears. If so return the position of the number. Otherwise -1
 * <p>
 * Solution:
 * Firstly, since the array is a sorted array, best approach for searching an element in it would be to use binary search.
 * But since the array is rotated, direct binary search will not work.
 * <p>
 * Lets take an example to illustrate the problem:
 * [11 13 15 17 5 7 9] is a sorted array and is rotated 4 times right.
 * <p>
 * If we observe closely, always, half of the array, either left or right is sorted. In above example, mid is 3 i.e. 17
 * and left part of the array i.e. 0-3 is sorted.
 * <p>
 * Since the left part is a sorted array, if we check whether the search element lies within the range of a[0] and a[3]
 * we can narrow our search to that.
 * Otherwise the search will have to be done in the other part i.e. a[4] - a[6].
 * <p>
 * If we apply the above logic we can find the element using binary search and the time complexity will be O(log n)
 */
public class SortedRotatedArraySearch {
  public int sortedRotatedArraySearch(int[] arr, int se) {
    int result = -1;

    if (arr == null || arr.length == 0) {
      return result;
    }
    int left = 0;
    int right = arr.length - 1;
    int mid;

    while (left <= right) {
      mid = left + (right - left) / 2;

      if (arr[mid] == se) { // Base case where
        result = mid;
        break;
      }

      if (arr[left] < arr[mid]) { // Array from arr[left] to arr[mid] is sorted.
        if (arr[left] <= se && arr[mid] > se) { // Search element lies within the sorted portion of the array i.e. arr[left] to arr[mid]
          right = mid - 1; // reducing the search portion to the sorted array
        } else { // Search element lies in the un-sorted portion of the array
          left = mid + 1; // reducing the search portion to the un-sorted array
        }
      } else { // Array from arr[mid] to arr[right] is sorted.
        if (arr[mid] < se && arr[right] >= se) { // Search element lies within the sorted portion of the array i.e. arr[mid] to arr[right]
          left = mid + 1; // reducing the search portion to the sorted array
        } else { // Search element lies within the un-sorted portion of the array
          right = mid - 1; // reducing the search portion to the un-sorted array
        }
      }
    }
    return result;
  }
}
