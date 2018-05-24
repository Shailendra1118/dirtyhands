/**
 * 
 */
package com.best.java.fun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shailendra
 *
 */
public class TestGenerics {

	/**
	 * @param args
	 */
	// PECS
	// Producer extends & Consumer super
	// Producer here means that reads entities from the collection, adding not allowed from it
	public static void main(String[] args) {
		List<? extends Number> list = new ArrayList<>(); // client should be guaranteed to read Numbers
		// list.add(new Integer(100)); compile error
		// list.add(new Integer(200));
		// list.add(new Integer(300));

		for (Number i : list) {
			System.out.println(i);
		}

		List<? super Number> listOne = new ArrayList<>();
		listOne.add(new Integer(100));
		listOne.add(new Integer(200));
		listOne.add(new Integer(300));

		for (Object i : listOne) {
			System.out.println(i);
		}

		List<? super Child> l1 = getList(); // can be assiged though method returns 'List<? super Parent>'
		for (Object p : l1) {
			Parent per = (Parent) p; // easily type cast it as we know its going to be Child only
			System.out.println(per.val);
		}
		l1.add(new Child("c02"));

	}

	private static List<? super Parent> getList() {

		List<? super Parent> list = new ArrayList<>();
		list.add(new Parent("p1")); // can not add parent object
		list.add(new Child("c1"));
		list.add(new Child("c2"));

		// processId(list);
		return list;
	}

	/**
	 * @param list
	 */
	private static void processId(List<? super Parent> list) {

	}

	private static List<? extends Parent> getListAgain() {

		List<? extends Parent> list = new ArrayList<>();
		// list.add(new Parent("p1")); not allowed to add parent/child etc
		// list.add(new Child("c1"));
		for (Parent p : list) {

			System.out.println(p.val);
		}

		return list;
	}

}

// Utilities classes
class Parent {
	public String val;

	Parent(String v) {
		this.val = v;
	}

	public void getParentData() {
		System.out.println("getting parent");
	}
}

class Child extends Parent {
	public String val;

	Child(String v) {
		super(v);
		this.val = v;
	}

	public void getChildData() {
		System.out.println("getting child");
	}
}
