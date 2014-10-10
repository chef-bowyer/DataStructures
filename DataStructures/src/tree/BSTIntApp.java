package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BSTIntApp {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BSTIntNode root = null;
	
	public static BSTIntNode search(BSTIntNode root, int target) {
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

	public static BSTIntNode insert(BSTIntNode root, int target) {
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
		if (root == null) {
			return temp;
		} 
		if (left) { prev.left = temp; } 
		else { prev.right = temp; }
		return root;
	}
	
	public static BSTIntNode delete(BSTIntNode root, int target) {
		BSTIntNode x=root, p=null;
		// search and exception
		while (x!= null) { 
			if (target == x.data) {
				break;
			}
			p = x;
			x = target < x.data ?
					x.left : x.right;
		}
		if (x == null) {
			throw new 
			IllegalArgumentException();
		}

		// x has 2 children 
		if (x.left != null &&
				x.right != null) { 
			BSTIntNode y=x.left;
			p = x;
			while (y.right != null) {
				p = y;
				y = y.right;
			}
			x.data = y.data;
			x = y;
		}   

		// leaf and 1 child cases
		if (p == null) {
			return x.left != null ?
					x.left : x.right;
		} 
		BSTIntNode tmp = x.left != null ?
				x.left : x.right;
		if (x == p.right) {
			p.right = tmp;
		} else {
			p.left = tmp;
		} 
		return root;
	}

	public static void search() 
	throws IOException {
		System.out.print("Enter search value: ");
		int val = Integer.parseInt(br.readLine());
		BSTIntNode res = search(root, val);
		if (res == null) {
			System.out.println(val + " is not in tree");
		} else {
			if (res.data == val) {
				System.out.println(val + " FOUND!");
			}
		}
	}
	
	public static void insert() 
	throws IOException {
		System.out.print("Enter insert value: ");
		int val = Integer.parseInt(br.readLine());
		root = insert(root, val);
	}
	
	public static void delete() 
			throws IOException {
		System.out.print("Enter delete value: ");
		int val = Integer.parseInt(br.readLine());
		root = delete(root, val);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws IOException {
		// TODO Auto-generated method stub
		
		char choice='q';
		do {
			System.out.print("(i)nsert, (d)elete, (s)earch, or (q)uit?: ");
			String line = br.readLine();
			if (line.length() == 0) {
				continue;
			}
			choice = line.charAt(0);
			switch(choice) {
			case 'i': insert(); break;
			case 'd': delete(); break;
			case 's': search(); break;
			default: break;
			}
		} while (choice != 'q');
	}
}
