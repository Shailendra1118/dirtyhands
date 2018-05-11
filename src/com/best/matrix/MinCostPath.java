/**
 * 
 */
package com.best.matrix;

/**
 * @author Shailendra
 *
 */
public class MinCostPath {

	/**
	 * @param args
	 */
	// Problem : Find minimum cost path from a (0,0) cell to given cell (m,n) i.e. top left to bottom right cell.
	// You can move from down, right and diagonally right

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int m = cost.length;
		int n = cost[0].length;
		int res = minCostRec(cost, m - 1, n - 1); // passing index as 0,1,2 -> 3
		System.out.println("res: " + res);

		minCostPath(cost, m - 1, n - 1);

	}

	/**
	 * @param cost
	 */
	private static void minCostPath(int[][] cost, int m, int n) {
		// DP approach - bottom up manner
		int temp[][] = new int[m + 1][n + 1]; // setting up length, so m and n can be used as index in loops
		System.out.println("temp dimension r " + temp.length);
		System.out.println("temp dimension c " + temp[0].length);

		temp[0][0] = cost[0][0]; // first cell
		int i, j;
		// first column
		for (i = 1; i <= m; i++) {
			temp[i][0] = temp[i - 1][0] + cost[i][0];
		}

		// first row
		for (j = 1; j <= n; j++) {
			temp[0][j] = temp[0][j - 1] + cost[0][j];
		}

		for (i = 1; i <= m; i++) {
			for (j = 1; j <= n; j++) {
				temp[i][j] = Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]),
						temp[i - 1][j - 1]) + cost[i][j];
			}
		}

		System.out.println("res: " + temp[m][n]); // not i and j they are out of bound now

	}

	/**
	 * @param cost
	 */
	private static int minCostRec(int[][] cost, int m, int n) {

		if (m < 0 || n < 0)
			return Integer.MAX_VALUE;

		if (m == 0 && n == 0)
			return cost[m][n];
		else {
			return cost[m][n]
					+ Math.min(
							Math.min(minCostRec(cost, m - 1, n),
									minCostRec(cost, m, n - 1)),
							minCostRec(cost, m - 1, n - 1));
		}

	}
}
