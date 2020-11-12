package hw5;

public class AVLNode<T> {

	private AVLNode leftChild, rightChild, father;
	private int key;
	private int height;
	private T data;

	public AVLNode(int key, T data){
		this.key = key;
		this.data = data;
		this.height = 1;
	}
	
	public AVLNode<T> getLeftChild(){
		return this.leftChild;
	}

	public void setLeftChild(AVLNode newNode){
		this.leftChild = newNode;
	}
	
	public AVLNode<T> getRightChild(){
		return this.rightChild;
	}

	public void setRightChild(AVLNode newNode){
		this.rightChild = newNode;
	}
	
	public AVLNode<T> getFather(){
		return this.father;
	}
	
	public int getKey(){
		return this.key;
	}
	
	public T getData(){
		return this.data;
	}

	public int getHeight(){
		return this.height;
	}

	public void setHeight(int newHeight){
		this.height = newHeight;
	}

	@Override
	public String toString() {

		return String.valueOf(getKey());

//		String s = "";
//
//		if (getLeftChild() != null){
//			s+="(";
//			s+=getLeftChild().toString();
//			s+=")";
//		}
//		s+=getKey();
//
//		if (getRightChild() != null){
//			s+="(";
//			s+=getRightChild().toString();
//			s+=")";
//		}
//
//		return s;
//	}
}
}

