/**
 * 
 */
package com.best.binarytrees;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Shailendra
 *
 */
public class TwoSumBST {

	/**
	 * @param args
	 */
	// Problem : Give a number, find if there is a pair present in the BST with their sum equal to number.
	public static void main(String[] args) {

		Node root = new Node(5);
		Node n2 = new Node(2);
		Node n1 = new Node(1);
		Node n6 = new Node(6);
		Node n12 = new Node(12);
		Node n8 = new Node(8);

		root.left = n2;
		root.right = n8;
		n2.left = n1;
		n8.left = n6;
		n8.right = n12;

		// plain recursive
		inorder(root);
		System.out.println();
		inorderRev(root);

		solution(root, 17);
		System.out.println("Another solutions-");
		solutionSimpl(root, 17);

	}

	/**
	 * @param root
	 * @param i
	 */
	private static void solutionSimpl(Node node, int sum) {
		// Using two stacks similar to printing the BT zigzag fashion
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		int val1 = 0;
		int val2 = 0;
		boolean leftdone = false;
		boolean rightdone = false;
		Node lNode = node;
		Node rNode = node;

		while (true) {
			// left inorder
			while (leftdone == false) {
				if (lNode != null) {
					s1.push(lNode);
					lNode = lNode.left;
				} else {
					// if stack is empty
					if (s1.isEmpty()) {
						leftdone = true;
					} else {
						// process right
						lNode = s1.pop();
						val1 = lNode.value;
						lNode = lNode.right;
						leftdone = true;
					}
				}
			}

			// right inorder
			while (rightdone == false) {
				if (rNode != null) {
					s2.push(rNode);
					rNode = rNode.right;
				} else {
					if (s2.isEmpty()) {
						rightdone = true;
					} else {
						// process left
						rNode = s2.pop();
						val2 = rNode.value;
						rNode = rNode.left;
						rightdone = true;
					}
				}
			}

			if ((val1 != val2) && (val1 + val2 == sum)) {
				System.out.println("Found pair " + val1 + ", " + val2);
				break;
			} else if (val1 + val2 > sum) { // sum is greater move to second largest
				rightdone = false;
			} else if (val1 + val2 < sum) {
				leftdone = false;
			}

			if (val1 >= val2) {
				System.out.println("Not found");
				break;
			}

		}

	}

	private static class BSTIterator {
		Stack<Node> stk = new Stack<>();
		Node root = null;

		public BSTIterator(Node node) {
			this.root = node;
		}

		public boolean hasNext() {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			return !stk.isEmpty();
		}

		public Node next() {
			if (this.hasNext()) {
				Node n = stk.pop();
				root = n.left;
				return n;
			}
			throw new NoSuchElementException();
		}

		public Node peek() {
			return stk.peek();
		}
	}

	private static class BSTIteratorRev {
		Stack<Node> stk = new Stack<>();
		Node root = null;

		public BSTIteratorRev(Node node) {
			this.root = node;
		}

		public boolean hasNext() {
			while (root != null) {
				stk.push(root);
				root = root.right;
			}
			return !stk.isEmpty();
		}

		public Node next() {
			if (this.hasNext()) {
				Node n = stk.pop();
				root = n.right;
				return n;
			}
			throw new NoSuchElementException();
		}

		public Node peek() {
			return stk.peek();
		}
	}

	/**
	 * @param root
	 */
	private static void solution(Node root, int sum) {

		BSTIterator iter = new BSTIterator(root);
		BSTIteratorRev iterRev = new BSTIteratorRev(root);

		Node l = null;
		Node r = null;
		while (iter.hasNext() && iterRev.hasNext()) {
			Node left = iter.peek();
			Node right = iterRev.peek();
			if (left != null && right != null) {
				if (left.value + right.value == sum) {
					l = iter.next();
					r = iterRev.next();
					System.out.println("Present: " + l.value + ", " + r.value);
					break; // no need further traversal
				} else if (left.value + right.value < sum) {
					l = iter.next();
				} else {
					r = iterRev.next();
				}
			}

		}

	}

	/**
	 * @param root
	 */
	private static void inorderRev(Node node) {
		if (node != null) {
			inorderRev(node.right);
			System.out.print(node.value + " ");
			inorderRev(node.left);
		}

	}

	/**
	 * @param root
	 */
	private static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}

	}

}
