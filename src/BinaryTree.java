
public class BinaryTree {
	public Node root;
	
	
	/**
	 * finding a node
	 * @param key
	 * @return Node
	 */
	public Node findNode(int key) {
		Node currentNode = this.root;
		while(currentNode.getKey() != key) {
			if(key < currentNode.getKey()) {
				currentNode = currentNode.leftChild;
			}else {
				currentNode = currentNode.rightChild;
			}
			if(currentNode == null) {
				return null;
			}
		}
		return currentNode;
	}
	
	
	/**
	 * Deleting a node
	 * @param key
	 * @return boolean
	 */
	public boolean deleteNode(int key) {
		Node parentNode = this.root;
		Node currentNode = this.root;
		boolean isLeftChild = true;
		while(currentNode.getKey() != key) {
			parentNode = currentNode;
			if(key < currentNode.getKey()) {
				isLeftChild = true;
				currentNode = currentNode.leftChild;
			}else {
				isLeftChild = false;
				currentNode = currentNode.rightChild;
			}
			if(currentNode == null) {
				return false;
			}
			if(currentNode.leftChild == null && currentNode.rightChild == null) {
				if(currentNode == this.root) {
					this.root = null;
				}else if(isLeftChild){
					parentNode.leftChild = null;
				}else {
					parentNode.rightChild = null;
				}
			}else if(currentNode.rightChild == null){
				if(currentNode == this.root) {
					this.root = currentNode.leftChild;
				}else if(isLeftChild){
					parentNode.leftChild = currentNode.leftChild;
				}else {
					parentNode.rightChild = currentNode.leftChild;
				}
			}else if(currentNode.leftChild == null) {
				if(currentNode == this.root) {
					this.root = currentNode.rightChild;
				}else if(isLeftChild) {
					parentNode.leftChild = currentNode.rightChild;
				}else {
					parentNode.rightChild = currentNode.rightChild;
				}
			}else {
				Node successorNode = this.getSuccessorNode(currentNode);
				if(currentNode == this.root) {
					this.root = successorNode;
				}else if(isLeftChild) {
					parentNode.leftChild = successorNode;
				}else {
					parentNode.rightChild = successorNode;
				}
				successorNode.leftChild = currentNode.leftChild;
			}
		}
		return true;
	}
	
	
	/**
	 * Getting the successor node
	 * @param delNode
	 * @return Node
	 */
	private Node getSuccessorNode(Node delNode)
	 {
		 Node successorParent = delNode;
		 Node successor = delNode;
		 Node current = delNode.rightChild;
		 while(current != null)
		 {
			 successorParent = successor;
			 successor = current;
			 current = current.leftChild;
		 }
		 if(successor != delNode.rightChild)
		 { 
			 successorParent.leftChild = successor.rightChild;
			 successor.rightChild = delNode.rightChild;
		 }
		 return successor;
	 }
	
	
	/**
	 * Getting the smallest node
	 * @return Node
	 */
	public Node minimumNode() {
		Node currentNode;
		Node lastNode = null;
		currentNode = this.root;
		while(currentNode != null) {
			lastNode = currentNode;
			currentNode = currentNode.leftChild;
		}
		return lastNode;
	}
	
	
	
	/**
	 * Getting the largest node
	 * @return Node
	 */
	public Node maximumNode() {
		Node currentNode = this.root;
		Node lastNode = null;
		while(currentNode != null) {
			lastNode = currentNode;
			currentNode = currentNode.rightChild;
		}
		return lastNode;
	}
	
	
	/**
	 * Inserting a node
	 * @param key
	 * @param value
	 */
	public void insertNode(int key, int value) {
		Node newNode = new Node(key, value);
		if(this.root == null) {
			this.root = newNode;
		}else {
			Node currentNode = this.root;
			Node parentNode;
			while(true) {
				parentNode = currentNode;
				if(key < currentNode.getKey()) {
					currentNode = currentNode.leftChild;
					if(currentNode == null) {
						parentNode.leftChild = newNode;
						return;
					}
				}else {
					currentNode = currentNode.rightChild;
					if(currentNode == null) {
						parentNode.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	
	/**
	 * In order tree traversal
	 * @param localRoot
	 */
	public void inOrderTraversal(Node localRoot) {
		if(localRoot != null) {
			this.inOrderTraversal(localRoot.leftChild);
			localRoot.displayNode();
			this.inOrderTraversal(localRoot.rightChild);
		}
	}
	
}
