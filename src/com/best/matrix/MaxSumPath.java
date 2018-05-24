/**
 * 
 */
package com.best.matrix;

/**
 * @author Shailendra
 *
 */
public class MaxSumPath {

	/**
	 * @param args
	 */

	// Problem: You are given a matrix with each cell containing number of rocks you can collect.
	// Starting from bottom left, you have to reach top right while collecting maximum rocks.
	// You can only travel up and right.
	public static void main(String[] args) {
		Integer[][] grid = { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 },
				{ 2, 0, 0, 0, 0 } };

		int m = grid.length;
		int n = grid[0].length;
		System.out.println("Rows " + m);
		System.out.println("Col " + n);

		int temp[][] = new int[m][n];
		// start from bottom left
		temp[m - 1][0] = grid[m - 1][0];

		// first column
		for (int i = m - 2; i >= 0; i--) {
			temp[i][0] = temp[i + 1][0] + grid[i][0];
		}

		// last row
		for (int j = 1; j < n; j++) {
			temp[m - 1][j] = temp[m - 1][j - 1] + grid[m - 1][j];
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = 1; j < n; j++) {
				temp[i][j] = Math.max(temp[i + 1][j], temp[i][j - 1])
						+ grid[i][j];
			}
		}

		display(temp);
		System.out.println("Maximum: " + temp[0][n - 1]);
	}

	/**
	 * @param temp
	 */
	private static void display(int[][] temp) {
		int row = temp.length;
		int col = temp[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}

	}

}
