/**
 * 
 */
package com.best.arrays;

import java.util.Arrays;

/**
 * @author Shailendra
 *
 */
public class MaxValueRodCut {

	/**
	 * @param args
	 */
	// Problem : Give a rod of length N, and array of prices for each size of rod, Find the rod size you would cut to
	// obtain the maximum value

	private static int dp[];

	public static void main(String[] args) {

		int n = 8;
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 }; // { 3, 5, 8, 9, 10, 17, 17, 20 };

		int val = cutRodRec(arr, n);
		System.out.println("Res: " + val);

		curRodBT(arr, n);
		// dp = new int[n + 1];
		// int res = cutRodRecTP(arr, n);
		// System.out.println("res:" + res);

	}

	/**
	 * @param arr
	 */
	private static void curRodBT(int[] arr, int n) {
		// DP approach Bottom Top, I like it ;)
		int dp[] = new int[n + 1];
		dp[0] = 0;

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < dp.length; i++) {
			max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) { // starting from first, 0th index
				max = Math.max(max, arr[j] + dp[i - j - 1]);
			}
			// set max value
			dp[i] = max;
		}

		System.out.println("DP Res " + dp[n] + " Arr: " + Arrays.toString(dp));
	}

	/**
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int cutRodRec(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
		if (n <= 0) {
			return 0;
		}

		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i] + cutRodRec(arr, n - i - 1));
		}

		return max;
	}

	/**
	 * @param arr
	 * @param n
	 * @return
	 */

	// Top to bottom DP approach
	private static int cutRodRecTP(int[] arr, int n) {
		if (dp[n] != 0) {
			return dp[n];
		}

		int max = Integer.MIN_VALUE;
		if (n <= 0) {
			return 0;
		}

		for (int i = 0; i < n; i++) {
			dp[i] = arr[i] + cutRodRec(arr, n - i - 1);
			max = Math.max(dp[i], max);
		}

		System.out.println(Arrays.toString(dp));
		System.out.println("max: " + max);
		return max;
	}
}
