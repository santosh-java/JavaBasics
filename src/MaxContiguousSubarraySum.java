import java.util.Scanner;

public class MaxContiguousSubarraySum {
	public static void main(String[] args) {
		// int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		// -2 -3 4 -1 -2 1 5 -3
		int[] arr = getArrayFromInput();
		System.out.println("Max contiguous subarray sum is: " + maxContiguousSubarraySum(arr));
	}

	public static int[] getArrayFromInput() {
		Scanner s = new Scanner(System.in);
		try {
			int arrSize = s.nextInt();
			int[] arr = new int[arrSize];

			for (int i = 0; i < arrSize; i++) {
				arr[i] = s.nextInt();
			}
			return arr;
		} finally {
			s.close();
		}
	}

	public static int maxContiguousSubarraySum(int[] array) {
		int size = array.length;
		int currMaxSum = array[0];
		int maxSumTillNow = array[0];
		int subStart = 0;
		int subEnd = 0;

		for (int i = 1; i < size; i++) {
			currMaxSum += array[i];

			if (currMaxSum < 0) {
				currMaxSum = 0;
				subStart = i+1;
			}

			if (maxSumTillNow < currMaxSum) {
				maxSumTillNow = currMaxSum;
				subEnd = i;
			}
		}
		System.out.println("Subarray start : " + subStart + " - end : " + subEnd);
		return maxSumTillNow;
	}
}
