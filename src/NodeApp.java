
public class NodeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree bt = new BinaryTree();
		bt.insertNode(23, 78);
		bt.insertNode(9, 100);
		bt.insertNode(10, 67);
		bt.insertNode(1, 81);
		bt.insertNode(99, 10);
		
		
		bt.inOrderTraversal(bt.root);
		
		System.out.println("\nFinding 9");
		bt.findNode(9).displayNode();
		
		System.out.println("\nFinding left most value");
		bt.minimumNode().displayNode();
		
		System.out.println("\nFinding right most value");
		bt.maximumNode().displayNode();
		
		System.out.println("\nDeliting 1");
		bt.deleteNode(10);
		
		bt.inOrderTraversal(bt.root);
	}

}
