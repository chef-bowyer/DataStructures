package linear;

public class CLLApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntNode rear=null;

	}
	
	public static IntNode addToFront(IntNode rear, int data) {
		IntNode temp = new IntNode(data, null);
		if (rear == null) {
			temp.next = temp;
			return temp;
		}
		temp.next = rear.next;
		rear.next = temp;
		return rear;
	}
	
	public static boolean search(IntNode rear, int target) {
		/* V1
		if (rear == null) {
			return false;
		}
		if (rear.data == target) {
			return true;
		}
		for (IntNode ptr=rear.next; ptr != rear; ptr=ptr.next) {
			if (target == ptr.data) {
				return true;
			}
		}
		return false;
		*/
		
		if (rear == null) {
			return false;
		}
		IntNode ptr=rear;
		do {
			if (ptr.data == target) {
				return true;
			}
			ptr = ptr.next;
		} while (ptr != rear);
		return false;
	}
	
	public static IntNode delete(IntNode rear, int target) {
		if (rear == null) {
			return null;
		}
		if (rear.next == rear) {
			/*
			if (rear.data == target) {
				return null;
			} else {
				return rear;
			}*/
			// ternary operator
			return rear.data == target ? null : rear;
		}
		
		IntNode ptr=rear.next, prev=rear;
		
		// find the target
		do {
			if (ptr.data == target) {
				break;
			}
			prev = ptr;
			ptr = ptr.next;
		} while (ptr != rear.next);
		
		if (ptr.data != target) {
			return rear;
		}
		
		prev.next = ptr.next;
		if (ptr == rear) {
			return prev;
		}
		return rear;
		
	}

}
