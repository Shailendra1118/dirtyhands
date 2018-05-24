/**
 * 
 */
package com.best.arrays;

/**
 * @author Shailendra
 *
 */
public class MinPower {

	/**
	 * @param args
	 */
	// Problem : Each array element represent power value; positive is power gain and negative is loss.
	// At any index if power value is 0 and negative that means our superhero dies and can not complete the enemy array
	// Find out the minimum power our superhero need at the start of the array

	public static void main(String[] args) {
		// int arr[] = { 10, -5, 4, -2, 3, 1, -1, -6, -1, 0, -5 };
		int arr[] = { 5, -5, 4, -2, 3, 1 };
		int min = 0;
		int total = 0;
		if (arr[0] < 0) {
			min = Math.abs(arr[0]) + 1;
			total = min;
		} else {
			total = arr[0];
			min = total;
		}

		for (int i = 1; i < arr.length; i++) {
			// total =
			if ((total + arr[i]) < 0) {
				min = min + Math.abs(total + arr[i]) + 1;
				total = total + min;
			} else if ((total + arr[i]) == 0) {
				min++;
			} else {
				total = total + arr[i];
			}
		}

		System.out.println("min: " + min);

	}

}
