/**
 * 
 */
package com.best.arrays;

/**
 * @author Shailendra
 *
 */
public class MaxSumWithNoAdjuscent {

	/**
	 * Problem : Find maxisum sum of subsequence so that no two elements are adjuscent to each other
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 5, 5, 10, 40, 50, 35 }; // { 5, 5, 10, 100, 10, 5 };

		// use dynamic programming approach
		int maxInc = arr[0];
		int maxExc = 0;

		for (int i = 1; i < arr.length; i++) {
			int oldMaxInc = maxInc;
			maxInc = Math.max(maxInc, maxExc + arr[i]);
			maxExc = oldMaxInc;
		}

		System.out.println("Max sum: " + Math.max(maxInc, maxExc));
	}

}
