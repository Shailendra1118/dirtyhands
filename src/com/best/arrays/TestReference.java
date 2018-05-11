/**
 * 
 */
package com.best.arrays;

/**
 * @author Shailendra
 *
 */
public class TestReference {

	/**
	 * @param args
	 */
	// final volatile int value = 0; final is not allowed in volatile variable why ?

	public static void main(String[] args) {
		final int val = 0;
		XMan one = new XMan("one");
		XMan two = new XMan("two");

		XMan prev = one;
		XMan next = prev;
		prev = two;

		System.out.println(prev.power);
		System.out.println(next.power);
		System.out.println(one.power);
		System.out.println(two.power);

		next.power = "new";
		prev.power = "newer";

		System.out.println(prev.power);
		System.out.println(next.power);
		System.out.println(one.power);
		System.out.println(two.power);
	}

	static class XMan {
		/**
		 * @param string
		 */
		public XMan(String string) {
			this.power = string;
		}

		String power = "none";
	}

}
