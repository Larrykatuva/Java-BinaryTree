
public class Node {
	private int key;
	private int value;
	public Node leftChild;
	public Node rightChild;
	
	/**
	 * Class constructor
	 * @param key
	 * @param value
	 */
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	
	/**
	 * Get key
	 * @return key
	 */
	public int getKey() {
		return this.key;
	}
	
	/**
	 * Get value
	 * @return value
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Display node data
	 */
	public void displayNode() {
		System.out.println("Key =>"+this.key+" Value => "+this.value);
	}

}
