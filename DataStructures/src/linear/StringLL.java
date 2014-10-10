package linear;

import java.util.NoSuchElementException;

public class StringLL {
	
	// inner class
	public static class StringNode {
		String data;
		StringNode next;
		public StringNode(String data, StringNode next) {
			this.data = data;
			this.next = next;
		}
	}
	
	StringNode front;
	int size;
	
	public StringLL() {
		front = null;
		size = 0;
	}
	
	public void addToFront(String data) {
		front = new StringNode(data,front);
		size++;
	}
	
	public void delete(String target) 
	throws NoSuchElementException {
		StringNode ptr=front, prev=null;
		
		while (ptr != null && !ptr.data.equals(target)) {
			prev = ptr;
			ptr = ptr.next;
		}
		if (ptr == null) {
			throw new NoSuchElementException(target + " is not in list");
		} else if (ptr == front) {
			front = ptr.next;
			size--;
			return;
		}
		prev.next = ptr.next;
		size--;
	}
}
