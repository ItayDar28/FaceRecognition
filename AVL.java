package hw5;

import java.util.ArrayList;

public class AVL<T> {

	private AVLNode root;

	public void insert(int key, T data) {
		this.root = insert(this.root, key, data);
	}

	private AVLNode insert(AVLNode node, int key, T data) {

		// base case - if the node is empty, enter new node to the empty node.
		if (node == null) {
			AVLNode newNode = new AVLNode<ObjectPoint>(key, (ObjectPoint) data);
			return newNode;
		}

		if (key > node.getKey()) {
			node.setRightChild(insert(node.getRightChild(), key, data));
		} else if (key < node.getKey()) {
			node.setLeftChild(insert(node.getLeftChild(), key, data));
		}

		node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);

		int balance = getBalance(node);

		// LL Case
		if (balance > 1 && key < node.getLeftChild().getKey()) {
			return rightRotate(node);
		}

		// RR Case
		if (balance < -1 && key > node.getRightChild().getKey()) {
			return leftRotate(node);
		}

		// LR Case
		if (balance > 1 && key > node.getLeftChild().getKey()) {
			node.setLeftChild(leftRotate(node.getLeftChild()));
			return rightRotate(node);
		}

		// RL Case
		if (balance < -1 && key < node.getRightChild().getKey()) {
			node.setRightChild(rightRotate(node.getRightChild()));
			return leftRotate(node);
		}
		return node;

	}

	private int height(AVLNode node) {
		if (node == null) {
			return 0;
		}

		return node.getHeight();
	}

	private int getBalance(AVLNode node) {
   		if (node == null) {
			return 0;
		}

		return height(node.getLeftChild()) - height(node.getRightChild());
	}

	private AVLNode rightRotate(AVLNode y) {

		AVLNode x = y.getLeftChild();
		AVLNode z = x.getRightChild();

		// rotate
		x.setRightChild(y);
		y.setLeftChild(z);

		// ht update
		y.setHeight(Math.max(height(y.getLeftChild()), height(y.getRightChild())) + 1);
		x.setHeight(Math.max(height(x.getLeftChild()), height(x.getRightChild())) + 1);

		return x;
	}

	private AVLNode leftRotate(AVLNode y) {

		AVLNode x = y.getRightChild();
		AVLNode z = x.getLeftChild();

		// rotate
		x.setLeftChild(y);
		y.setRightChild(z);

		// ht update
		y.setHeight(Math.max(height(y.getLeftChild()), height(y.getRightChild())) + 1);
		x.setHeight(Math.max(height(x.getLeftChild()), height(x.getRightChild())) + 1);

		return x;
	}

	public AVLNode getRoot() {
		return this.root;
	}

	public T search(int key) {
		// base case, if key equals to root key.
		AVLNode curNode = this.root;
		while (root != null){
			if (curNode.getKey() == key){
				break;
			}
			if (curNode.getKey() < key)
				curNode = curNode.getRightChild();
			if (curNode.getKey() > key)
				curNode = curNode.getLeftChild();
		}

		return (T) curNode.getData();
	}

	public ArrayList<ObjectPoint> range(int a, int b){
		ArrayList<ObjectPoint> arr = new ArrayList<ObjectPoint>();
		rangeRec(this.root,a,b,arr);
		return arr;
	}

	private void rangeRec(AVLNode node, int a, int b, ArrayList<ObjectPoint> arr){
		if (node == null){
			return;
		}
		if (node.getKey() >= a && node.getKey() <= b){
			rangeRec(node.getLeftChild(),a,b,arr);
			arr.add((ObjectPoint) node.getData());
			rangeRec(node.getRightChild(),a,b,arr);
			return;
		}
		if (node.getKey() < a && node.getRightChild() != null){
			rangeRec(node.getRightChild(),a,b,arr);
		}
		else if (node.getKey() > b && node.getLeftChild() != null)
			rangeRec(node.getLeftChild(),a,b,arr);
		else{
		    return;
        }

	}


}
