package com.greatlearning.question2;



//represent node of tree 
class Node {
	public int data;
	public Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}
public class TransactionManager {
	public Node bstRoot; // hard coded BST trees root
	private Node helperNode = null;// Node pointer used to move around skew tree 
	public Node skewroot = null; //skew tree head;

	private void BstToSkew(Node curr) {
		// Base condition for terminating recurssion
		if (curr == null)
			return;

		// loop till extreme left
		BstToSkew(curr.left);

		// update new head to skew root and update helperNode value
		if (skewroot == null) {
			skewroot = curr; // root skew
			curr.left = null;
			helperNode = curr; // will move to create skew tree
		} else {
			// update the right of the skew tree current Node and update HelperNode
			helperNode.right = curr;
			curr.left = null;
			helperNode = curr;
		}

		BstToSkew(curr.right);
	}
	//BST traversal
	private void bstInorder(Node curr) {

		if (curr != null) {
			bstInorder(curr.left);
			System.out.print(curr.data + " ");
			bstInorder(curr.right);
		}
	}
	private void skewInorder(Node curr) {

		if (curr != null) {
			skewInorder(curr.left);
			System.out.print(curr.data + " ");
			skewInorder(curr.right);
		}
	}
	// solution method
	public void solution() {
		 TransactionManager tree = new TransactionManager();
		tree.bstRoot = new Node(50);
		tree.bstRoot.left = new Node(30);
		tree.bstRoot.right = new Node(60);
		tree.bstRoot.left.left = new Node(10);
		tree.bstRoot.right.left = new Node(55);
		
		tree.BstToSkew(tree.bstRoot);
		tree.skewInorder(tree.skewroot);
	}
}
