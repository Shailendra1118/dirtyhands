package com.best.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem :
 * Sort the ints from array and keep the other character as it is..
 */

/**
 * @author Shailendra
 *
 */

public class SortIntsFromString {

	public static void main(String args[]) {
		String str = "1 -1 3 a b # $ 5 -2 -9";
		// using Arraylist
		testMe(str);
		// using arrays
		testMeAgain(str);

		// TODO
		// should avoid the dependecy on Numberformat Exception and use
		// Characters.isDigit like API
	}

	/**
	 * @param str
	 */
	private static void testMeAgain(String str) {
		int digits[] = new int[str.length()];
		int id = 0;

		ArrayList<String> list = new ArrayList<>();

		String arr[] = str.split(" ");
		for (String cur : arr) {
			try {
				int digit = Integer.parseInt(cur);
				digits[id] = digit;
				id++;
			} catch (NumberFormatException e) {
				System.out.println("found word");
				list.add(cur);
			}
		}
		System.out.println("id " + id);
		System.out.println(Arrays.toString(digits));
		Arrays.sort(digits, 0, id);
		System.out.println("sorted " + Arrays.toString(digits));
		for (int i = 0; i < id; i++) {
			list.add(String.valueOf(digits[i]));
		}

		System.out.println(list);

	}

	public static void testMe(String input) {
		String arr[] = input.split(" ");
		int count = arr.length;

		int resi[] = new int[count]; // int array
		String resc[] = new String[count]; // char array
		int i = 0, j = 0;

		for (String c : arr) {
			try {
				int val = Integer.valueOf(c);
				resi[i++] = val;
			} catch (NumberFormatException e) {
				resc[j++] = c;
			}
		}

		Arrays.sort(resi, 0, i);
		System.out.println("resi: " + Arrays.toString(resi) + " with i " + i);
		// String farr[] = new String[input.length()]; no need,
		// can use char array

		System.out.println("resc: " + Arrays.toString(resc));
		int l = i;
		i = 0;
		for (int k = j; k < arr.length && i < l; k++) {
			resc[k] = String.valueOf(resi[i]);
			i++;
		}

		System.out.println(Arrays.toString(resc));
	}
}
