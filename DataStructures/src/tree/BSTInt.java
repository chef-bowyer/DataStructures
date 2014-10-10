package tree;

public class BSTInt {
	private BSTIntNode root;
	int size;
	
	public BSTInt() {
		root = null;
		size = 0;
	}
	
	public BSTIntNode search(int target) {
		BSTIntNode ptr=root;
		while (ptr != null) { 
			if (target == ptr.data) {
				return ptr;
			}
			if (target < ptr.data) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
		}
		return null;
	}
	
	public void insert(int target) {
		BSTIntNode ptr=root, prev=null;
		boolean left=false;
		while (ptr != null) { 
			if (target == ptr.data) {
				throw new IllegalArgumentException();
			}
			prev = ptr;
			if (target < ptr.data) {
				ptr = ptr.left; left = true;
			} else {
				ptr = ptr.right;left = false;
			}
		}
		BSTIntNode temp = new BSTIntNode(target);
		size++;
		if (root == null) {
			root = temp;
			return;
		} 
		if (left) { prev.left = temp; } 
		else { prev.right = temp; }
	}
}
