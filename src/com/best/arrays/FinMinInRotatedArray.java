/**
 * 
 */
package com.best.arrays;

/**
 * @author Shailendra
 *
 */
public class FinMinInRotatedArray {

	/**
	 * @param args
	 */
	// Problem : Find the minimum element in a rotated sorted array

	public static void main(String[] args) {
		// Binary Search approach
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int low = 0, hi = arr.length - 1, mid = 0;

		// Iterative binary search
		while (low < hi) {
			mid = low + (hi - low) / 2; // (low+hi)>>>1
			if (arr[low] < arr[mid] && arr[hi] < arr[mid]) {
				low = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		System.out.println("res: " + arr[mid]);
	}
}
