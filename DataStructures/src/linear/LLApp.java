package linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class LLApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws IOException {
		// TODO Auto-generated method stub
		IntNode front;   // right now front has null in it
		// so if you do this rightaway
		/*
		front = null;
		int x = front.data;
		*/
		// it will result in an exception (can't go to zero address)
		
		/*
		IntNode temp = new IntNode(2,null);
		front = temp;
		
		temp = new IntNode(5,null);
		temp.next = front;
		front = temp;
		
		temp = new IntNode(4,null);
		temp.next = front;
		front = temp;
		*/
		
		front = null;
		
		/*
		front = new IntNode(2,front);
		front = new IntNode(5,front);
		front = new IntNode(4,front);
		*/
		
		/*
		// add 2 to front
		front = addToFront(front, 2);
		System.out.println(front.data);
		// 2
		
		// add 5 to front
		front = addToFront(front, 5);
		System.out.println(front.data);
		// 5 --> 2
		
		// add 4 to front
		front = addToFront(front, 4);
		System.out.println(front.data);
		// 4 --> 5 --> 2
		
		System.out.println(front.next.data);  // 5
		System.out.println(front.next.next.data); // 2
		*/
		
		System.out.println("Adding 2");
		front = addToFront(front, 2);
		System.out.println("Linked List:");
		traverse(front);
	
		System.out.println("Adding 5");
		front = addToFront(front, 5);
		System.out.println("Linked List:");
		traverse(front);
		
		System.out.println("Adding 4");
		front = addToFront(front, 4);
		System.out.println("Linked List:");
		traverse(front);
		
		StringLL sll = new StringLL();
		sll.addToFront("5");
		sll.addToFront("4");
		
		// if you want to catch the exception and do something
		// with it, use try/catch
		
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			String line = br.readLine();
			
			sll.addToFront("10");
			sll.delete("3");
			sll.addToFront("25");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		} catch (IOException ioe) {
			System.out.println("IO Exception");
		}
		
		System.out.println("program continues...");
		
		// use generic LL
		LL<String> stringll = new LL<String>();
		stringll.addToFront("xyz");
		
		// primitives can be used as well
		// so long as you "wrap" them in the corresponding
		// wrapper class
		LL<Integer> intll = new LL<Integer>();
		intll.addToFront(5);  // 5 is auto boxed to Integer 5
		// intll.addToFront(new Integer(5)); // NOT NEEDED
		try {
			int y = intll.deleteFront();  // auto unboxing of return value
			// int z = intll.deleteFront().intValue(); // NO NEED
		} catch (NoSuchElementException e) {
			
		}
	}
	
	public static IntNode addToFront(IntNode front, int data) {
		return new IntNode(data,front);
	}
	
	public static IntNode deleteFront(IntNode front) {
		if (front == null) {
			return null;
		}
		return front.next;
	}
	
	public static void traverse(IntNode front) {
		if (front == null) {
			return;
		}
		
		System.out.print(front.data);
		for (IntNode ptr=front.next; ptr != null; ptr=ptr.next) {
			System.out.print(" --> ");
			System.out.print(ptr.data);
		}
		System.out.println();
	}

	public static boolean search(IntNode front, int target) {
		for (IntNode ptr=front; ptr != null; ptr=ptr.next) {
			if (target == ptr.data) {
				return true;
			}
		}
		return false;
	}
	
	public static IntNode delete(IntNode front, int target) {
		IntNode ptr=front, prev=null;
		
		while (ptr != null && ptr.data != target) {
			prev = ptr;
			ptr = ptr.next;
		}
		if (ptr == null) {
			return front;
		} else if (ptr == front) {
			return ptr.next;
		}
		prev.next = ptr.next;
		return front;
		
	}
}
