/**
 * 
 */
package com.best.arrays;

/**
 * @author Shailendra
 *
 */
public class FindIndexInDuplicat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 7, 7, 8 };
		System.out.println(arr.length);
		int M = 4;

		int lo = 0;
		int hi = arr.length - 1;
		int sidx = 0, eidx = 0;

		// find first occurance
		while (lo <= hi) {
			int mid = lo + hi >>> 1;
			if (arr[mid] == M) {
				sidx = mid;
				hi = mid - 1;
			} else if (arr[mid] > M) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println("first: " + sidx);
		lo = 0;
		hi = arr.length - 1;
		// find last occurance
		while (lo <= hi) {
			int mid = lo + hi >>> 1;
			if (arr[mid] == M) {
				eidx = mid;
				lo = mid + 1;
			} else if (arr[mid] > M) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println("last: " + eidx);

	}
}
