package linear;

import java.util.NoSuchElementException;

class Node<T> {
	T data;
	Node<T> next;
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
}

/* Generic linked list */
public class LL<T> {
	
	Node<T> front;
	int size;
	
	public LL() {
		front = null;
		size = 0;
	}
	
	public void addToFront(T data) {
		front = new Node<T>(data,front);
		size++;
	}
	
	public T deleteFront() 
	throws NoSuchElementException {
		if (front == null) {
			throw new NoSuchElementException("list is empty!");
		}
		T hold = front.data;
		front = front.next;
		size--;
		return hold;
	}
	
	public void delete(T target) 
	throws NoSuchElementException {
		Node<T> ptr=front, prev=null;
		
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
